package com.agendamento.eugenio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agendamento.eugenio.models.Laboratorio;
import com.agendamento.eugenio.repository.RepositoryLaboratorio;

@Service
public class ServiceLaboratorio {

	@Autowired
	private RepositoryLaboratorio repositoryLab;
	
	public void salvar(Laboratorio laboratorio) {
		repositoryLab.save(laboratorio);
	}
	public void deletar(Laboratorio laboratorio) {
		repositoryLab.delete(laboratorio);
	}
	public Optional<Laboratorio> get(int codigo) {
		return repositoryLab.findById(codigo);
	}
	public List<Laboratorio> All(){
		return repositoryLab.findAll();
	}
	
}
