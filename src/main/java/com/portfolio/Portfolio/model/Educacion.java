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
public class Educacion {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String institucion;
  private String titulo;
  private String especialidad;
  private String fechaInicio;
  private String fechaFin;
  private String descripcion;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  @JsonIgnore
  private User user;

  public Educacion() {
  }

  public Educacion(Long id, String institucion, String titulo, String especialidad, String fechaInicio, String fechaFin,
      String descripcion, User user) {
    this.id = id;
    this.institucion = institucion;
    this.titulo = titulo;
    this.especialidad = especialidad;
    this.fechaInicio = fechaInicio;
    this.fechaFin = fechaFin;
    this.descripcion = descripcion;
    this.user = user;
  }

}