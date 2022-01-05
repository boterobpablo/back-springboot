package com.backend.springboot.models.services;

import com.backend.springboot.models.dao.IConsultaDao;
import com.backend.springboot.models.dao.IPacienteDao;
import com.backend.springboot.models.entity.Consulta;
import com.backend.springboot.models.entity.Medico;
import com.backend.springboot.models.entity.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PacienteServiceImpl implements IPacienteService {

    // INYECTAR DEPENDENCIAS

    @Autowired
    private IPacienteDao pacienteDao;

    @Autowired
    private IConsultaDao consultaDao;

    // IMPLEMENTAR METODOS

    // Metodo para listar todos los pacientes
    @Override
    @Transactional(readOnly = true)
    public List<Paciente> findAllPacientes() {
        return (List<Paciente>) pacienteDao.findAll();
    }

    // Metodo para encontrar paciente por id
    @Override
    @Transactional(readOnly = true)
    public Paciente findPacienteById(Long id) {
        return pacienteDao.findById(id).orElse(null);
    }

    // Metodo para crear paciente
    @Override
    @Transactional
    public Paciente savePaciente(Paciente paciente) {
        return pacienteDao.save(paciente);
    }

    // Metodo para eliminar paciente
    @Override
    @Transactional
    public void deletePaciente(Long id) {
        pacienteDao.deleteById(id);
    }

    // Metodo para encontrar consulta por id
    @Override
    @Transactional(readOnly = true)
    public Consulta findConsultaById(Long id) {
        return consultaDao.findById(id).orElse(null);
    }

    // Metodo para crear consulta
    @Override
    @Transactional
    public Consulta saveConsulta(Consulta consulta) {
        return consultaDao.save(consulta);
    }

    // Metodo para eliminar consulta
    @Override
    @Transactional
    public void deleteConsultaById(Long id) {
        consultaDao.deleteById(id);
    }

    // metodo para listar todos los medicos
    @Override
    @Transactional(readOnly = true)
    public List<Medico> findAllMedicos() {
        return consultaDao.findAllMedicos();
    }


}
