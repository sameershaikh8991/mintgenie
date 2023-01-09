package com.mintgenie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mintgenie.model.WatchlistData;
import com.mintgenie.service.AddStockService;

@RestController
@RequestMapping("/watchlist1")
public class AddStock {
	
	@Autowired
	AddStockService addStockService;
	
	@RequestMapping("/addStock")
	public WatchlistData addStock(@RequestBody WatchlistData data) {
		System.out.println("add Controller");
		return addStockService.addStocks(data);
	}
	
	
	

}
