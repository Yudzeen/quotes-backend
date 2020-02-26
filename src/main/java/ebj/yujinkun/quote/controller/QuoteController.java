package ebj.yujinkun.quote.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ebj.yujinkun.quote.service.QuoteService;
import models.Quote;

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
	
}
