package com.portfolio.Portfolio.service;

import java.util.List;

import com.portfolio.Portfolio.model.Educacion;

public interface IEducacionService {

    public void crearEducacion(Integer idUser, Educacion educacion);

    public List<Educacion> obtenerEducacion(Integer idUser);

    public void modificarEducacion(Integer idUser, Long id, Educacion educacion);

    public void borrarEducacion(Long id);

}
