package com.mintgenie.dto;

public class StockDTO {
    private int stock_id;
    private String stockName;
    private int stock_price;
    private String listedOn;
    private boolean status = true;

    public StockDTO() {
    }

    public StockDTO(int stock_id, String stockName, int stock_price, String listedOn, boolean status) {
        this.stock_id = stock_id;
        this.stockName = stockName;
        this.stock_price = stock_price;
        this.listedOn = listedOn;
        this.status = status;
    }

    public void setStock_id(int stock_id) {
        this.stock_id = stock_id;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public void setStock_price(int stock_price) {
        this.stock_price = stock_price;
    }

    public void setListedOn(String listedOn) {
        this.listedOn = listedOn;
    }

    public void setStatus(boolean status) {
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

    @Override
    public String toString() {
        return "StockDTO{" +
                "stock_id=" + stock_id +
                ", stockName='" + stockName + '\'' +
                ", stock_price=" + stock_price +
                ", listedOn='" + listedOn + '\'' +
                ", status=" + status +
                '}';
    }
}