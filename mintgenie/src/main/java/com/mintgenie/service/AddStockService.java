package com.mintgenie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mintgenie.model.WatchlistData;
import com.mintgenie.repository.AddRepo;

@Service
public class AddStockService {
	
	@Autowired
	AddRepo addRepo;
	
	
	public WatchlistData addStocks(WatchlistData data) {
		addRepo.save(data);
		return data;
		
	}
	

}
