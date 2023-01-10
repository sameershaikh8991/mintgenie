package com.mintgenie.service;

import com.mintgenie.model.Watchlist;

public interface EditService {
	
	public void renameWatchList(Watchlist watchlist,int id);
	public Watchlist getById(int id);
	public void deleteById(int id);

}
