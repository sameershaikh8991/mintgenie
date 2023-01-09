package com.mintgenie.service;

import com.mintgenie.model.Watchlist;
import com.mintgenie.repository.WatchlistRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WatchlistServiceImpl implements WatchlistService{

    static int count =1;
    @Autowired
    private WatchlistRepo watchlistRepo;

    @Override
    public Watchlist createWatchlist(Watchlist watchlist, int userId, String type) {
        watchlist.setUserId(userId);
        watchlist.setWatchlistName(generateWatchlistName());
        watchlist.setType(type);
        Watchlist saveWatchlist= this.watchlistRepo.save(watchlist);
        return saveWatchlist;
    }

    @Override
    public Watchlist getByWatchlistId(int id) {
        Watchlist watchlist1 = this.watchlistRepo.findById(id).get();
        return watchlist1;
    }

    public static String generateWatchlistName(){

        int increment = count++;
        String wname = "Watchlist " + increment;
        return wname;
    }
}
