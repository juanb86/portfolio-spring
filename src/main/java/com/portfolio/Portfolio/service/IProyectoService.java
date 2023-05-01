package com.portfolio.Portfolio.service;

import java.util.List;

import com.portfolio.Portfolio.model.Proyecto;

public interface IProyectoService {

  public List<Proyecto> verProyectos(Long id);

  public void crearProyecto(Proyecto proyecto,Long id);

  public void borrarProyecto(Long id);

  public Proyecto buscarProyecto(Long id);

}