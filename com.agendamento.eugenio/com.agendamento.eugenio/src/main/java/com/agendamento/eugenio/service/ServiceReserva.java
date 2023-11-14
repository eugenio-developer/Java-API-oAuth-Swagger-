package com.agendamento.eugenio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.agendamento.eugenio.models.Reserva;
import com.agendamento.eugenio.repository.RepositoryReserva;

@Service
public class ServiceReserva {

	@Autowired
	private RepositoryReserva repositoryR;
	
	public void salvar(Reserva reserva) {
		repositoryR.save(reserva);
	}
	public void deletar(Reserva reserva) {
		repositoryR.delete(reserva);
	}
	public Optional<Reserva> get(int codigo) {
		return repositoryR.findById(codigo);
	}
	public List<Reserva> All(){
		return repositoryR.findAll();
	}
	
}
