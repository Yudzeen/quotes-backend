package ebj.yujinkun.quote.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import ebj.yujinkun.quote.repository.QuoteRepository;
import models.Quote;
import utils.DateUtils;

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

	@Override
	public Quote update(Quote quote) {
		Quote updateQuote = new Quote.Builder()
				.from(quote)
				.setDateModified(DateUtils.getCurrentDate())
				.build();
		quoteRepository.update(updateQuote);
		return updateQuote;
	}
	
	@Override
	public Quote delete(Quote quote) {
		Quote deletedQuote = quoteRepository.delete(quote);
		return deletedQuote;
	}

	@Override
	public Quote getRandomQuote() {
		List<Quote> quotes = getAllQuotes();
		if (quotes.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.PRECONDITION_REQUIRED, "No quotes in database, insert a quote first");
		}
		Random random = new Random();
		int randomIndex = random.nextInt(quotes.size());
		return quotes.get(randomIndex);
	}
	
}
