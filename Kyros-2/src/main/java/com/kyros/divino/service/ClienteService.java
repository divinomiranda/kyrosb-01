package com.kyros.divino.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import com.kyros.divino.model.Clientes;
import com.kyros.divino.repository.ClienteRepository;
import com.kyros.divino.service.exceptions.ClienteExistenteException;
import com.kyros.divino.service.exceptions.ClienteNaoEncontradoException;

@Repository
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public Clientes buscar(Long id) {
		try {
			Optional<Clientes> cliente = clienteRepository.findById(id);
			if (cliente.get().getId() == null) {
				throw new ClienteNaoEncontradoException("O cliente não pôde ser encontrado");
			}
			return cliente.get();
		} catch (Exception e) {
			throw new ClienteNaoEncontradoException("Erro ao buscar o cliente");
		}
	}
	
	public Clientes salvar(Clientes cliente) {
		try {
			if (cliente.getId() != null) {
				if (clienteRepository.existsById(cliente.getId())) {
					throw new ClienteExistenteException("O Cliente já existe");
				}
			}
			return clienteRepository.save(cliente);
		} catch (Exception e) {
			throw new ClienteNaoEncontradoException("Erro ao salvar o cliente");
		}
	}
	
	public void deletar(Long id) {
		try {
			if (clienteRepository.existsById(id)) {
				clienteRepository.deleteById(id);
			}
		} catch (EmptyResultDataAccessException e) {
			throw new ClienteNaoEncontradoException("O cliente não pôde ser encontrado.");
		}
	}
	
	public void atualizar(Clientes cliente) {
		try {
			if (clienteRepository.existsById(cliente.getId())) {
				clienteRepository.save(cliente);
			}
		} catch (EmptyResultDataAccessException e) {
			throw new ClienteNaoEncontradoException("O cliente não pôde ser encontrado.");
		}
	}
	
}
