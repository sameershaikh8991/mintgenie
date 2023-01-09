package com.mintgenie.service;

import com.mintgenie.model.Watchlist;

public interface WatchlistService {
    Watchlist createWatchlist(Watchlist watchlist, int userId, String type);
    Watchlist getByWatchlistId(int id);

}