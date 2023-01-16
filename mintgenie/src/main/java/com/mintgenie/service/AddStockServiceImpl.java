package com.mintgenie.service;

import com.mintgenie.dto.WatchlistDTO;
import com.mintgenie.dto.WatchlistDataDTO;
import com.mintgenie.model.Stock;
import com.mintgenie.model.Watchlist;
import com.mintgenie.payload.ModelMapperPayload;
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
public class AddStockServiceImpl {

    @Autowired
    AddRepo addRepo;
    @Autowired
    private WatchlistRepo watchlistRepo;

    @Autowired
    private ModelMapperPayload modelMapperPayload;
    @Autowired
    private WatchlistService watchlistService;

    public WatchlistDataDTO addStocks(WatchlistDataDTO watchlistDataDTO) {
        int watchListId = watchlistDataDTO.getId().getWatchlistid();
        WatchlistDTO watchlistDTO = watchlistService.getByWatchlistId(watchListId);
        int stocknumber = watchlistDTO.getNumberOfStocks();
        System.out.println(stocknumber);
        if (stocknumber < 10) {
            WatchlistData watchlistData1 = this.modelMapperPayload.dtoToWatchlistData(watchlistDataDTO);
            this.addRepo.save(watchlistData1);
            stocknumber = stocknumber + 1;
            watchlistDTO.setNumberOfStocks(stocknumber);
            watchlistService.updateWatchlist(watchlistDTO);
            return watchlistDataDTO;

        } else {
            System.err.println("Limit has been reached Please create new watchlist");
        }
        return watchlistDataDTO;

    }
}