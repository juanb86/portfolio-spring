package com.portfolio.Portfolio.service;

import com.portfolio.Portfolio.model.Persona;

public interface IPersonaService {

    public void crearPersona(Integer idUser, Persona persona);

    public void modificarPersona(Integer idUser, Persona persona);

    public Persona obtenerPersona(Long id);

}
