package com.kasun.inspireaiquoteservice.repository;

import com.kasun.inspireaiquoteservice.entity.Quote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuoteRepo extends JpaRepository<Quote, Integer> {

}
