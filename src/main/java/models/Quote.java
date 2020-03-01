package models;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import utils.DateUtils;
import utils.TextUtils;

@Document
public class Quote {
	
	public static final String DEFAULT_QUOTEE = "Anonymous";
	
	@Id
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

	@Override
	public String toString() {
		return "Quote [id=" + id + ", content=" + content + ", quotee=" + quotee + ", dateCreated=" + dateCreated
				+ ", dateModified=" + dateModified + "]";
	}

	public static class Builder {
		
		String id;
		String content;
		String quotee;
		String dateCreated;
		String dateModified;
		
		public Builder from(Quote quote) {
			id = quote.getId();
			content = quote.getContent();
			quotee = quote.getQuotee();
			dateCreated = quote.getDateCreated();
			dateModified = quote.getDateModified();
			return this;
		}
		
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
			if (TextUtils.isEmpty(quotee)) {
				quotee = DEFAULT_QUOTEE;
			}
			if (TextUtils.isEmpty(dateCreated)) {
				dateCreated = DateUtils.getCurrentDate();
			}
			if (TextUtils.isEmpty(dateModified)) {
				dateModified = DateUtils.getCurrentDate();
			}
			return new Quote(id, content, quotee, dateCreated, dateModified);
		}
		
	}
	
}
