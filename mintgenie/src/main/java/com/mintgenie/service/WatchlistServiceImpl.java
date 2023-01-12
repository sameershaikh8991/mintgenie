package com.mintgenie.service;

import com.mintgenie.model.User;
import com.mintgenie.model.Watchlist;
import com.mintgenie.repository.UserRepo;
import com.mintgenie.repository.WatchlistRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WatchlistServiceImpl implements WatchlistService{

    static int count =1;
    @Autowired
    private WatchlistRepo watchlistRepo;
    @Autowired
    UserRepo userRepo;

    @Override
    public Watchlist createWatchlist(Watchlist watchlist, int userId, String type) {
      User user= userRepo.findById(userId).get();

      int count=user.getWatchlistCount();
      if(count<7){
          int updatedcount =count+1;
          user.setWatchlistCount(updatedcount);
          userRepo.save(user);
          watchlist.setUserId(userId);
          // watchlist.setWatchlistName(generateWatchlistName());
          watchlist.setType(type);
          Watchlist saveWatchlist= this.watchlistRepo.save(watchlist);
          return saveWatchlist;
      }else {
          System.out.println("limit reached");
      }


        return watchlist;
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

    public Watchlist updateWatchlist(Watchlist watchlist){
         return watchlistRepo.save(watchlist);
    }
}
