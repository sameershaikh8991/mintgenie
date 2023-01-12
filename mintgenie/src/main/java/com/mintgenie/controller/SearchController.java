package com.mintgenie.controller;


import com.mintgenie.model.Stock;
import com.mintgenie.service.StockSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/watchlist")
public class SearchController {

    @Autowired
    private StockSearch searchService;

    /*

    THIS IS SEARCH CONTROLLER TO SEARCH STOCK

     */
    @GetMapping("/search")
    public List<Stock> SearchByName(@RequestParam String stockname){
        System.out.println(" in search controller "+stockname);

        return searchService.getByname(stockname);
    }

}
