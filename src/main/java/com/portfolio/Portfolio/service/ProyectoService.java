package com.portfolio.Portfolio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.Portfolio.model.Proyecto;
import com.portfolio.Portfolio.repository.ProyectoRepository;

@Service
public class ProyectoService implements IProyectoService {

  @Autowired
  private ProyectoRepository proyectoRepository;

  @Override
  public List<Proyecto> verProyectos() {
    return proyectoRepository.findAll();
  }

  @Override
  public void crearProyecto(Proyecto proyecto) {
    proyectoRepository.save(proyecto);
  }

  @Override
  public void borrarProyecto(Long id) {
    proyectoRepository.deleteById(id);
  }

  @Override
  public Proyecto buscarProyecto(Long id) {
    return proyectoRepository.findById(id).orElse(null);
  }

}
