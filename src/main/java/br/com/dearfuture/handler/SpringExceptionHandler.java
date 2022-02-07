package br.com.dearfuture.handler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

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


}
