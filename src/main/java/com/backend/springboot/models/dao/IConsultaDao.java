package com.backend.springboot.models.dao;

import com.backend.springboot.models.entity.Consulta;
import com.backend.springboot.models.entity.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IConsultaDao extends JpaRepository<Consulta, Long> {

    @Query("from Medico")
    public List<Medico> findAllMedicos();
}
