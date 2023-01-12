package com.mintgenie.service;

import com.mintgenie.model.Stock;
import com.mintgenie.model.Watchlist;
import com.mintgenie.repository.WatchlistRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mintgenie.model.WatchlistData;
import com.mintgenie.repository.AddRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddStockService {
	
	@Autowired
	AddRepo addRepo;
	@Autowired
	private WatchlistRepo watchlistRepo;


	public WatchlistData addStocks( WatchlistData data) {
		//List<Stock> stocklist = data.getStockList();

		addRepo.save(data);
		return data;
		
	}

	public Optional<WatchlistData> getByWatchListId(int id){

		String type="stock";

		return addRepo.findByIdWatchlistid(id);
	}

	public List<Stock> updateStockList(WatchlistData watchlistData){

		int watchListId =watchlistData.getId().getWatchlistid();
		Watchlist watchlist=watchlistRepo.findById(watchListId).get();
		WatchlistData oldWatchList= addRepo.findByIdWatchlistid(watchListId).get();
		List<Stock> oldStockList=oldWatchList.getStockList();


	List<Stock> newStockList=watchlistData.getStockList();
	List<Stock> MergedList=new ArrayList<>();
	MergedList.addAll(oldStockList);
		MergedList.addAll(newStockList);
		int oldcount=watchlist.getNumberOfStocks();
		watchlist.setNumberOfStocks(MergedList.size());
		watchlistRepo.save(watchlist);

		return MergedList;


	}

	public void newlyAdded(WatchlistData watchlistData){
		int currentsize=watchlistData.getStockList().size();
		int watchlistId= watchlistData.getId().getWatchlistid();
		Watchlist watchlist=watchlistRepo.findById(watchlistId).get();
		watchlist.setNumberOfStocks(currentsize);
		watchlistRepo.save(watchlist);

	}



}
