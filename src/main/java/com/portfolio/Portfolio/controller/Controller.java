package com.portfolio.Portfolio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.portfolio.Portfolio.model.Persona;
import com.portfolio.Portfolio.model.Proyecto;
import com.portfolio.Portfolio.service.IPersonaService;
import com.portfolio.Portfolio.service.IProyectoService;

@RestController
public class Controller {

    @Autowired
    private IPersonaService personaService;

    @Autowired
    private IProyectoService proyectoService;

    @PostMapping("/new/persona")
    public void agregarPersona(@RequestBody Persona persona) {
        personaService.crearPersona(persona);
    }

    @GetMapping("/ver/personas")
    public List<Persona> verPersonas() {
        return personaService.verPersonas();
    }

    @DeleteMapping("/delete/{id}")
    public void borrarPersona(@PathVariable Long id) {
        personaService.borrarPersona(id);
    }

    @PostMapping("/new/proyecto")
    public void agregarProyecto(@RequestBody Proyecto proyecto) {
        proyectoService.crearProyecto(proyecto);
    }

    @GetMapping("/ver/proyectos")
    public List<Proyecto> verProyectos() {
        return proyectoService.verProyectos();
    }

    @DeleteMapping("/delete/proyecto/{id}")
    public void borrarProyecto(@PathVariable Long id) {
        proyectoService.borrarProyecto(id);
    }

}
