package com.kasun.inspireaiquoteservice.controller;

import com.kasun.inspireaiquoteservice.entity.Quote;
import com.kasun.inspireaiquoteservice.response.QuoteResponse;
import com.kasun.inspireaiquoteservice.service.QuoteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuoteController { 

	@Autowired
	private QuoteService quoteService;

	@GetMapping("/quotes/{id}")
	private ResponseEntity<QuoteResponse> getQuoteDetails(@PathVariable("id") int id) {
		QuoteResponse quote = quoteService.getQuoteById(id);
		if (quote != null) {
            //return ResponseEntity.ok(user); // 200 OK
            return ResponseEntity.status(HttpStatus.OK).body(quote);
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
	}
	
	@GetMapping("/quotes")
    public ResponseEntity<List<QuoteResponse>> getAllQuotes() {
        List<QuoteResponse> quotes = quoteService.getAllQuotes();
        if (!quotes.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(quotes); // 200 OK
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found if no quotes found
        }
    }
	
	@PostMapping("/quotes")
    public ResponseEntity<QuoteResponse> createQuote(@RequestBody Quote newQuote) {
		QuoteResponse createdQuote = quoteService.createQuote(newQuote);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdQuote); // 201 Created
    }
	
	@PutMapping("/quotes/{id}")
    public ResponseEntity<QuoteResponse> updateQuote(@PathVariable("id") int id,
                                                   @RequestBody Quote modifiedQuote) {
        QuoteResponse updatedQuote = quoteService.updateQuote(id, modifiedQuote);
        return ResponseEntity.status(HttpStatus.OK).body(updatedQuote); // 200 OK
    }
	
	@DeleteMapping("/quotes/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") int id) {
		quoteService.deleteQuoteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // 204 No Content
    }

}
