package com.mintgenie.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class StockDTO {
    private int stock_id;
    private String stock_name;
    private int stock_price;
    private String listedOn;
    private boolean status = true;
}
