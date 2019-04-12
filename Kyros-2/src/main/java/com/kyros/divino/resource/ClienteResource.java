package com.kyros.divino.resource;

import java.net.URI;

import javax.validation.Valid;

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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.kyros.divino.model.Clientes;
import com.kyros.divino.service.ClienteService;


@RestController
@RequestMapping("/clientes")
public class ClienteResource {

	@Autowired
	private ClienteService clienteService;
	
	
	@PostMapping
	public ResponseEntity<Void> salvar(@Valid @RequestBody Clientes cliente) {
		cliente = clienteService.salvar(cliente);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(cliente.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Clientes> buscar(@PathVariable("id") Long id) {
		Clientes cliente = clienteService.buscar(id);
		return ResponseEntity.status(HttpStatus.OK).body(cliente);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
		this.clienteService.deletar(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> atualizar(@Valid @RequestBody Clientes cliente, @PathVariable("id") Long id) {
		cliente.setId(id);
		this.clienteService.atualizar(cliente);
		return ResponseEntity.noContent().build();
	}
}
