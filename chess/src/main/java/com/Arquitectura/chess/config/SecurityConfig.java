package com.Arquitectura.chess.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    //primera configuracion
    /*@Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("api/users/verificarUsuarios").permitAll()
                                .requestMatchers("api/users/crear").permitAll()
                                .anyRequest().authenticated()
                )
                .formLogin(formLogin ->
                        formLogin
                                .permitAll()
                );

        return httpSecurity.build();
    }*/
@Bean
public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
    httpSecurity
            .authorizeHttpRequests(authorizeRequests ->
                    authorizeRequests
                            .requestMatchers("/verificarUsuarios", "/public/**").permitAll()
                            .anyRequest().authenticated()
            )
            .formLogin(formLogin ->
                    formLogin
                            .loginPage("/login")      // Especifica una página de inicio de sesión personalizada
                            .permitAll()              // Permite acceso a la página de inicio de sesión a todos
            );

    return httpSecurity.build();
}
}
