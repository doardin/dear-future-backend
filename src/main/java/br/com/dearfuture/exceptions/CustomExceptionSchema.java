package br.com.dearfuture.exceptions;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomExceptionSchema {
	
	private HttpStatus status;
	private String message;
	private String code;
    private Map<String, String> payload;
	private LocalDateTime timestamp;
	
	public CustomExceptionSchema(CustomException customException) {
		this.setStatus(customException.getStatus());
		this.setMessage(customException.getMessage());
		this.setTimestamp(customException.getTimestamp());
        this.setPayload(customException.getPayload());
		this.setCode(customException.getCode());
	}
}

