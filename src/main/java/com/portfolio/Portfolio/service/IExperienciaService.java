package com.portfolio.Portfolio.service;

import java.util.List;

import com.portfolio.Portfolio.model.Experiencia;

public interface IExperienciaService {

    public void crearExperiencia(Integer idUser, Experiencia experiencia);

    public List<Experiencia> obtenerExperiencia(Integer idUser);

    public void modificarExperiencia(Integer idUser, Long id, Experiencia experiencia);

    public void borrarExperiencia(Long id);

}
