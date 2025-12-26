
package com.example.demo.security;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class JwtUtil {

    private final String secret;
    private final long expiration;

    public JwtUtil(String secret, long expiration, boolean dummy) {
        this.secret = secret;
        this.expiration = expiration;
    }

    // token format: username|userId|email|role
    public String generateToken(String username, Long userId,
                                String email, String role) {

        String raw = username + "|" + userId + "|" + email + "|" + role;
        return Base64.getEncoder()
                .encodeToString(raw.getBytes(StandardCharsets.UTF_8));
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
        String decoded = new String(
                Base64.getDecoder().decode(token),
                StandardCharsets.UTF_8
        );
        return decoded.split("\\|");
    }

    public String getEmail(String token) {
        return decode(token)[2];
    }

    public String getRole(String token) {
        return decode(token)[3];
    }

    public Long getUserId(String token) {
        return Long.valueOf(decode(token)[1]);
    }
}
