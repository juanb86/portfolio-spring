package com.portfolio.Portfolio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.Portfolio.model.Persona;
import com.portfolio.Portfolio.model.User;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
  List<Persona> findByUser(User user);
}
