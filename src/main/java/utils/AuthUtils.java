package utils;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import ebj.yujinkun.quote.auth.service.AuthService;

public class AuthUtils {

	public static void validateApiKey(AuthService authService, String apiKey) {
		if (TextUtils.isEmpty(apiKey)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No header api key provided");
		}
		if (!authService.isAuthorized(apiKey)) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Api key is not authorized");
		}
	}
	
}
