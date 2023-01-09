package com.mintgenie.controller;

import com.mintgenie.model.Watchlist;
import com.mintgenie.service.WatchlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/watchlist")
public class WatchlistController {

    @Autowired
    private WatchlistService watchlistService;

    @PostMapping("/createWatchlist")
    public Watchlist createWatchlist(@RequestBody Watchlist watchlist, @RequestParam int userId, @RequestParam String type){
        return this.watchlistService.createWatchlist(watchlist, userId, type);
    }

    @GetMapping("/getByWatchlistId")
    public Watchlist getByWatchlistId(@RequestParam int id){
        return this.watchlistService.getByWatchlistId(id);
    }

}
