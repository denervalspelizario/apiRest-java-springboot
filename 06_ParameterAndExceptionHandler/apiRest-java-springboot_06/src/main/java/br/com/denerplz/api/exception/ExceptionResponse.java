package br.com.denerplz.api.exception;

import java.io.Serializable;
import java.util.Date;


// Em Exceções nunca esqueca de implementar Serializable
public class ExceptionResponse implements Serializable{

	
	// atributo constante 
	private static final long serialVersionUID = 1L;

	// atributos
	private Date timestamp; // atributo para pegar a hora do erro
	private String message;
	private String details;
	
	
	// construtor
	public ExceptionResponse(Date timestamp, String message, String details) {
		
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}


	// getter  setters
	public Date getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String getDetails() {
		return details;
	}


	public void setDetails(String details) {
		this.details = details;
	}
	
	
	
	

}
