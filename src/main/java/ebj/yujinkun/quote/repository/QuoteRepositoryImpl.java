package ebj.yujinkun.quote.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import models.Quote;

@Repository
public class QuoteRepositoryImpl implements QuoteRepository {
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	@Override
	public List<Quote> getAllQuotes() {
		List<Quote> quotes = mongoTemplate.findAll(Quote.class);
		return quotes;
	}
	
	@Override
	public Quote getQuoteById(String id) {
		Query query = new Query(Criteria.where("id").is(id));
		Quote quote = mongoTemplate.findOne(query, Quote.class);
		return quote;
	}

	@Override
	public void insertQuote(Quote quote) {
		if (containsQuote(quote)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Quote with id exists");
		}
		mongoTemplate.insert(quote);	
	}

	@Override
	public void updateQuote(Quote quote) {
		if (!containsQuote(quote)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Quote does not exist");
		}
		mongoTemplate.save(quote);
	}

	@Override
	public Quote deleteQuote(Quote quote) {
		if (!containsQuote(quote)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Quote does not exist");
		}
		Query query = new Query(Criteria.where("id").is(quote.getId()));
		Quote deletedQuote = mongoTemplate.findAndRemove(query, Quote.class);
		return deletedQuote;
	}

	private boolean containsQuote(Quote quote) {
		return getQuoteById(quote.getId()) != null;
	}
}
