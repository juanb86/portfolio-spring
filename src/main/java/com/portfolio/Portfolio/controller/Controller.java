package com.portfolio.Portfolio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import com.portfolio.Portfolio.model.Educacion;
import com.portfolio.Portfolio.model.Persona;
import com.portfolio.Portfolio.model.Proyecto;
import com.portfolio.Portfolio.model.User;
import com.portfolio.Portfolio.service.IEducacionService;
import com.portfolio.Portfolio.service.IPersonaService;
import com.portfolio.Portfolio.service.IProyectoService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class Controller {

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    private IPersonaService personaService;

    @Autowired
    private IEducacionService educacionService;

    @Autowired
    private IProyectoService proyectoService;

    // ---Controllers Persona---
    @RequestMapping(value = "/persona", method = { RequestMethod.POST, RequestMethod.PUT })
    public void modificarPersona(@RequestBody Persona persona) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Integer userId = ((User) authentication.getPrincipal()).getId();

        personaService.modificarPersona(userId, persona);
    }

    @CrossOrigin
    @GetMapping("/persona/{id}")
    public Persona obtenerPersona(@PathVariable Long id) {

        return personaService.obtenerPersona(id);
    }

    // ---Controllers Educacion---
    @PostMapping("/educacion")
    public void crearEducacion(@RequestBody Educacion educacion) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Integer userId = ((User) authentication.getPrincipal()).getId();

        educacionService.crearEducacion(userId, educacion);
    }

    @GetMapping("/educacion")
    public List<Educacion> obtenerEducacion() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Integer userId = ((User) authentication.getPrincipal()).getId();

        return educacionService.obtenerEducacion(userId);
    }

    @PutMapping("/educacion/{id}")
    public void modificarEducacion(@PathVariable Long id,
            @RequestBody Educacion educacion) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Integer userId = ((User) authentication.getPrincipal()).getId();

        educacionService.modificarEducacion(userId, id, educacion);
    }

    @DeleteMapping("/educacion/{id}")
    public void borrarEducacion(@PathVariable Long id) {
        educacionService.borrarEducacion(id);
    }

    // ---Controllers Proyectos---
    @GetMapping("/{id}/proyectos")
    public List<Proyecto> verProyectos(@PathVariable Long id) {
        return proyectoService.verProyectos(id);
    }

    @PostMapping("/{id}/proyectos")
    public void agregarProyecto(@PathVariable Long id, @RequestBody Proyecto proyecto) {
        proyectoService.crearProyecto(proyecto, id);
    }

    @DeleteMapping("/delete/proyecto/{id}")
    public void borrarProyecto(@PathVariable Long id) {
        proyectoService.borrarProyecto(id);
    }

}
