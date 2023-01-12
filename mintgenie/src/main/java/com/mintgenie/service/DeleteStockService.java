package com.mintgenie.service;

import com.mintgenie.model.Watchlist;
import com.mintgenie.repository.WatchlistDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class DeleteStockService {

    @Autowired
    private WatchlistDataRepo watchlistDataRepo;

//    @Autowired
//    private  Watchlist watchlist;


    @Autowired
    private WatchlistService watchlistService;

    public void deletestockserv(int sid,int wid,int uid){
        watchlistDataRepo.deleteStock(sid,wid,uid);
//        watchlist=watchlistService.getByWatchlistId(wid);
//        int stocknumber=watchlist.getNumberOfStocks();
//        System.out.println("current stock number:"+stocknumber);
//        int newst =stocknumber-1;
//        watchlist.setNumberOfStocks(newst);

    }

    public int W1(int wid){
       Watchlist  watchlist=watchlistService.getByWatchlistId(wid);
        int stocknumber=watchlist.getNumberOfStocks();
        System.out.println("current stock number:"+stocknumber);
        int newst =stocknumber-1;
        watchlist.setNumberOfStocks(newst);
       watchlistService.updateWatchlist(watchlist);
        return  1;
    }

}
