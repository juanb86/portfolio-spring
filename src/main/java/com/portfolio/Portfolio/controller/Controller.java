package com.portfolio.Portfolio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.Portfolio.model.Persona;
import com.portfolio.Portfolio.service.IPersonaService;

@RestController
public class Controller {

    @Autowired
    private IPersonaService persoServ;

    @GetMapping("/hola")
    public String decirHola() {
        return "Hola mundo";
    }

    @PostMapping("/new/persona")
    public void agregarPersona(@RequestBody Persona pers) {
        persoServ.crearPersona(pers);
    }

    @GetMapping("/ver/personas")
    @ResponseBody
    public List<Persona> verPersonas() {
        return persoServ.verPersonas();
    }

    @DeleteMapping("/delete/{id}")
    public void borrarPersona(@PathVariable Long id) {
        persoServ.borrarPersona(id);
    }

}
