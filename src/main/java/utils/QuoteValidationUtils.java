package utils;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class QuoteValidationUtils {

	public static void validateId(String id) {
		if (TextUtils.isEmpty(id)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No id provided");
		}
	}
	
	public static void validateContent(String content) {
		if (TextUtils.isEmpty(content)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No content provided");
		}
	}
	
	public static void validateQuotee(String quotee) {
		if (TextUtils.isEmpty(quotee)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No quotee provided");
		}
	}
	
	public static void validateDateCreated(String dateCreated) {
		if (TextUtils.isEmpty(dateCreated)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No date created provided");
		}
	}
}
