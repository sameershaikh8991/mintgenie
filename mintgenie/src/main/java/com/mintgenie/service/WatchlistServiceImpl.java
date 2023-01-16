package com.mintgenie.service;

import com.mintgenie.dto.StockDTO;
import com.mintgenie.dto.UserDTO;
import com.mintgenie.dto.WatchlistDTO;
import com.mintgenie.model.Stock;
import com.mintgenie.model.User;
import com.mintgenie.model.Watchlist;
import com.mintgenie.payload.ModelMapperPayload;
import com.mintgenie.repository.StockRepo;
import com.mintgenie.repository.UserRepo;
import com.mintgenie.repository.WatchlistRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class WatchlistServiceImpl implements WatchlistService {

    static int count = 1;
    @Autowired
    UserRepo userRepo;
    @Autowired
    private WatchlistRepo watchlistRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private StockRepo stockRepo;

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
    public WatchlistDTO getByWatchlistId(int id) {
        Watchlist watchlist = this.watchlistRepo.findById(id).get();

        return this.modelMapperPayload.watchlistToDto(watchlist);
    }

    @Override
    public List<StockDTO> stockList(int id) {
        List<Integer> stockIdList = this.watchlistRepo.findAllStocksFromWatchlist(id);
        List<Stock> stocks = new ArrayList<>();
            for(int i=0;i<stockIdList.size();i++){
                Stock stock = stockRepo.findById(stockIdList.get(i)).get();
                stocks.add(stock);
            }
        System.out.println(stocks);

/*        List<StockDTO> stockDTOS = stocks
                .stream()
                .map(stock -> this.modelMapperPayload.stockToDto(stock))
                .collect(Collectors.toList());*/
        List<StockDTO> stockDTOS  = stocks.stream().map(stock -> this.modelMapper.map(stock, StockDTO.class)).collect(Collectors.toList());
//        List<StockDTO> stockDTOS = Arrays.asList(modelMapper.map(stocks, StockDTO[].class));
        /*List<StockDTO> stockDTOS = stocks
                .stream()
                        .map(modelMapperPayload::entityToDTO)
                                .collect(Collectors.toList());*/
        System.out.println(stockDTOS);
        return stockDTOS;
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
