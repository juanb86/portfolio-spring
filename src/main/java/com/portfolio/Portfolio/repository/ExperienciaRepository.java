package com.portfolio.Portfolio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.Portfolio.model.Experiencia;
import com.portfolio.Portfolio.model.User;

public interface ExperienciaRepository extends JpaRepository<Experiencia, Long> {
  List<Experiencia> findByUser(User user);
}
