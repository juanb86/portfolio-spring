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
public class Proyecto {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String cliente;
  private String nombre;
  private String tecnologias;
  private String fechaInicio;
  private String fechaFin;
  private String descripcion;
  private String foto;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  @JsonIgnore
  private User user;

  public Proyecto() {
  }

  public Proyecto(Long id, String cliente, String nombre, String tecnologias, String fechaInicio, String fechaFin,
      String descripcion, String foto, User user) {
    this.id = id;
    this.cliente = cliente;
    this.nombre = nombre;
    this.tecnologias = tecnologias;
    this.fechaInicio = fechaInicio;
    this.fechaFin = fechaFin;
    this.descripcion = descripcion;
    this.foto = foto;
    this.user = user;
  }

}