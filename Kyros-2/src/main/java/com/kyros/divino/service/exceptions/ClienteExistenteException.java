package com.kyros.divino.service.exceptions;

public class ClienteExistenteException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6975009578039975L;

	public ClienteExistenteException(String mensagem) {
		super(mensagem);
	}
	
	public ClienteExistenteException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
