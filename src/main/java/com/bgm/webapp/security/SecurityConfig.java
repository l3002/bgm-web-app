package com.bgm.webapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig {

  // private final UserRepository userRepository;

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(
            authorizeHttpRequestsCustomize -> authorizeHttpRequestsCustomize
                .requestMatchers("/").permitAll()
                .anyRequest().authenticated());
    return http.build();
  }

  /*
   * @Bean
   *
   * public UserDetailsService userDetailsService(){
   *
   * return (username) -> userRepository.
   * }
   *
   */
}
