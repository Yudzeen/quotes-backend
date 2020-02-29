package ebj.yujinkun.quote.repository;

import java.util.List;

import models.Quote;

public interface QuoteRepository {

	List<Quote> getAllQuotes();
	Quote getQuoteById(String id);
	void insert(Quote quote);
	void update(Quote quote);
	Quote delete(Quote quote);
	
}
