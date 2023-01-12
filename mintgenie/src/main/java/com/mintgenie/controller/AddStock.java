package com.mintgenie.controller;

import com.mintgenie.model.Stock;
import com.mintgenie.model.Watchlist;
import com.mintgenie.model.WatchlistData;
import com.mintgenie.service.AddStockService;
import com.mintgenie.service.EditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/watchlist1")
public class AddStock {

    @Autowired
    AddStockService addStockService;
    @Autowired
    EditService editService;

    @PostMapping("/addStock")
    public WatchlistData addStock(@RequestBody WatchlistData data) {
        //getting watchlistId
        int watchListId = data.getId().getWatchlistid();
        //gettingWatchListDataById
        Watchlist watchlist = editService.getById(watchListId);
        List<Stock> postStock = data.getStockList();

        int initialNum = watchlist.getNumberOfStocks();
        int numberOFStock = initialNum + postStock.size();
        //Optional<WatchlistData> watchlistData= Optional.ofNullable(addStockService.getByWatchListId(watchListId));
        //System.out.println(watchlistData);
        if (initialNum == 0) {

            addStockService.newlyAdded(data);
            return addStockService.addStocks(data);

        } else if (numberOFStock < 10) {
            WatchlistData watchlistData1 = addStockService.getByWatchListId(watchListId);
            // WatchlistData watchlistData2=watchlistData1;
            List<Stock> stocks = addStockService.updateStockList(data);
            watchlistData1.setStockList(stocks);
            return addStockService.addStocks(watchlistData1);


        } else {
            System.err.println("limit has been reached");
        }
//		 return null;


        return data;
    }


}


//getting watchlist by id
//		Watchlist watchlist = editService.getById(watchListId);
//
//		//getting  list of stock that we posted
//		List<Stock> stocks = data.getStockList();
//		//updatingTotalStocksinWatchList
//	List<Stock> updatedList=addStockService.updateStockList(watchlistData);
//data.setStockList(updatedList);
//
////getting  list of stock that we posted
//		List<Stock> updatedstocks = data.getStockList();
//
//		//sizeof list
//		int numberofStocks = updatedstocks.size();
//		//updatingStockNumerInWatchList
//		editService.updatestockNumber(watchListId,numberofStocks);
//		return addStockService.addStocks(data);