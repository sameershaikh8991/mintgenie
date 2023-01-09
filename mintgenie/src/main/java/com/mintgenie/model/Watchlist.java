package com.mintgenie.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Watchlist {
	
	

	@Id
	private int watchlistid;
    private int userid;
    private String watchlistname;
    private int numberofstocks;
    private String type;

    public Watchlist() {
    }

    public Watchlist(int watchlistid, int userid, String watchlistname, int numberofstocks, String type) {
        this.watchlistid = watchlistid;
        this.userid = userid;
        this.watchlistname = watchlistname;
        this.numberofstocks = numberofstocks;
        this.type = type;
    }

    public int getWatchlistId() {
        return watchlistid;
    }

    public void setWatchlistId(int watchlistid) {
        this.watchlistid = watchlistid;
    }

    public int getUserId() {
        return userid;
    }

    public void setUserId(int userid) {
        this.userid = userid;
    }

    public String getWatchlistName() {
        return watchlistname;
    }

    public void setWatchlistName(String watchlistname) {
        this.watchlistname = watchlistname;
    }

    public int getNumberOfStocks() {
        return numberofstocks;
    }

    public void setNumberOfStocks(int numberofstocks) {
        this.numberofstocks = numberofstocks;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    @Override
	public String toString() {
		return "Watchlist [watchlistid=" + watchlistid + ", userid=" + userid + ", watchlistname=" + watchlistname
				+ ", numberofstocks=" + numberofstocks + ", type=" + type + "]";
	}

}
