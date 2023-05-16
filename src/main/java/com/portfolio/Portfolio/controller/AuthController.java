package com.portfolio.Portfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.portfolio.Portfolio.model.User;
import com.portfolio.Portfolio.security.AuthRequest;
import com.portfolio.Portfolio.security.AuthResponse;
import com.portfolio.Portfolio.security.JwtTokenUtil;
import com.portfolio.Portfolio.service.IUserService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin
public class AuthController {

  @Autowired
  AuthenticationManager authManager;

  @Autowired
  JwtTokenUtil jwtUtil;

  @Autowired
  private IUserService userService;

  @GetMapping("/hola")
  public String decirHola() {
    return "Hola";
  }

  @PostMapping("/auth/login")
  public ResponseEntity<?> login(@RequestBody @Valid AuthRequest request) {
    try {
      Authentication authentication = authManager.authenticate(
          new UsernamePasswordAuthenticationToken(
              request.getEmail(), request.getPassword()));

      User user = (User) authentication.getPrincipal();
      String accessToken = jwtUtil.generateAccessToken(user);
      AuthResponse response = new AuthResponse(user.getEmail(), accessToken);

      return ResponseEntity.ok().body(response);

    } catch (BadCredentialsException ex) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
  }

  @PostMapping("/auth/register")
  public void register(@RequestBody User user) {
    userService.register(user);
  }
}