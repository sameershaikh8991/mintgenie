package com.mintgenie.service;

import com.mintgenie.model.Stock;
import com.mintgenie.model.Watchlist;

import java.util.List;

public interface WatchlistService {
    Watchlist createWatchlist(Watchlist watchlist, int userId, String type);

    Watchlist getByWatchlistId(int id);

    Watchlist updateWatchlist(Watchlist watchlist);

    public void renameWatchList(Watchlist watchlist, int id);

    public void deleteById(int id);

    List<Stock> stockList(int id);
}
