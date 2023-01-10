package com.mintgenie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mintgenie.model.Watchlist;
import com.mintgenie.repository.EditRepo;

@Service
public class EditServiceImpl  implements EditService {
	
	@Autowired
	EditRepo editRepo;

	@Override
	public void renameWatchList(Watchlist watchlist,int id) {
		// TODO Auto-generated method stub
		Watchlist watchlistOG = editRepo.findById(id).get();
		System.out.println("In impl...");
		System.out.println(watchlist.getWatchlistName());
		
		watchlistOG.setWatchlistName(watchlist.getWatchlistName());
		editRepo.save(watchlistOG);
//		watchlistOG.setType(watchlistOG.getType());
//		watchlistOG.setNumberOfStocks(watchlistOG.getNumberOfStocks());
//		watchlistOG.setType(watchlistOG.getType());
//		watchlistOG.setUserId(watchlistOG.getUserId());
		
		
		
	}

	@Override
	public Watchlist getById(int id) {
		// TODO Auto-generated method stub
		Watchlist watchlist = editRepo.findById(id).get();
		return watchlist;
		
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		editRepo.deleteById(id);
		
	}

	
	
	

}
