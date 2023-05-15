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
public class Habilidad {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String nombre;
  private int porcentaje;
  private String descripcion;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  @JsonIgnore
  private User user;

  public Habilidad() {
  }

  public Habilidad(Long id, String nombre,
      int porcentaje, String especialidad, String fechaInicio,
      String descripcion) {
    this.id = id;
    this.nombre = nombre;
    this.porcentaje = porcentaje;
    this.descripcion = descripcion;
  }

}