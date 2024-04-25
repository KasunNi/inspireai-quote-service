package com.kasun.inspireaiquoteservice.service;

import com.kasun.inspireaiquoteservice.entity.Quote;
import com.kasun.inspireaiquoteservice.repository.QuoteRepo;
import com.kasun.inspireaiquoteservice.response.QuoteResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class QuoteService { 

	@Autowired
	private QuoteRepo quoteRepo;

	@Autowired
	private ModelMapper mapper;

	public QuoteResponse getQuoteById(int id) {
		Optional<Quote> quote = quoteRepo.findById(id);
		QuoteResponse quoteResponse = mapper.map(quote, QuoteResponse.class);
		return quoteResponse;
	}
	
	public List<QuoteResponse> getAllQuotes() {
        List<Quote> quotes = quoteRepo.findAll();
        return quotes.stream()
                    .map(quote -> mapper.map(quote, QuoteResponse.class))
                    .collect(Collectors.toList());
    }
	
	 public QuoteResponse createQuote(Quote quoteData) {
	        Quote quote = mapper.map(quoteData, Quote.class);
	        quote = quoteRepo.save(quote);
	        return mapper.map(quote, QuoteResponse.class);
	 }
	 
	 public QuoteResponse updateQuote(int id, Quote quoteData) {
	        Quote existingQuote = quoteRepo.findById(id)
	                .orElseThrow();
	        mapper.map(quoteData, existingQuote);
	        existingQuote = quoteRepo.save(existingQuote);
	        return mapper.map(existingQuote, QuoteResponse.class);
	 }
	 
	 public void deleteQuoteById(int id) {
		 	quoteRepo.deleteById(id);
	 }

}
