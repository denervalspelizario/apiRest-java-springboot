package br.com.denerplz.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// adicionar extensão RuntimeException
// importar @ResponseStatus
@ResponseStatus(HttpStatus.BAD_REQUEST) // retorna status de erro
public class UnsuppotedMathOperationException extends RuntimeException{}
