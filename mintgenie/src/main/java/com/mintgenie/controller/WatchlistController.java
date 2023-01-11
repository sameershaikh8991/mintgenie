package com.mintgenie.controller;

import com.mintgenie.model.Stock;
import com.mintgenie.model.User;
import com.mintgenie.model.Watchlist;
import com.mintgenie.model.WatchlistData;
import com.mintgenie.service.AddStockService;
import com.mintgenie.service.UserServiceImpl;
import com.mintgenie.service.WatchlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/watchlist")
public class WatchlistController {

    @Autowired
    private WatchlistService watchlistService;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private AddStockService addStockService;

    @PostMapping("/createWatchlist")
    public Watchlist createWatchlist(@RequestBody Watchlist watchlist, @RequestParam int userId, @RequestParam String type){
       User user=  userService.getById(userId);
        watchlist.setNumberOfStocks(0);
        return this.watchlistService.createWatchlist(watchlist, userId, type);
    }

    @GetMapping("/getByWatchlistId")
    public List<Stock> getByWatchlistId(@RequestParam int id){

        WatchlistData watchlistData =this.addStockService.getByWatchListId(id);
        List<Stock> watchlistDataList= watchlistData.getStockList();

        return watchlistDataList;
    }

}
