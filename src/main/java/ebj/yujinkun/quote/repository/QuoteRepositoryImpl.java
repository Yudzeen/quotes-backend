package ebj.yujinkun.quote.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

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
		if (quotesMap.containsKey(quote.getId())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Quote with id exists");
		}
		quotesMap.put(quote.getId(), quote);		
	}

	@Override
	public void update(Quote quote) {
		if (!quotesMap.containsKey(quote.getId())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Quote does not exist");
		}
		quotesMap.replace(quote.getId(), quote);	
	}
	
	
}
