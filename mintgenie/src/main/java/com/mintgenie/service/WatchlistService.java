package com.mintgenie.service;

import com.mintgenie.dto.StockDTO;
import com.mintgenie.dto.WatchlistDTO;
import com.mintgenie.model.Watchlist;

import java.util.List;

public interface WatchlistService {

    WatchlistDTO createWatchlist(WatchlistDTO watchlistDTO, int userId, String type);

    public WatchlistDTO getByWatchlistId(int id);

    List<StockDTO> getAllStocksByWatchlistId(int id);

    WatchlistDTO updateWatchlist(WatchlistDTO watchlistDTO);

    WatchlistDTO renameWatchList(WatchlistDTO watchlistDTO, int id);

    void deleteById(int id);
}
