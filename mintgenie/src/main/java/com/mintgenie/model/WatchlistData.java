package com.mintgenie.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;


@Entity
public class WatchlistData {
	
	@EmbeddedId
	private ListId id;
   // private int watchlistId;
    private int userId;
    
    
    
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name="Stock_id")
//       private List<Stock> stockList;
    
    @OneToMany(cascade = CascadeType.ALL)  
    @JoinTable(
            name = "Watchlistinfo"         
    )
    private List<Stock> stockList;

    public WatchlistData() {
    }
     

	public WatchlistData(ListId id, int userId, List<Stock> stockList) {
		super();
		this.id = id;
		this.userId = userId;
		this.stockList = stockList;
	}


	

	public ListId getId() {
		return id;
	}


	public void setId(ListId id) {
		this.id = id;
	}


	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public List<Stock> getStockList() {
		return stockList;
	}

	public void setStockList(List<Stock> stockList) {
		this.stockList = stockList;
	}


	@Override
	public String toString() {
		return "WatchlistData [id=" + id + ", userId=" + userId + ", stockList=" + stockList + "]";
	}

	
    

}
