package ebj.yujinkun.quote.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import models.Quote;

@Repository
public class QuoteRepositoryImpl implements QuoteRepository {

	// TODO: Currently using in-memory DB, change to MongoDB implementation
	private static HashMap<String, Quote> quotesMap = new HashMap<>();
	
	@Override
	public List<Quote> getAllQuotes() {
		return new ArrayList<>(quotesMap.values());
	}
	
	@Override
	public Quote getQuoteById(String id) {
		return quotesMap.get(id);
	}

	@Override
	public void insert(Quote quote) {
		quotesMap.put(quote.getId(), quote);		
	}
	
	
}
