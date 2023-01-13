package com.mintgenie.service;

import com.mintgenie.model.Stock;
import com.mintgenie.repository.StockRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockSearch {

    @Autowired
    private StockRepo stockRepo;


    public List<Stock> getByname(String stockname) {
        return stockRepo.findByStockNameContaining(stockname);
    }
}
