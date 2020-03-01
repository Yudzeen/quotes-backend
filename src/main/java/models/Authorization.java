package models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Authorization {
	
	@Id
	String key;

	public String getKey() {
		return key;
	}

}
