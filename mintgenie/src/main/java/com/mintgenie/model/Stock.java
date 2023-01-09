package com.mintgenie.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stock")
public class Stock {
// stock_id, stock_name, stock_price, listedOn, status

	@Id
	private int stock_id;
	private String stockName;
	private int stock_price;
	private String listed_on;
	private int status;

	public Stock() {
		super();
	}

	public Stock(int stock_id, String stockName, int stock_price, String listed_on, int status) {
		super();
		this.stock_id = stock_id;
		this.stockName = stockName;
		this.stock_price = stock_price;
		this.listed_on = listed_on;
		this.status = status;
	}

	public int getStock_id() {
		return stock_id;
	}

	public String getStock_name() {
		return stockName;
	}

	public int getStock_price() {
		return stock_price;
	}

	public String getListed_on() {
		return listed_on;
	}

	public int getStatus() {
		return status;
	}

}
