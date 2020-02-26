package ebj.yujinkun.quote.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ebj.yujinkun.quote.repository.QuoteRepository;
import models.Quote;

@Service
public class QuoteServiceImpl implements QuoteService {
	
	@Autowired
	QuoteRepository quoteRepository;
	
	@Override
	public List<Quote> getAllQuotes() {
		return quoteRepository.getAllQuotes();
	}

	@Override
	public Quote getQuoteById(String id) {
		Quote quote = quoteRepository.getQuoteById(id);
		return quote;
	}

	@Override
	public Quote insert(Quote quote) {
		Quote insertQuote = new Quote.Builder()
				.from(quote)
				.build();
		quoteRepository.insert(insertQuote);
		return insertQuote;
	}
	
}
