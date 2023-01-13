package com.mintgenie.controller;

import com.mintgenie.dto.StockDTO;
import com.mintgenie.dto.WatchlistDTO;
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


    @PostMapping("/createWatchlist")
    public WatchlistDTO createWatchlist(@RequestBody WatchlistDTO watchlistDTO, @RequestParam int userId, @RequestParam String type) {
//        UserDTO userDTO = userService.getById(userId);
//        watchlistDTO.setNumberOfStocks(0);
//        return this.watchlistService.createWatchlist(watchlist, userId, type);
        return this.watchlistService.createWatchlist(watchlistDTO, userId, type);
    }

    @GetMapping("/getByWatchlistId")
    public WatchlistDTO getByWatchlistId(@RequestParam int id){
//        return this.watchlistService.getByWatchlistId(id);
        return this.watchlistService.getByWatchlistId(id);
    }

}
