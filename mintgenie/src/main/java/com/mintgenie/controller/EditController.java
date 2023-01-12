package com.mintgenie.controller;

import com.mintgenie.dto.WatchlistDTO;
import com.mintgenie.model.Watchlist;
import com.mintgenie.service.EditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/edit")
public class EditController {

    @Autowired
    EditService editService;

    @PutMapping("/renameWatchlist")
    public Watchlist renameWatchlist(@RequestParam int id, @RequestBody WatchlistDTO watchlistDTO) {


        Watchlist watchlistOG = editService.getById(id);
        System.out.println(watchlistDTO);
        editService.renameWatchList(watchlistDTO, id);
        return watchlistOG;

    }

    @DeleteMapping("/deleteWatchlist")
    public void deleteWatchList(@RequestParam int id) {
        Watchlist watchlistOG = editService.getById(id);
        editService.deleteById(id);
        System.out.println("Deleted successfully");
    }

}
