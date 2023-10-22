package br.com.denerplz.api.exception.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.denerplz.api.exception.ExceptionResponse;


@ControllerAdvice // usando para fazer uma especie de controller global para usar em todos controllers
@RestController // importando controlador
// adicionar extensão de ResponseEntityExceptionHandler
public class CustomizeResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

	
	public final ResponseEntity<ExceptionResponse> handleAllExceptions(
			Exception ex, WebRequest request
			)
	{
		
		ExceptionResponse exceptionResponse = new ExceptionResponse(
				new Date() ,
				ex.getMessage(),
				request.getDescription(false)
				);
		return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
}
