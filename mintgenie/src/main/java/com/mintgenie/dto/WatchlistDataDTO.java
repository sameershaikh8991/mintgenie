package com.mintgenie.dto;

import com.mintgenie.model.Stock;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class WatchlistDataDTO {
    private int watchlistId;
    private int userId;
    private List<Stock> stockList;
    private String type;

}
