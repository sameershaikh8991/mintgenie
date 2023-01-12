package com.mintgenie.service;

import com.mintgenie.dto.WatchlistDTO;
import com.mintgenie.model.Watchlist;

public interface EditService {

    WatchlistDTO renameWatchList(WatchlistDTO watchlistDTO, int id);

    public Watchlist getById(int id);

    public void deleteById(int id);

    WatchlistDTO updatestockNumber(int id, int number);

}
