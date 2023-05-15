package com.portfolio.Portfolio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Experiencia {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String cliente;
  private String ocupacion;
  private String descripcion;
  private String tecnologias;
  private String fechaInicio;
  private String fechaFin;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  @JsonIgnore
  private User user;

  public Experiencia() {
  }

  public Experiencia(Long id,
      String cliente, String ocupacion,
      String descripcion,
      String tecnologias, String fechaInicio, String fechaFin,
      User user) {
    this.id = id;
    this.cliente = cliente;
    this.ocupacion = ocupacion;
    this.descripcion = descripcion;
    this.tecnologias = tecnologias;
    this.fechaInicio = fechaInicio;
    this.fechaFin = fechaFin;
    this.user = user;
  }

}