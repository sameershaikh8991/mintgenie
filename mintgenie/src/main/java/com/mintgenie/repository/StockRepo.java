package com.mintgenie.repository;

import com.mintgenie.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepo extends JpaRepository<Stock, Integer> {
}
