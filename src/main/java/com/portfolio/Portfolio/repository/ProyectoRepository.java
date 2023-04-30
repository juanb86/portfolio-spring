package com.portfolio.Portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.Portfolio.model.Proyecto;

public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {
}