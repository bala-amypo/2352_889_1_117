
package com.example.demo.security;

public class SimplePasswordEncoder {

    public String encode(String raw) {
        return "ENC_" + raw;
    }
}
