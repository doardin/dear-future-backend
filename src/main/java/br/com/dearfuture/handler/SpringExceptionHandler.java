package br.com.dearfuture.handler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.dearfuture.exceptions.CustomException;
import br.com.dearfuture.exceptions.CustomExceptionSchema;

@ControllerAdvice
public class SpringExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<?> handleMethodArgumentNotValidException(final MethodArgumentNotValidException exception, final HttpServletRequest request) {

		Map<String, String> errors = new HashMap<>();

		errors.put("status", "400");
		errors.put("error", exception.getBindingResult().getFieldErrors().get(0).getDefaultMessage());
		errors.put("timestamp", LocalDateTime.now().toString());

		return ResponseEntity.badRequest().body(errors);
	}

	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<?> handleRequestMethodNotSupportedException(final HttpServletRequest request, final HttpRequestMethodNotSupportedException exception) {

		Map<String, Object> error = new HashMap<String, Object>();

		error.put("error", "O método informado não é permitido para essa requisição");
		error.put("status", HttpStatus.METHOD_NOT_ALLOWED);
		error.put("timestamp", LocalDateTime.now().toString());

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler({ CustomException.class })
	public ResponseEntity<?> handleCustomException(final HttpServletRequest request, final CustomException exception) {
		CustomExceptionSchema schema = new CustomExceptionSchema(exception);
		return new ResponseEntity<>(schema, schema.getStatus());
	}

}
