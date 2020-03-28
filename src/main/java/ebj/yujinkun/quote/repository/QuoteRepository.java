package ebj.yujinkun.quote.repository;

import java.util.List;

import models.Quote;

public interface QuoteRepository {

	List<Quote> getAllQuotes();
	Quote getQuoteById(String id);
	void insertQuote(Quote quote);
	void updateQuote(Quote quote);
	Quote deleteQuote(String id);
	
}
