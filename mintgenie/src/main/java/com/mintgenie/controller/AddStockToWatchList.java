package com.mintgenie.controller;

import com.mintgenie.dto.WatchlistDataDTO;
import com.mintgenie.service.AddStockServiceImpl;
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
    AddStockServiceImpl addStockService;
    @Autowired
    WatchlistService watchlistService;


    @PostMapping("/addingStock")
    public WatchlistDataDTO addStock(@RequestBody WatchlistDataDTO watchlistDataDTO) {

        return addStockService.addStocks(watchlistDataDTO);

    }
}