package com.mintgenie.service;

import com.mintgenie.model.Stock;
import com.mintgenie.model.Watchlist;
import com.mintgenie.repository.WatchlistRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mintgenie.model.WatchlistData;
import com.mintgenie.repository.AddRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AddStockService {

    @Autowired
    AddRepo addRepo;
    @Autowired
    private WatchlistRepo watchlistRepo;

    @Autowired
    private WatchlistService watchlistService;

    public WatchlistData addStocks(WatchlistData watchlistData) {
        int watchListId = watchlistData.getId().getWatchlistid();
        int stockid=watchlistData.getId().getStockid();
        Watchlist watchlist = watchlistService.getByWatchlistId(watchListId);
        Optional<WatchlistData> data = addRepo.findByIdWatchlistidAndIdStockid(watchListId,stockid);
        System.out.println(data);
        if (!data.isPresent()){
            int stocknumber = watchlist.getNumberOfStocks();
            System.out.println(stocknumber);
            if (stocknumber < 10) {
                addRepo.save(watchlistData);
                stocknumber = stocknumber + 1;
                watchlist.setNumberOfStocks(stocknumber);
                watchlistService.updateWatchlist(watchlist);
                return watchlistData;

            } else {
                System.err.println("Limit has been reached Please create new watchlist");
            }
        }else {
            System.err.println("Stock already present in the watchlist");
        }

        return watchlistData;

    }
}
