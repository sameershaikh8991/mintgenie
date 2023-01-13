package com.mintgenie.service;

import com.mintgenie.dto.StockDTO;
import com.mintgenie.dto.UserDTO;
import com.mintgenie.dto.WatchlistDTO;
import com.mintgenie.dto.WatchlistDataDTO;
import com.mintgenie.model.Stock;
import com.mintgenie.model.User;
import com.mintgenie.model.Watchlist;
import com.mintgenie.model.WatchlistData;
import com.mintgenie.payload.ModelMapperPayload;
import com.mintgenie.repository.AddRepo;
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
    private AddRepo addRepo;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private WatchlistService watchlistService;

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
    public WatchlistDTO getByWatchlistId(int id) {
        Watchlist watchlist = this.watchlistRepo.findById(id).get();
        return this.modelMapperPayload.watchlistToDto(watchlist);
    }

    @Override
    public List<StockDTO> getAllStocksByWatchlistId(int id/*, WatchlistDataDTO watchlistDataDTO*/) {
//        int watchlistId = watchlistDataDTO.getId().getWatchlistid();
//        List<WatchlistDataDTO> stocks = watchlistDataDTO.getId().getStockid();
//        List<StockDTO> stockDTOS = stocks.stream().map(stock -> this.modelMapperPayload.stockToDto(stock)).collect(Collectors.toList());
        return null;
    }

    @Override
    public WatchlistDTO updateWatchlist(WatchlistDTO watchlistDTO) {
        Watchlist watchlist = this.modelMapperPayload.dtoToWatchlist(watchlistDTO);
        Watchlist updatedWatchlist = this.watchlistRepo.save(watchlist);
        return this.modelMapperPayload.watchlistToDto(updatedWatchlist);
    }

    @Override
    public WatchlistDTO renameWatchList(WatchlistDTO watchlistDTO, int id) {
        // TODO Auto-generated method stub
        Watchlist watchlistOG = watchlistRepo.findById(id).get();

        System.out.println(watchlistDTO.getWatchlistName());

        watchlistOG.setWatchlistName(watchlistDTO.getWatchlistName());
        watchlistRepo.save(watchlistOG);

        return watchlistDTO;
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
        //  addRepo.deleteByIdWatchlistid(id);

    }

}
