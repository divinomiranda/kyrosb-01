package com.kyros.divino;

import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.kyros.divino.model.Clientes;
import com.kyros.divino.service.ClienteService;

public class ClienteServiceTest {

	@Mock
	private ClienteService service;
	
	@InjectMocks
	private Clientes cliente;

	@Before
	public void setup() {
		cliente = mock(Clientes.class);
		service = new ClienteService();
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void salvar() {
		service = Mockito.mock(ClienteService.class);
		Mockito.when(service.salvar(Mockito.any(Clientes.class))).thenReturn(cliente);
	}
	
	@Test
	public void deletar() {
		service = Mockito.mock(ClienteService.class);
		service.deletar(Mockito.anyLong());
	}
	
	@Test
	public void atualizar() {
		service = Mockito.mock(ClienteService.class);
		service.atualizar(Mockito.any(Clientes.class));
	}


}
