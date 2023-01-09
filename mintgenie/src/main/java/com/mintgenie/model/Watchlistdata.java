package com.mintgenie.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.databind.deser.std.UntypedObjectDeserializer;

@Entity
public class Watchlistdata {
	
	
	@Id
	private int watchlistid;
	private int userid;
	private String type;
	private String watchlistname;
	private int tickerid;
//	@OneToMany
//	private List<Stock> stockList;

		
	public Watchlistdata() {
		super();
	}


//	public Watchlistdata(int watchlistid, int userid, String type, int tickerid, List<Stock> stockList) {
//		super();
//		this.watchlistid = watchlistid;
//		this.userid = userid;
//		this.type = type;
//		this.tickerid = tickerid;
//		this.stockList = stockList;
//	}
	
	
	


	public int getWatchlistid() {
		return watchlistid;
	}




	public Watchlistdata(int watchlistid, int userid, String type, String watchlistname, int tickerid) {
	super();
	this.watchlistid = watchlistid;
	this.userid = userid;
	this.type = type;
	this.watchlistname = watchlistname;
	this.tickerid = tickerid;
}


	public void setWatchlistid(int watchlistid) {
		this.watchlistid = watchlistid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getTickerid() {
		return tickerid;
	}

	public void setTickerid(int tickerid) {
		this.tickerid = tickerid;
	}


	public String getWatchlistname() {
		return watchlistname;
	}


	public void setWatchlistname(String watchlistname) {
		this.watchlistname = watchlistname;
	}
	
	
	
	

//
//	public List<Stock> getStockList() {
//		return stockList;
//	}
//
//
//	public void setStockList(List<Stock> stockList) {
//		this.stockList = stockList;
//	}

	
	
	
	
	
	

}
