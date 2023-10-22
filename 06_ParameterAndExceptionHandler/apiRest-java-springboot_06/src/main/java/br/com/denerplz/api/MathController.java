package br.com.denerplz.api;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



// Controladores
@RestController
public class MathController {
	
	
	//private final AtomicLong counter = new AtomicLong();
	
	
	// @RequestMapping usado para recuperar dados de uma url
	// request tipo get recebendo 2 parametros
	@RequestMapping( value = "/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET) // tipo get 
	
	// logica do controlador
	public Double sum(
			
		// PathVariable usada para acessar parametros de url
		@PathVariable(value = "numberOne") String numberOne , // parametro 1 
		@PathVariable(value = "numberTwo") String numberTwo // parametro 2
		
		) throws Exception{ // adicionando excessão
		
			// se algum dos numeros não forem string joga a excessão
			if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new Exception();
		}
			
		return convertToDouble(numberOne) + convertToDouble(numberTwo);
	}

	
	// metodo que valida se ah dado, troca "," por "." e depois tranforma em number o dado
	private Double convertToDouble(String strNumber) {
		
		// Validação se não receber dado então retorna 0
		if(strNumber == null) return 0D;
		
		// usando metodo replaceall trocando , por .
		String number = strNumber.replaceAll(",", ".");
		
		
		// depois de validar e trocar "," por "."  vamos transformar em numero pq vem como string
		if(isNumeric(number)){
			return Double.parseDouble(number);
		};
		
		return 0D;
	}

	// metodo usado para validar se parametro passado é um numero
	private boolean isNumeric(String strNumber) {
		
		// Validação se não passar nenhum dado  returna false 
		if(strNumber == null){
			return false;
		};
		
		// se foi passado um dado alterar todos os "," por "."
		String number = strNumber.replaceAll(",", ".");
		
		
		// após fazer as duas validações vamos validar por regex  se positivo e negativo
		// de 0 a 9 pode conter numeros fracionados também de 0 a 9
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}

}

