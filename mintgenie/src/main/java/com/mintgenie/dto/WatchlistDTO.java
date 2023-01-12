package com.mintgenie.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class WatchlistDTO {
    private int watchlistId;
    private int userId;
    private String watchlistName;
    private int numberOfStocks;
    private String type;

}
