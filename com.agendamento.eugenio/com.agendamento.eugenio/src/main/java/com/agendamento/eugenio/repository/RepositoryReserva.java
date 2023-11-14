package com.agendamento.eugenio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agendamento.eugenio.models.Reserva;

@Repository
public interface RepositoryReserva extends JpaRepository<Reserva, Integer>{

	
}
