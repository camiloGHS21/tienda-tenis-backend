package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;




@Configuration
@EnableWebSecurity
public class SecurityConfig {

	
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    	
    	http
        .csrf().disable() // Deshabilitar CSRF si estás trabajando con APIs
        .authorizeHttpRequests(authorize -> authorize
            .requestMatchers(
            		"/api/productos/**",
            		"/api/cart/**",
            		"/api/usuarios/**"
            		).permitAll()
            .anyRequest().authenticated()
        )
        .httpBasic(); // Habilita la autenticación básica

        return http.build();
    }

    @Bean
    public org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration authenticationConfiguration() {
        return new org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration();
    }
    // Bean para exponer el AuthenticationManager
    @Bean
    public org.springframework.security.authentication.AuthenticationManager authenticationManager(
            org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}