package com.portfolio.Portfolio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.portfolio.Portfolio.model.Persona;
import com.portfolio.Portfolio.model.Proyecto;
import com.portfolio.Portfolio.service.IPersonaService;
import com.portfolio.Portfolio.service.IProyectoService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/personas")
public class Controller {

    @Autowired
    private IPersonaService personaService;

    @Autowired
    private IProyectoService proyectoService;


    @GetMapping
    public List<Persona> verPersonas() {
        return personaService.verPersonas();
    }

    @PostMapping
    public void agregarPersona(@RequestBody Persona persona) {
        personaService.crearPersona(persona);
    }

    @GetMapping("/{id}")
    public Persona buscarPersona(@PathVariable Long id) {
        return personaService.buscarPersona(id);
    }

    @DeleteMapping("/{id}")
    public void borrarPersona(@PathVariable Long id) {
        personaService.borrarPersona(id);
    }

    @GetMapping("/{id}/proyectos")
    public List<Proyecto> verProyectos(@PathVariable Long id) {
        return proyectoService.verProyectos(id);
    }

    @PostMapping("/{id}/proyectos")
    public void agregarProyecto(@PathVariable Long id, @RequestBody Proyecto proyecto) {
        proyectoService.crearProyecto(proyecto,id);
    }

    @DeleteMapping("/delete/proyecto/{id}")
    public void borrarProyecto(@PathVariable Long id) {
        proyectoService.borrarProyecto(id);
    }

}
