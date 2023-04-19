package com.portfolio.Portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.Portfolio.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
}
