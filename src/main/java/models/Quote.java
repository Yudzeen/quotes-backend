package models;

import java.util.UUID;

import utils.TextUtils;

public class Quote {
	
	String id;
	String content;
	String quotee;
	String dateCreated;
	String dateModified;
	
	public Quote(String id, String content, String quotee, String dateCreated, String dateModified) {
		this.id = id;
		this.content = content;
		this.quotee = quotee;
		this.dateCreated = dateCreated;
		this.dateModified = dateModified;
	}
	
	public String getId() {
		return id;
	}

	public String getContent() {
		return content;
	}

	public String getQuotee() {
		return quotee;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public String getDateModified() {
		return dateModified;
	}

	public class Builder {
		
		String id;
		String content;
		String quotee;
		String dateCreated;
		String dateModified;
		
		public Builder setId(String id) {
			this.id = id;
			return this;
		}
		public Builder setContent(String content) {
			this.content = content;
			return this;
		}
		public Builder setQuotee(String quotee) {
			this.quotee = quotee;
			return this;
		}
		public Builder setDateCreated(String dateCreated) {
			this.dateCreated = dateCreated;
			return this;
		}
		public Builder setDateModified(String dateModified) {
			this.dateModified = dateModified;
			return this;
		}
		
		public Quote build() {
			if (TextUtils.isEmpty(id)) {
				id = UUID.randomUUID().toString();
			}
			return new Quote(id, content, quotee, dateCreated, dateModified);
		}
		
	}
	
}
