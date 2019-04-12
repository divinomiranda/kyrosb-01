package com.kyros.divino.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.kyros.divino.model.DetalhesErro;
import com.kyros.divino.service.exceptions.ClienteExistenteException;
import com.kyros.divino.service.exceptions.ClienteNaoEncontradoException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ClienteNaoEncontradoException.class)
	public ResponseEntity<DetalhesErro> handleClienteNaoEncontradoException(ClienteNaoEncontradoException e, HttpServletRequest request){
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus("404");
		erro.setTitulo("O cliente não pôde ser encontrado");
		erro.setMensagemDesenvolvedor("http://erros.kyros.com/404");
		erro.setTimeStamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}

	@ExceptionHandler(ClienteExistenteException.class)
	public ResponseEntity<DetalhesErro> handleClienteExistenteException(ClienteExistenteException e, HttpServletRequest request){
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus("409");
		erro.setTitulo("Cliente já existente");
		erro.setMensagemDesenvolvedor("http://erros.kyros.com/409");
		erro.setTimeStamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
	}
	
	public ResponseEntity<DetalhesErro> handleDataIntegrityViolationException(DataIntegrityViolationException e, HttpServletRequest request){
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus("400");
		erro.setTitulo("Requisição inválida");
		erro.setMensagemDesenvolvedor("http://erros.kyros.com/400");
		erro.setTimeStamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}
}
