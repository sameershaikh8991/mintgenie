package com.mintgenie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mintgenie.model.Watchlist;
import com.mintgenie.service.EditService;
import com.mintgenie.service.EditServiceImpl;

@RestController
@RequestMapping("/edit")
public class EditController {
	
	@Autowired
	EditService editService;
	
	@PutMapping("/renameWatchlist")
	public Watchlist renameWatchlist(@RequestParam int id,@RequestBody Watchlist watchlist) {
		
		
		Watchlist watchlistOG = editService.getById(id);
		System.out.println(watchlist);
		editService.renameWatchList(watchlist,id);
		return watchlistOG;
		
	}
	
	@DeleteMapping("/deleteWatchlist")
	public void deleteWatchList(@RequestParam int id) {
		Watchlist watchlistOG = editService.getById(id);
		editService.deleteById(id);
		System.out.println("Deleted successfully");
	}

}
