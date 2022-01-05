package com.backend.springboot.models.services;

import com.backend.springboot.models.entity.Consulta;
import com.backend.springboot.models.entity.Medico;
import com.backend.springboot.models.entity.Paciente;

import java.util.List;

public interface IPacienteService {

    // Metodo para listar todos los pacientes
    public List<Paciente> findAllPacientes();

    // Metodo para encontrar paciente por id
    public Paciente findPacienteById(Long id);

    // Metodo para crear paciente
    public Paciente savePaciente(Paciente paciente);

    // Metodo para eliminar paciente
    public void deletePaciente(Long id);

    // Metodo para encontrar consulta por id
    public Consulta findConsultaById(Long id);

    // Metodo para crear consulta
    public Consulta saveConsulta(Consulta consulta);

    // Metodo para eliminar consulta
    public void deleteConsultaById(Long id);

    // Metodo para listar todos los medicos
    public List<Medico> findAllMedicos();

}
