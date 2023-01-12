package com.mintgenie.service;

import com.mintgenie.dto.StockDTO;
import com.mintgenie.dto.UserDTO;
import com.mintgenie.dto.WatchlistDTO;
import com.mintgenie.model.Stock;
import com.mintgenie.model.User;
import com.mintgenie.model.Watchlist;
import com.mintgenie.model.WatchlistData;
import com.mintgenie.payload.ModelMapperPayload;
import com.mintgenie.repository.UserRepo;
import com.mintgenie.repository.WatchlistRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WatchlistServiceImpl implements WatchlistService {

    static int count = 1;
    @Autowired
    UserRepo userRepo;
    @Autowired
    private WatchlistRepo watchlistRepo;

    @Autowired
    private AddStockService addStockService;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private ModelMapperPayload modelMapperPayload;

    public static String generateWatchlistName() {

        int increment = count++;
        String wname = "Watchlist " + increment;
        return wname;
    }

    @Override
    public WatchlistDTO createWatchlist(WatchlistDTO watchlistDTO, int userId, String type) {
        User user = userRepo.findById(userId).get();
        UserDTO userDTO = userService.getById(userId);
        watchlistDTO.setNumberOfStocks(0);
        int count = user.getWatchlistCount();
        if (count < 7) {
            int updatedcount = count + 1;
            user.setWatchlistCount(updatedcount);
            userRepo.save(user);
            watchlistDTO.setUserId(userId);
            // watchlist.setWatchlistName(generateWatchlistName());
            watchlistDTO.setType(type);
            Watchlist watchlist = this.modelMapperPayload.dtoToWatchlist(watchlistDTO);
            Watchlist savedWatchlist = this.watchlistRepo.save(watchlist);
            return this.modelMapperPayload.watchlistToDto(savedWatchlist);

        } else {
            System.err.println("Watchlist Limit is Exceeded");
        }

        return watchlistDTO;
    }

    @Override
    public List<StockDTO> getByWatchlistId(int id) {
        WatchlistData watchlistData = this.addStockService.getByWatchListId(id);
        List<Stock> stocks = watchlistData.getStockList();
        List<StockDTO> watchlistStockList = stocks.stream().map(stock -> this.modelMapperPayload.stockToDto(stock)).collect(Collectors.toList());
        return watchlistStockList;
    }

}
