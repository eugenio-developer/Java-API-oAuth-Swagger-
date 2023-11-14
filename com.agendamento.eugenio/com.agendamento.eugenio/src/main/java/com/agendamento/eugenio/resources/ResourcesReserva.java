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


import com.agendamento.eugenio.models.Reserva;
import com.agendamento.eugenio.service.ServiceReserva;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/reservas")
@SecurityRequirement(name = "security_auth")
public class ResourcesReserva {

	@Autowired
	private ServiceReserva serviceR;
	
	@GetMapping("")
	public  ResponseEntity<List<Reserva>> listAll(){
		return new ResponseEntity<List<Reserva>>(serviceR.All(), HttpStatus.OK);
	}
	@PostMapping("/salvar")
	public ResponseEntity<Reserva> salvar(@RequestBody Reserva reserva){
		serviceR.salvar(reserva);
		
		return new ResponseEntity<Reserva>(reserva, HttpStatus.CREATED);
	}
	@GetMapping("/{codigo}")
	public ResponseEntity<Reserva> get (@PathVariable ("codigo") int codigo){
		Optional<Reserva> optionalReserva= serviceR.get(codigo);
		if(optionalReserva.isPresent()) {
			return new ResponseEntity<Reserva>(optionalReserva.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	@DeleteMapping("/excluir/{codigo}")
	public ResponseEntity<Reserva> deletar(@PathVariable ("codigo") int codigo){

		Optional<Reserva> optionalReserva = serviceR.get(codigo);
		if(optionalReserva.isPresent()) {
			serviceR.deletar(optionalReserva.get());
			return new ResponseEntity<>(null, HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	@PutMapping("/editar/{codigo}")
	public ResponseEntity<Reserva> update(@PathVariable("codigo") int codigo,@RequestBody Reserva reserva ){
		Optional<Reserva> optionalReserva = serviceR.get(codigo);
		if(optionalReserva.isPresent()) {
			reserva.setId(codigo);
			serviceR.salvar(reserva);
			return new ResponseEntity<Reserva>(reserva, HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
}
