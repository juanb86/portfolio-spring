package com.portfolio.Portfolio.model;

import jakarta.persistence.Entity;
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
public class Proyecto {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String nombre;
  private String descripcion;

  @ManyToOne
  @JoinColumn(name = "persona_id", nullable = false)
  private Persona persona;

  public Proyecto() {
  }

  public Proyecto(Long id, String nombre, String descripcion, Persona persona) {
    this.id = id;
    this.nombre = nombre;
    this.descripcion = descripcion;
    this.persona = persona;
  }

}