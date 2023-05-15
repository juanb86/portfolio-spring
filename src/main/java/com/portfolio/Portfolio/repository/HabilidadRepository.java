package com.portfolio.Portfolio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.Portfolio.model.Habilidad;
import com.portfolio.Portfolio.model.User;

public interface HabilidadRepository extends JpaRepository<Habilidad, Long> {
  List<Habilidad> findByUser(User user);
}
