package com.portfolio.Portfolio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.Portfolio.model.Persona;
import com.portfolio.Portfolio.model.Proyecto;

public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {
  List<Proyecto> findByPersona(Persona persona);

}