package com.kyros.divino.model;

public class DetalhesErro {

	private String titulo;
	private String status;
	private Long timeStamp;
	private String mensagemDesenvolvedor;
	
	/* GETTERS AND SETTERS */
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Long getTimeStamp() {
		return timeStamp;
	}
	
	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	public String getMensagemDesenvolvedor() {
		return mensagemDesenvolvedor;
	}
	
	public void setMensagemDesenvolvedor(String mensagemDesenvolvedor) {
		this.mensagemDesenvolvedor = mensagemDesenvolvedor;
	}
	
	
}
