package com.portfolio.Portfolio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.Portfolio.model.Proyecto;
import com.portfolio.Portfolio.model.User;
import com.portfolio.Portfolio.repository.ProyectoRepository;
import com.portfolio.Portfolio.repository.UserRepository;

@Service
public class ProyectoService implements IProyectoService {

  @Autowired
  public ProyectoRepository proyectoRepo;

  @Autowired
  public UserRepository userRepo;

  @Override
  public void crearProyecto(Integer idUser, Proyecto proyecto) {

    User user = userRepo.findById(idUser).orElse(null);

    proyecto.setUser(user);

    proyectoRepo.save(proyecto);
  }

  @Override
  public void modificarProyecto(Integer idUser, Long idProyecto, Proyecto proyecto) {

    User user = userRepo.findById(idUser).orElse(null);

    if (user == null) {
      return;
    }

    proyecto.setUser(user);
    proyecto.setId(idProyecto);

    proyectoRepo.save(proyecto);
  }

  @Override
  public List<Proyecto> obtenerProyecto(Integer idUser) {
    User user = userRepo.findById(idUser).orElse(null);

    return proyectoRepo.findByUser(user);
  };

  @Override
  public void borrarProyecto(Long id) {
    proyectoRepo.deleteById(id);
  }

}
