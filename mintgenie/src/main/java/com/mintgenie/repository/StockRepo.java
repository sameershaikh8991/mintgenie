package com.mintgenie.repository;

import com.mintgenie.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StockRepo extends JpaRepository<Stock, Integer> {

    public List<Stock> findByStockNameContaining(String stockname);

}
