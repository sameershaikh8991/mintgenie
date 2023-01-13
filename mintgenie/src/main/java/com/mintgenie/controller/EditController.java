package com.mintgenie.controller;

import com.mintgenie.dto.WatchlistDTO;
import com.mintgenie.service.WatchlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/edit")
public class EditController {

    @Autowired
    private WatchlistService watchlistService;

    @PutMapping("/renameWatchlist")
    public WatchlistDTO renameWatchlist(@RequestParam int id, @RequestBody WatchlistDTO watchlistDTO) {
        return this.watchlistService.renameWatchList(watchlistDTO,id);
    }

    @DeleteMapping("/deleteWatchlist")
    public void deleteWatchList(@RequestParam int id) {
        this.watchlistService.deleteById(id);
    }

}
