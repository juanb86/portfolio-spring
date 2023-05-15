package com.portfolio.Portfolio.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.portfolio.Portfolio.repository.UserRepository;

// import static org.springframework.security.config.Customizer.withDefaults;
import com.portfolio.Portfolio.security.JwtTokenFilter;

import jakarta.servlet.http.HttpServletResponse;

@Configuration
public class SecurityConfig {

  @Autowired
  private UserRepository userRepo;
  @Autowired
  private JwtTokenFilter jwtTokenFilter;

  @Bean
  public UserDetailsService userDetailsService() {
    return new UserDetailsService() {

      @Override
      public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByEmail(username)
            .orElseThrow(
                () -> new UsernameNotFoundException("User " + username + " not found"));
      }
    };
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public AuthenticationManager authenticationManager(
      AuthenticationConfiguration authConfig) throws Exception {
    return authConfig.getAuthenticationManager();
  }

  @Bean
  public SecurityFilterChain configure(HttpSecurity http) throws Exception {

    http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

    // http.authorizeHttpRequests().anyRequest().permitAll();
    http.cors().and()
        .csrf().disable().authorizeHttpRequests()
        .requestMatchers("/auth/login", "/auth/register")
        .permitAll()
        .requestMatchers(HttpMethod.GET, "/persona/**",
            "/educacion/**")
        .permitAll()
        .anyRequest().authenticated();

    http.exceptionHandling()
        .authenticationEntryPoint(
            (request, response, ex) -> {
              response.sendError(
                  HttpServletResponse.SC_UNAUTHORIZED,
                  ex.getMessage());
            });

    http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);

    return http.build();
  }

}