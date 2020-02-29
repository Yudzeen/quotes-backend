package ebj.yujinkun.quote.service;

import java.util.List;

import models.Quote;

public interface QuoteService {

	List<Quote> getAllQuotes();
	Quote getQuoteById(String id);
	Quote insert(Quote quote);
	Quote update(Quote quote);
	Quote delete(Quote quote);
	Quote getRandomQuote();
	
}
