package ebj.yujinkun.quote.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import ebj.yujinkun.quote.service.QuoteService;
import models.Quote;
import utils.TextUtils;

@RestController
@RequestMapping(value="/quotes")
public class QuoteController {
	
	@Autowired
	QuoteService quoteService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Quote>> getAllQuotes() {
		List<Quote> quotes = quoteService.getAllQuotes();
		return new ResponseEntity<>(quotes, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Quote> getQuoteById(@PathVariable String id) {
		Quote quote = quoteService.getQuoteById(id);
		
		if (quote == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Quote with id " + id + " does not exist");
		}
		
		return new ResponseEntity<Quote>(quote, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Quote> insert(@RequestBody Quote quote) {
		if (TextUtils.isEmpty(quote.getContent())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Quote has no content");
		}
		
		Quote insertedQuote = quoteService.insert(quote);
		return new ResponseEntity<Quote>(insertedQuote, HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Quote> update(@RequestBody Quote quote) {
		if (TextUtils.isEmpty(quote.getId())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Quote has no id");
		}
		if (TextUtils.isEmpty(quote.getContent())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Quote has no content");
		}
		if (TextUtils.isEmpty(quote.getQuotee())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Quote has no quotee");
		}
		if (TextUtils.isEmpty(quote.getDateCreated())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Quote has no date created");
		}
		
		Quote updatedQuote = quoteService.update(quote);
		return new ResponseEntity<>(updatedQuote, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<Quote> delete(@RequestBody Quote quote) {
		if (TextUtils.isEmpty(quote.getId())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No id provided");
		}
		
		Quote deletedQuote = quoteService.delete(quote);
		return new ResponseEntity<>(deletedQuote, HttpStatus.OK);
	}
}
