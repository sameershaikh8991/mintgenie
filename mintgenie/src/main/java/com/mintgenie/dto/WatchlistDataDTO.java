package com.mintgenie.dto;

import com.mintgenie.model.ListId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class WatchlistDataDTO {

//	@EmbeddedId
//	private ListId id;

    @EmbeddedId
    private ListId id;
    private int userId;
    private String type;


}