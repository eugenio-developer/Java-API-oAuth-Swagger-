package com.agendamento.eugenio.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agendamento.eugenio.models.Laboratorio;
import com.agendamento.eugenio.service.ServiceLaboratorio;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;






@RestController
@RequestMapping("/laboratorios")
@SecurityRequirement(name = "security_auth")
public class ResourcesLaboratorio {
	@Autowired
	private ServiceLaboratorio serviceLab;
	
	@GetMapping("")
	public  ResponseEntity<List<Laboratorio>> listAll(){
		return new ResponseEntity<List<Laboratorio>>(serviceLab.All(), HttpStatus.OK);
	}
	@PostMapping("/salvar")
	public ResponseEntity<Laboratorio> salvar (@RequestBody Laboratorio laboratorio){
		serviceLab.salvar(laboratorio);
		
		return new ResponseEntity<Laboratorio>(laboratorio, HttpStatus.CREATED);
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Laboratorio> get (@PathVariable ("codigo") int codigo){
		Optional<Laboratorio> optionalLaboratorio = serviceLab.get(codigo);
		if(optionalLaboratorio.isPresent()) {
			return new ResponseEntity<Laboratorio>(optionalLaboratorio.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/excluir/{codigo}")
	public ResponseEntity<Laboratorio> deletar(@PathVariable ("codigo") int codigo){

		Optional<Laboratorio> optionalLaboratorio = serviceLab.get(codigo);
		if(optionalLaboratorio.isPresent()) {
			serviceLab.deletar(optionalLaboratorio.get());
			return new ResponseEntity<>(null, HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	@PutMapping("/editar/{codigo}")
	public ResponseEntity<Laboratorio> update(@PathVariable("codigo") int codigo,@RequestBody Laboratorio laboratorio ){
		Optional<Laboratorio> optionalLaboratorio = serviceLab.get(codigo);
		if(optionalLaboratorio.isPresent()) {
			laboratorio.setId(codigo);
			serviceLab.salvar(laboratorio);
			return new ResponseEntity<Laboratorio>(laboratorio, HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
}
