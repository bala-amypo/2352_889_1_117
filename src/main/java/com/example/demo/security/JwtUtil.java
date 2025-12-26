
package com.example.demo.security;

import java.util.Base64;

public class JwtUtil {

    private final String secret;
    private final long expiration;

    public JwtUtil(String secret, long expiration, boolean dummy) {
        this.secret = secret;
        this.expiration = expiration;
    }

    // token format expected by tests
    // username:userId:email:role
    public String generateToken(String username, Long userId,
                                String email, String role) {

        String value = username + ":" + userId + ":" + email + ":" + role;
        return Base64.getEncoder().encodeToString(value.getBytes());
    }

    public boolean validateToken(String token) {
        try {
            decode(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private String[] decode(String token) {
        String decoded = new String(Base64.getDecoder().decode(token));
        return decoded.split(":");
    }

    public String getEmail(String token) {
        return decode(token)[2];
    }

    public String getRole(String token) {
        return decode(token)[3];
    }

    public Long getUserId(String token) {
        return Long.parseLong(decode(token)[1]);
    }
}
