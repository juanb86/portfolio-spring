package com.portfolio.Portfolio.service;

import java.util.List;

import com.portfolio.Portfolio.model.Habilidad;

public interface IHabilidadService {

    public void crearHabilidad(Integer idUser, Habilidad habilidad);

    public List<Habilidad> obtenerHabilidad(Integer idUser);

    public void modificarHabilidad(Integer idUser, Long id, Habilidad habilidad);

    public void borrarHabilidad(Long id);

}
