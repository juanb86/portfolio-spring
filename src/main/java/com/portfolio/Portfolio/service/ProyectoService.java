package com.portfolio.Portfolio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.Portfolio.model.Persona;
import com.portfolio.Portfolio.model.Proyecto;
import com.portfolio.Portfolio.repository.PersonaRepository;
import com.portfolio.Portfolio.repository.ProyectoRepository;

@Service
public class ProyectoService implements IProyectoService {

  @Autowired
  private ProyectoRepository proyectoRepository;

  @Autowired
  private PersonaRepository personaRepository;

  @Override
  public List<Proyecto> verProyectos(Long id) {

    Persona persona = personaRepository.findById(id).orElse(null);

    return proyectoRepository.findByPersona(persona);
  }

  @Override
  public void crearProyecto(Proyecto proyecto, Long id) {

    Persona persona = personaRepository.findById(id).orElse(null);

    proyecto.setPersona(persona);

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
