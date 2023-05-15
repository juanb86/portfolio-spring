package com.portfolio.Portfolio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.Portfolio.model.Educacion;
import com.portfolio.Portfolio.model.User;

public interface EducacionRepository extends JpaRepository<Educacion, Long> {
  List<Educacion> findByUser(User user);
}
