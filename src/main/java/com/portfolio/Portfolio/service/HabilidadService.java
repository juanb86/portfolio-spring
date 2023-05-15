package com.portfolio.Portfolio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.Portfolio.model.Habilidad;
import com.portfolio.Portfolio.model.User;
import com.portfolio.Portfolio.repository.HabilidadRepository;
import com.portfolio.Portfolio.repository.UserRepository;

@Service
public class HabilidadService implements IHabilidadService {

    @Autowired
    public HabilidadRepository habilidadRepo;

    @Autowired
    public UserRepository userRepo;

    @Override
    public void crearHabilidad(Integer idUser, Habilidad habilidad) {

        User user = userRepo.findById(idUser).orElse(null);

        habilidad.setUser(user);

        habilidadRepo.save(habilidad);
    }

    @Override
    public void modificarHabilidad(Integer idUser, Long idHabilidad, Habilidad habilidad) {

        User user = userRepo.findById(idUser).orElse(null);

        if (user == null) {
            return;
        }

        habilidad.setUser(user);
        habilidad.setId(idHabilidad);

        habilidadRepo.save(habilidad);
    }

    @Override
    public List<Habilidad> obtenerHabilidad(Integer idUser) {
        User user = userRepo.findById(idUser).orElse(null);

        return habilidadRepo.findByUser(user);
    };

    @Override
    public void borrarHabilidad(Long id) {
        habilidadRepo.deleteById(id);
    }

}
