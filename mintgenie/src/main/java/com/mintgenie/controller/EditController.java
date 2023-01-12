package com.mintgenie.controller;

import com.mintgenie.service.WatchlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mintgenie.model.Watchlist;

@RestController
@RequestMapping("/edit")
public class EditController {
    /**
     * controller to edit the watchlist
     **/


    @Autowired
    WatchlistService watchlistService;

    @PutMapping("/renameWatchlist")
    public Watchlist renameWatchlist(@RequestParam int id, @RequestBody Watchlist watchlist) {
        Watchlist watchlistOG = watchlistService.getByWatchlistId(id);
        watchlistService.renameWatchList(watchlist, id);
        return watchlistOG;

    }

    @DeleteMapping("/deleteWatchlist")
    public void deleteWatchList(@RequestParam int id) {
        Watchlist watchlistOG = watchlistService.getByWatchlistId(id);
        watchlistService.deleteById(id);
        System.out.println("Deleted successfully");
    }

}
