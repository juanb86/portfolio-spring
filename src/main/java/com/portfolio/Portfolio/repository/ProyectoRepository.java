package com.portfolio.Portfolio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.Portfolio.model.Proyecto;
import com.portfolio.Portfolio.model.User;

public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {
  List<Proyecto> findByUser(User user);
}
