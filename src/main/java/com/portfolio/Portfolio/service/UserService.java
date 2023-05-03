package com.portfolio.Portfolio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.portfolio.Portfolio.model.User;
import com.portfolio.Portfolio.repository.UserRepository;

@Service
public class UserService implements IUserService {

  @Autowired
  public UserRepository userRepository;

  @Override
  public void register(User user) {
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    String encodedPassword = passwordEncoder.encode(user.getPassword());
    user.setPassword(encodedPassword);

    userRepository.save(user);
  }
}
