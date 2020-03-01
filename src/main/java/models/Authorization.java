package models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Authorization {
	
	@Id
	String id;
	
	String key;
	
	public String getId() {
		return id;
	}

	public String getKey() {
		return key;
	}

}
