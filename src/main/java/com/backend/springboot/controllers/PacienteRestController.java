package com.backend.springboot.controllers;

import com.backend.springboot.models.entity.Paciente;
import com.backend.springboot.models.services.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class PacienteRestController {

    // INYECTAR DEPENDENCIAS

    @Autowired
    private IPacienteService pacienteService;

    // IMPLEMENTAR METODOS

    // OBTENER TODOS LOS PACIENTES
    @GetMapping("/pacientes")
    public List<Paciente> index(){
        return pacienteService.findAllPacientes();
    }

    // MOSTRAR PACIENTE POR ID CON MANEJO DE ERRORES
    @GetMapping("/pacientes/{id}")
    public ResponseEntity<?> show(@PathVariable Long id) {
        Paciente paciente = null;
        Map<String, Object> response = new HashMap<>();

        try{
            paciente = pacienteService.findPacienteById(id);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if(paciente == null){
            response.put("mensaje", "El paciente con ID:".concat(id.toString().concat(" no existe en la base de datos!")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Paciente>(paciente, HttpStatus.OK);
    }

    // CREAR PACIENTE CON MANEJO DE ERRORES
    @PostMapping("/pacientes")
    public ResponseEntity<?> create(@Valid @RequestBody Paciente paciente, BindingResult result) {
        Paciente pacienteNuevo = null;
        Map<String, Object> response = new HashMap<>();

        if(result.hasErrors()){
            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
                    .collect(Collectors.toList());

            response.put("errors", errors);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }

        try{
            pacienteNuevo = pacienteService.savePaciente(paciente);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la creación en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El paciente ha sido creado con éxito!");
        response.put("paciente", pacienteNuevo);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    // ACTUALIZAR PACIENTE CON MANEJO DE ERRORES
    @PutMapping("/pacientes/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Paciente paciente, BindingResult result, @PathVariable Long id) {
        Paciente pacienteActual = pacienteService.findPacienteById(id);
        Paciente pacienteActualizado = null;
        Map<String, Object> response = new HashMap<>();

        if(result.hasErrors()){
            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
                    .collect(Collectors.toList());

            response.put("errors", errors);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }

        if(pacienteActual == null){
            response.put("mensaje", "Error: no se pudo editar el paciente con ID:".concat(id.toString().concat(" no existe en la base de datos!")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        try {
            pacienteActual.setNombre(paciente.getNombre());
            pacienteActual.setApellido(paciente.getApellido());
            pacienteActual.setDocumentoIdentidad(paciente.getDocumentoIdentidad());
            pacienteActual.setGenero(paciente.getGenero());
            pacienteActual.setLugarNacimiento(paciente.getLugarNacimiento());
            pacienteActual.setFechaNacimiento(paciente.getFechaNacimiento());
            pacienteActual.setTipoSangre(paciente.getTipoSangre());
            pacienteActual.setEps(paciente.getEps());
            pacienteActual.setDireccion(paciente.getDireccion());
            pacienteActual.setTelefono(paciente.getTelefono());
            pacienteActual.setEmail(paciente.getEmail());
            pacienteActual.setEstadoCivil(paciente.getEstadoCivil());
            pacienteActualizado = pacienteService.savePaciente(pacienteActual);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar el paciente en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El paciente ha sido actualizado con éxito!");
        response.put("paciente", pacienteActualizado);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    // ELIMINAR PACIENTE CON MANEJO DE ERRORES
    @DeleteMapping("/pacientes/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();

        try{
            pacienteService.deletePaciente(id);
        } catch(DataAccessException e){
            response.put("mensaje", "Error al eliminar el paciente en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El paciente ha sido eliminado con éxito!");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }
}
