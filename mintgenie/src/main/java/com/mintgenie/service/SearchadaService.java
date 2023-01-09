package com.mintgenie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mintgenie.model.Mutualfund;
import com.mintgenie.model.Stock;
import com.mintgenie.model.Watchlistdata;
import com.mintgenie.repository.MutualfundRepo;
import com.mintgenie.repository.StockRepo;
import com.mintgenie.repository.Watchlistdatarepo;

@Service
public class SearchadaService {
	
	@Autowired
	private StockRepo repo;
	
	@Autowired
	private MutualfundRepo mutualfundRepo;
	@Autowired
	private Watchlistdatarepo watchlistdatarepo;
	
	
	public List<Stock> allStock() {
		return repo.findAll();
	}
	
	
	public List<Stock> getByNames(String stockname) {
		return repo.findByStockName(stockname);
	}
	
	public Stock getByStockid(int sid) {
		return repo.findById(sid).get();
	}
	
	
	
	public Watchlistdata addstock(Watchlistdata watchlistdata) {
		return watchlistdatarepo.save(watchlistdata);
	}
	
	public List<Mutualfund> allMf() {
		return mutualfundRepo.findAll();
	}
	

	
	
	
//	public List<Stock> allMutualFunds() {
//		return repo.findAll();
//	}
	
	
	
	
	
}
