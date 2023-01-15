package com.mintgenie.controller;

import com.mintgenie.model.Stock;
import com.mintgenie.model.User;
import com.mintgenie.model.Watchlist;
import com.mintgenie.service.UserServiceImpl;
import com.mintgenie.service.WatchlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/watchlist")
public class WatchlistController {
    /***
     controlller to cretae the watchlist and
     ***/

    @Autowired
    private WatchlistService watchlistService;
    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/createWatchlist")
    public Watchlist createWatchlist(@RequestBody Watchlist watchlist, @RequestParam int userId, @RequestParam String type) {
        User user = userService.getById(userId);
        watchlist.setNumberOfStocks(0);
        return this.watchlistService.createWatchlist(watchlist, userId, type);
    }

    @GetMapping("/getByWatchlistId")
    public Watchlist getByWatchlistId(@RequestParam int id) {
        return this.watchlistService.getByWatchlistId(id);
    }

    @GetMapping("/watchlistStocks")
    public List<Stock> getAllStocksByWatchlistId (@RequestParam int id){
        return this.watchlistService.stockList(id)
                ;
    }
}
