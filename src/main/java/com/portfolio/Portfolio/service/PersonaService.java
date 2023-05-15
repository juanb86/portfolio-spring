package com.portfolio.Portfolio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.Portfolio.model.Persona;
import com.portfolio.Portfolio.model.User;
import com.portfolio.Portfolio.repository.PersonaRepository;
import com.portfolio.Portfolio.repository.UserRepository;

@Service
public class PersonaService implements IPersonaService {

    @Autowired
    public PersonaRepository persoRepo;

    @Autowired
    public UserRepository userRepo;

    @Override
    public void crearPersona(Integer id, Persona per) {

        User user = userRepo.findById(id).orElse(null);

        per.setUser(user);

        persoRepo.save(per);
    }

    @Override
    public void modificarPersona(Integer idUser, Persona persona) {

        User user = userRepo.findById(idUser).orElse(null);

        if (user == null) {
            return;
        }

        persona.setUser(user);

        List<Persona> origPersona = persoRepo.findByUser(user);

        if (!origPersona.isEmpty()) {
            persona.setId(origPersona.get(0).getId());
        }

        persoRepo.save(persona);
    }

    @Override
    public Persona obtenerPersona(Long id) {

        return persoRepo.findById(id).orElse(null);
    }

}
