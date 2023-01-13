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

    @Autowired
    private WatchlistService watchlistService;

    public void deletestockserv(int sid, int wid, int uid) {
        System.out.println(" in delete stock service......");
        watchlistDataRepo.deleteStock(sid, wid, uid);
//        watchlist=watchlistService.getByWatchlistId(wid);
//        int stocknumber=watchlist.getNumberOfStocks();
//        System.out.println("current stock number:"+stocknumber);
//        int newst =stocknumber-1;
//        watchlist.setNumberOfStocks(newst);

    }

    public void W1(int wid) {
        Watchlist watchlist = watchlistService.getByWatchlistId(wid);
        if (watchlist != null) {
            int stocknumber = watchlist.getNumberOfStocks();
            System.out.println("current stock number:" + stocknumber);
            if (stocknumber > 0) {
                int newst = stocknumber - 1;
                watchlist.setNumberOfStocks(newst);
                watchlistService.updateWatchlist(watchlist);
            }
        } else {
            System.out.println("no stock to delete");
        }

    }

}
