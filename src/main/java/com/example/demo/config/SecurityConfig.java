
package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.context.annotation.Bean;

@Configuration
public class SecurityConfig {

   @Bean
public UserDetailsService userDetailsService(PasswordEncoder encoder) {
    UserDetails user = User.withUsername("admin")
            .password(encoder.encode("admin123"))
            .roles("ADMIN")
            .build();
    return new InMemoryUserDetailsManager(user);
}
}