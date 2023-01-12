package com.mintgenie.service;

import com.mintgenie.dto.StockDTO;
import com.mintgenie.dto.WatchlistDTO;

import java.util.List;

public interface WatchlistService {

    WatchlistDTO createWatchlist(WatchlistDTO watchlistDTO, int userId, String type);

    List<StockDTO> getByWatchlistId(int id);

}
