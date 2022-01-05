package com.backend.springboot.models.dao;

import com.backend.springboot.models.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPacienteDao extends JpaRepository<Paciente, Long> {

}
