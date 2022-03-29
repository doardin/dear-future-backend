package br.com.dearfuture.exceptions;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private HttpStatus status;
	private String message;
	private String code;
	private Map<String, String> payload;
	private LocalDateTime timestamp = LocalDateTime.now();
}

