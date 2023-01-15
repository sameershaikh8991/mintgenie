package com.mintgenie.service;

import com.mintgenie.exceptions.NotfoundException;
import com.mintgenie.model.Stock;
import com.mintgenie.model.User;
import com.mintgenie.model.Watchlist;
import com.mintgenie.repository.AddRepo;

import com.mintgenie.repository.StockRepo;
import com.mintgenie.repository.UserRepo;
import com.mintgenie.repository.WatchlistRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WatchlistServiceImpl implements WatchlistService {

    static int count = 1;
    @Autowired
    private WatchlistRepo watchlistRepo;
    @Autowired
    UserRepo userRepo;
    @Autowired
    private AddRepo addRepo;
    @Autowired
    StockRepo stockRepo;


    @Override
    public Watchlist createWatchlist(Watchlist watchlist, int userId, String type) {
        User user = userRepo.findById(userId).get();

        int count = user.getWatchlistCount();
        if (count < 7) {
            int updatedcount = count + 1;
            user.setWatchlistCount(updatedcount);
            userRepo.save(user);
            watchlist.setUserId(userId);
            // watchlist.setWatchlistName(generateWatchlistName());
            watchlist.setType(type);
            Watchlist saveWatchlist = this.watchlistRepo.save(watchlist);
            return saveWatchlist;
        } else {
            System.out.println("limit reached");
        }


        return watchlist;
    }

    @Override
    public Watchlist getByWatchlistId(int id) {

        Watchlist watchlist1 = watchlistRepo.findById(id).orElseThrow(() -> new NotfoundException(id));
        watchlist1.getWatchlistId();
        return watchlist1;


    }

    public static String generateWatchlistName() {

        int increment = count++;
        String wname = "Watchlist " + increment;
        return wname;
    }

    public Watchlist updateWatchlist(Watchlist watchlist) {
        return watchlistRepo.save(watchlist);
    }

    @Override
    public void renameWatchList(Watchlist watchlist, int id) {
        // TODO Auto-generated method stub
        Watchlist watchlistOG = watchlistRepo.findById(id).get();

        System.out.println(watchlist.getWatchlistName());

        watchlistOG.setWatchlistName(watchlist.getWatchlistName());
        watchlistRepo.save(watchlistOG);

    }


    @Override
    public void deleteById(int id) {
        // TODO Auto-generated method stub
        Watchlist watchlist = watchlistRepo.findById(id).get();
        int userId = watchlist.getUserId();
        User user = userRepo.findById(userId).get();
        int oldCount = user.getWatchlistCount();
        watchlistRepo.deleteById(id);
        oldCount = oldCount - 1;
        user.setWatchlistCount(oldCount);
        userRepo.save(user);
        addRepo.deleteByIdWatchlistid(id);
        //  addRepo.deleteByIdWatchlistid(id);

    }

    @Override
    public List<Stock> stockList(int id) {
        System.out.println(id);
        List<Integer> stockIdList=   watchlistRepo.findAllStocksFromWatchlist(id);
        System.out.println(stockIdList);
        List<Stock> stocks = new ArrayList<>();
//        stocks.addAll(stockIdList);
        for (int i = 0; i < stockIdList.size(); i++) {
            Stock stock = stockRepo.findById(stockIdList.get(i)).get();
            stocks.add(stock);
        }
        return  stocks;
    }
}
