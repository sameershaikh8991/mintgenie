package com.mintgenie.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class Watchlistid implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int watchlist_id;
	private String type;

	public Watchlistid() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Watchlistid(int watchlist_id, String type) {
		super();
		this.watchlist_id = watchlist_id;
		this.type = type;
	}

	public int getTicker_id() {
		return watchlist_id;
	}

	public void setTicker_id(int watchlist_id) {
		this.watchlist_id = watchlist_id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "watchlist [watchlist_id=" + watchlist_id + ", type=" + type + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(watchlist_id, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Watchlistid other = (Watchlistid) obj;
		return watchlist_id == other.watchlist_id && Objects.equals(type, other.type);
	}

}
