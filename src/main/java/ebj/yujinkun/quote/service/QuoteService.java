package ebj.yujinkun.quote.service;

import java.util.List;

import models.Quote;

public interface QuoteService {

	List<Quote> getAllQuotes();
	Quote getQuoteById(String id);
	
}
