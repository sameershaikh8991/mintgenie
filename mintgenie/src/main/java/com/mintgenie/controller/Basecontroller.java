package com.mintgenie.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mintgenie.model.Mutualfund;
import com.mintgenie.model.Stock;
import com.mintgenie.model.Watchlistdata;
import com.mintgenie.repository.Watchlistdatarepo;
import com.mintgenie.service.SearchadaService;


@RestController
@RequestMapping(value = "/watchlist")
public class Basecontroller {
	
	@Autowired
	private SearchadaService service;
	
	
	
	@Autowired
	private Watchlistdatarepo watchlistdatarepo;
	
	@GetMapping("")
	public String Home() {
		return "Hello sameer";
	}
	
	
	
	@GetMapping(value = "/allst")
	public List<Stock> all(){
		System.out.println("in all");
		return service.allStock();
		
		
	}
	
	@GetMapping(value = "st/search")
	public List<Stock> getByname(@RequestParam String stockname){
		return service.getByNames(stockname);
		
		
	}
	
	@GetMapping(value = "/allmf")
	public List<Stock> allmf(){
		System.out.println("in all");
		return service.allStock();
		
	}
	
	
	@PostMapping(value = "/st/search/add")
	public Watchlistdata saveStock(@RequestBody Watchlistdata watchlistdata,@RequestParam int sid)  {
//		Stock byid = service.getByStockid(id);
//		System.out.println(byid.getStock_name());
		
		watchlistdata.setTickerid(sid);
				
		return  service.addstock(watchlistdata);
		
		
	}	

	
}
