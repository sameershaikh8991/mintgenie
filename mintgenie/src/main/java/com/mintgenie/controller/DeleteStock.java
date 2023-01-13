package com.mintgenie.controller;

import com.mintgenie.model.Watchlist;
import com.mintgenie.repository.WatchlistDataRepo;
import com.mintgenie.service.DeleteStockService;
import com.mintgenie.service.WatchlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/watchlist")
public class DeleteStock {

    @Autowired
    private DeleteStockService delete1;

    /*

      Delete stock controller

     */
    @DeleteMapping("/deletestock")
    public void deletedata(@RequestParam int sid, @RequestParam int wid, @RequestParam int uid) {
        System.out.println(" in delete stock controller");
        delete1.deletestockserv(sid, wid, uid);
        delete1.W1(wid);
    }


}
