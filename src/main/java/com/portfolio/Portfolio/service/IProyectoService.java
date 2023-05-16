package com.portfolio.Portfolio.service;

import java.util.List;

import com.portfolio.Portfolio.model.Proyecto;

public interface IProyectoService {

  public void crearProyecto(Integer idUser, Proyecto proyecto);

  public List<Proyecto> obtenerProyecto(Integer idUser);

  public void modificarProyecto(Integer idUser, Long id, Proyecto proyecto);

  public void borrarProyecto(Long id);

}
