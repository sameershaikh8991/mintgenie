package com.mintgenie.payload;

import com.mintgenie.dto.StockDTO;
import com.mintgenie.dto.UserDTO;
import com.mintgenie.dto.WatchlistDTO;
import com.mintgenie.dto.WatchlistDataDTO;
import com.mintgenie.model.Stock;
import com.mintgenie.model.User;
import com.mintgenie.model.Watchlist;
import com.mintgenie.model.WatchlistData;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperPayload {

    @Autowired
    private ModelMapper modelMapper;

    public User dtoToUser(UserDTO userDTO) {
        User user = this.modelMapper.map(userDTO, User.class);
        return user;
    }

    public UserDTO userToDto(User user) {
        UserDTO userDTO = this.modelMapper.map(user, UserDTO.class);
        return userDTO;
    }

    public Watchlist dtoToWatchlist(WatchlistDTO watchlistDTO) {
        Watchlist watchlist = this.modelMapper.map(watchlistDTO, Watchlist.class);
        return watchlist;
    }

    public WatchlistDTO watchlistToDto(Watchlist watchlist) {
        WatchlistDTO watchlistDTO = this.modelMapper.map(watchlist, WatchlistDTO.class);
        return watchlistDTO;
    }

    public WatchlistData dtoToWatchlistData(WatchlistDataDTO watchlistDataDTO) {
        WatchlistData watchlistData = this.modelMapper.map(watchlistDataDTO, WatchlistData.class);
        return watchlistData;
    }

    public WatchlistDataDTO watchlistDataToDto(WatchlistData watchlistData) {
        WatchlistDataDTO watchlistDataDTO = this.modelMapper.map(watchlistData, WatchlistDataDTO.class);
        return watchlistDataDTO;
    }

    public Stock dtoToStock(StockDTO stockDTO) {
        Stock stock = this.modelMapper.map(stockDTO, Stock.class);
        return stock;
    }

    public StockDTO stockToDto(Stock stock) {
        StockDTO stockDTO = this.modelMapper.map(stock, StockDTO.class);
        return stockDTO;
    }

    public StockDTO entityToDTO(Stock stock){
        StockDTO stockDTO = new StockDTO();
        BeanUtils.copyProperties(stock, stockDTO);
        return stockDTO;
    }
}
