package com.portfolio.Portfolio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.Portfolio.model.Educacion;
import com.portfolio.Portfolio.model.User;
import com.portfolio.Portfolio.repository.EducacionRepository;
import com.portfolio.Portfolio.repository.UserRepository;

@Service
public class EducacionService implements IEducacionService {

    @Autowired
    public EducacionRepository educacionRepo;

    @Autowired
    public UserRepository userRepo;

    @Override
    public void crearEducacion(Integer idUser, Educacion educacion) {

        User user = userRepo.findById(idUser).orElse(null);

        educacion.setUser(user);

        educacionRepo.save(educacion);
    }

    @Override
    public void modificarEducacion(Integer idUser, Long idEducacion, Educacion educacion) {

        User user = userRepo.findById(idUser).orElse(null);

        if (user == null) {
            return;
        }

        educacion.setUser(user);
        educacion.setId(idEducacion);

        educacionRepo.save(educacion);
    }

    @Override
    public List<Educacion> obtenerEducacion(Integer idUser) {
        User user = userRepo.findById(idUser).orElse(null);

        return educacionRepo.findByUser(user);
    };

    @Override
    public void borrarEducacion(Long id) {
        educacionRepo.deleteById(id);
    }

}
