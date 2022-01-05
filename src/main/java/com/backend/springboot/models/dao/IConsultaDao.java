package com.backend.springboot.models.dao;

import com.backend.springboot.models.entity.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface IConsultaDao extends JpaRepository<Consulta, Long> {

}
