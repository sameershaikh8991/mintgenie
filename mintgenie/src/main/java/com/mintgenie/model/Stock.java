package com.mintgenie.model;

import org.hibernate.annotations.NaturalId;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
public class Stock {
    @Id
    private int stock_id;
    private String stockName;
    private int stock_price;
    private String listedOn;
    private boolean status = true;

    public Stock() {
    }

    public Stock(int stock_id, String stockName, int stock_price, String listedOn, boolean status) {
        this.stock_id = stock_id;
        this.stockName = stockName;
        this.stock_price = stock_price;
        this.listedOn = listedOn;
        this.status = status;
    }

    public int getStock_id() {
        return stock_id;
    }

    public String getStockName() {
        return stockName;
    }

    public int getStock_price() {
        return stock_price;
    }

    public String getListedOn() {
        return listedOn;
    }

    public boolean isStatus() {
        return status;
    }
}