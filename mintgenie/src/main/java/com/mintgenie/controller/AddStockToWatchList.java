package com.mintgenie.controller;

import com.mintgenie.model.Watchlist;
import com.mintgenie.model.WatchlistData;
import com.mintgenie.service.AddStockService;
import com.mintgenie.service.EditService;
import com.mintgenie.service.WatchlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/addStocktoWatchList")
public class AddStockToWatchList {
    /**
     * controller to add the stock to the watchList
     */

    @Autowired
    AddStockService addStockService;
    @Autowired
    WatchlistService watchlistService;


    @PostMapping("/addingStock")
    public WatchlistData addStock(@RequestBody WatchlistData watchlistData) {

        return addStockService.addStocks(watchlistData);

    }
}
