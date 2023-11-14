package com.agendamento.eugenio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agendamento.eugenio.models.Laboratorio;

@Repository
public interface RepositoryLaboratorio extends JpaRepository<Laboratorio, Integer> {

}
