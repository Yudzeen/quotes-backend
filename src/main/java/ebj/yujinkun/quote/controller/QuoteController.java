package ebj.yujinkun.quote.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import ebj.yujinkun.quote.auth.service.AuthService;
import ebj.yujinkun.quote.service.QuoteService;
import models.Quote;
import utils.AuthUtils;
import utils.QuoteValidationUtils;

@RestController
@RequestMapping(value="/quotes")
public class QuoteController {
	
	@Autowired
	QuoteService quoteService;
	
	@Autowired
	AuthService authService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Quote>> getAllQuotes(@RequestHeader("x-api-key") String apiKey) {
		AuthUtils.validateApiKey(authService, apiKey);
		
		List<Quote> quotes = quoteService.getAllQuotes();
		return new ResponseEntity<>(quotes, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Quote> getQuoteById(@RequestHeader("x-api-key") String apiKey, @PathVariable String id) {
		AuthUtils.validateApiKey(authService, apiKey);
		
		Quote quote = quoteService.getQuoteById(id);
		
		if (quote == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Quote with id " + id + " does not exist");
		}
		
		return new ResponseEntity<Quote>(quote, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Quote> insert(@RequestHeader("x-api-key") String apiKey, @RequestBody Quote quote) {
		AuthUtils.validateApiKey(authService, apiKey);
		
		QuoteValidationUtils.validateContent(quote.getContent());
		
		Quote insertedQuote = quoteService.insert(quote);
		return new ResponseEntity<Quote>(insertedQuote, HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Quote> update(@RequestHeader("x-api-key") String apiKey, @RequestBody Quote quote) {
		AuthUtils.validateApiKey(authService, apiKey);
		
		QuoteValidationUtils.validateId(quote.getId());
		QuoteValidationUtils.validateContent(quote.getContent());
		QuoteValidationUtils.validateQuotee(quote.getQuotee());
		QuoteValidationUtils.validateDateCreated(quote.getDateCreated());
		
		Quote updatedQuote = quoteService.update(quote);
		return new ResponseEntity<>(updatedQuote, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Quote> delete(@RequestHeader("x-api-key") String apiKey, @PathVariable String id) {
		AuthUtils.validateApiKey(authService, apiKey);
		
		QuoteValidationUtils.validateId(id);
		
		Quote deletedQuote = quoteService.delete(id);
		return new ResponseEntity<>(deletedQuote, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/random", method = RequestMethod.GET)
	public ResponseEntity<Quote> random(@RequestHeader("x-api-key") String apiKey) {
		AuthUtils.validateApiKey(authService, apiKey);
		
		Quote randomQuote = quoteService.getRandomQuote();
		return new ResponseEntity<>(randomQuote, HttpStatus.OK);
	}
}
