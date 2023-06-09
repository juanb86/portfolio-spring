package com.portfolio.Portfolio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import com.portfolio.Portfolio.model.Educacion;
import com.portfolio.Portfolio.model.Experiencia;
import com.portfolio.Portfolio.model.Habilidad;
import com.portfolio.Portfolio.model.Persona;
import com.portfolio.Portfolio.model.Proyecto;
import com.portfolio.Portfolio.model.User;
import com.portfolio.Portfolio.service.IEducacionService;
import com.portfolio.Portfolio.service.IExperienciaService;
import com.portfolio.Portfolio.service.IHabilidadService;
import com.portfolio.Portfolio.service.IPersonaService;
import com.portfolio.Portfolio.service.IProyectoService;

@RestController
@CrossOrigin
public class Controller {

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    private IPersonaService personaService;

    @Autowired
    private IEducacionService educacionService;

    @Autowired
    private IHabilidadService habilidadService;

    @Autowired
    private IExperienciaService experienciaService;

    @Autowired
    private IProyectoService proyectoService;

    // -------------------------
    // ---Controllers Persona---
    // -------------------------
    @GetMapping("/persona/{id}")
    public Persona obtenerPersona(@PathVariable Long id) {

        return personaService.obtenerPersona(id);
    }

    @RequestMapping(value = "/persona", method = { RequestMethod.POST, RequestMethod.PUT })
    public void modificarPersona(@RequestBody Persona persona) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Integer userId = ((User) authentication.getPrincipal()).getId();

        personaService.modificarPersona(userId, persona);
    }

    // ---------------------------
    // ---Controllers Educacion---
    // ---------------------------
    @PostMapping("/educacion")
    public void crearEducacion(@RequestBody Educacion educacion) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Integer userId = ((User) authentication.getPrincipal()).getId();

        educacionService.crearEducacion(userId, educacion);
    }

    @GetMapping("/educacion/user/{userId}")
    public List<Educacion> obtenerEducacion(@PathVariable Integer userId) {

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

    // ---Controllers Habilidad---
    @PostMapping("/habilidad")
    public void crearHabilidad(@RequestBody Habilidad habilidad) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Integer userId = ((User) authentication.getPrincipal()).getId();

        habilidadService.crearHabilidad(userId, habilidad);
    }

    @GetMapping("/habilidad/user/{userId}")
    public List<Habilidad> obtenerHabilidad(@PathVariable Integer userId) {

        return habilidadService.obtenerHabilidad(userId);
    }

    @PutMapping("/habilidad/{id}")
    public void modificarHabilidad(@PathVariable Long id,
            @RequestBody Habilidad habilidad) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Integer userId = ((User) authentication.getPrincipal()).getId();

        habilidadService.modificarHabilidad(userId, id, habilidad);
    }

    @DeleteMapping("/habilidad/{id}")
    public void borrarHabilidad(@PathVariable Long id) {
        habilidadService.borrarHabilidad(id);
    }

    // ---Controllers Experiencia---
    @PostMapping("/experiencia")
    public void crearExperiencia(@RequestBody Experiencia experiencia) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Integer userId = ((User) authentication.getPrincipal()).getId();

        experienciaService.crearExperiencia(userId, experiencia);
    }

    @GetMapping("/experiencia/user/{userId}")
    public List<Experiencia> obtenerExperiencia(@PathVariable Integer userId) {

        return experienciaService.obtenerExperiencia(userId);
    }

    @PutMapping("/experiencia/{id}")
    public void modificarExperiencia(@PathVariable Long id,
            @RequestBody Experiencia experiencia) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Integer userId = ((User) authentication.getPrincipal()).getId();

        experienciaService.modificarExperiencia(userId, id, experiencia);
    }

    @DeleteMapping("/experiencia/{id}")
    public void borrarExperiencia(@PathVariable Long id) {
        experienciaService.borrarExperiencia(id);
    }

    // ---Controllers Proyecto---
    @PostMapping("/proyecto")
    public void crearProyecto(@RequestBody Proyecto proyecto) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Integer userId = ((User) authentication.getPrincipal()).getId();

        proyectoService.crearProyecto(userId, proyecto);
    }

    @GetMapping("/proyecto/user/{userId}")
    public List<Proyecto> obtenerProyecto(@PathVariable Integer userId) {

        return proyectoService.obtenerProyecto(userId);
    }

    @PutMapping("/proyecto/{id}")
    public void modificarProyecto(@PathVariable Long id,
            @RequestBody Proyecto proyecto) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Integer userId = ((User) authentication.getPrincipal()).getId();

        proyectoService.modificarProyecto(userId, id, proyecto);
    }

    @DeleteMapping("/proyecto/{id}")
    public void borrarProyecto(@PathVariable Long id) {
        proyectoService.borrarProyecto(id);
    }

}
