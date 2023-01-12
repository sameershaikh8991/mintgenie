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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;


@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
public class WatchlistData {

//	@EmbeddedId
//	private ListId id;

    @EmbeddedId
    private ListId id;
    private int userId;
    private String type;


}
