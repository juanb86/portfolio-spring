package com.portfolio.Portfolio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.Portfolio.model.Experiencia;
import com.portfolio.Portfolio.model.User;
import com.portfolio.Portfolio.repository.ExperienciaRepository;
import com.portfolio.Portfolio.repository.UserRepository;

@Service
public class ExperienciaService implements IExperienciaService {

    @Autowired
    public ExperienciaRepository experienciaRepo;

    @Autowired
    public UserRepository userRepo;

    @Override
    public void crearExperiencia(Integer idUser, Experiencia experiencia) {

        User user = userRepo.findById(idUser).orElse(null);

        experiencia.setUser(user);

        experienciaRepo.save(experiencia);
    }

    @Override
    public void modificarExperiencia(Integer idUser, Long idExperiencia, Experiencia experiencia) {

        User user = userRepo.findById(idUser).orElse(null);

        if (user == null) {
            return;
        }

        experiencia.setUser(user);
        experiencia.setId(idExperiencia);

        experienciaRepo.save(experiencia);
    }

    @Override
    public List<Experiencia> obtenerExperiencia(Integer idUser) {
        User user = userRepo.findById(idUser).orElse(null);

        return experienciaRepo.findByUser(user);
    };

    @Override
    public void borrarExperiencia(Long id) {
        experienciaRepo.deleteById(id);
    }

}
