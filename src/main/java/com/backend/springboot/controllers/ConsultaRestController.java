package com.backend.springboot.controllers;

import com.backend.springboot.models.entity.Consulta;
import com.backend.springboot.models.services.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class ConsultaRestController {

    // INYECTAR DEPENDENCIAS
    @Autowired
    private IPacienteService pacienteService;

    // OBTENER CONSULTA POR ID
    @GetMapping("/consultas/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Consulta show(@PathVariable Long id){
        return pacienteService.findConsultaById(id);
    }

    // CREAR CONSULTA
    @PostMapping("/consultas")
    @ResponseStatus(HttpStatus.CREATED)
    public Consulta create(@RequestBody Consulta consulta) {
        return pacienteService.saveConsulta(consulta);
    }

    // ELIMINAR CONSULTA POR ID
    @DeleteMapping("/consultas/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        pacienteService.deleteConsultaById((id));
    }

}
