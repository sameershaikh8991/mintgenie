package com.mintgenie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mintgenie.model.Stock;


@Repository
public interface StockRepo extends JpaRepository<Stock, Integer> {
	
	public List<Stock> findByStockName(String stockname);
	
	

}
