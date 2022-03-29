package br.com.dearfuture.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import br.com.dearfuture.application.general.dto.ResponseCredentialsDto;

public class HeadersUtil {
	
	private static final String HEADER_NAME = "Authorization";
	private static final String TOKEN_TYPE = "Bearer "; 
			
	public static String getBearerTokenHeader() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader(HEADER_NAME);
    }
	
	public static ResponseCredentialsDto decodeJwt() {
	    String bearerToken = getBearerTokenHeader();
	    String token = bearerToken.substring(TOKEN_TYPE.length(), bearerToken.length());
		DecodedJWT jwt = JWT.decode(token);
		String userId = jwt.getClaim("userId").asString();
		
		ResponseCredentialsDto response = new ResponseCredentialsDto(userId);
		
		return response;
	}

    public static ResponseCredentialsDto decodeJwt(String bearerToken) {

        String token = bearerToken.substring(TOKEN_TYPE.length(), bearerToken.length());
		DecodedJWT jwt = JWT.decode(token);
		String userId = jwt.getClaim("userId").asString();
		
		ResponseCredentialsDto response = new ResponseCredentialsDto(userId);
        return response;
    }
}

