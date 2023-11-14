package com.agendamento.eugenio.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Laboratorio {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String nome;
	private int qtdcomputadores;
	@JsonIgnore
	@OneToMany(mappedBy = "laboratorio")
	private List<Reserva> reservas;
	
	public List<Reserva> getReservas() {
		return reservas;
	}
	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getQtdcomputadores() {
		return qtdcomputadores;
	}
	public void setQtdcomputadores(int qtdcomputadores) {
		this.qtdcomputadores = qtdcomputadores;
	}
	
//	-id : Integer
//	-nome : String
//	- qtdcomputadores : int
}
