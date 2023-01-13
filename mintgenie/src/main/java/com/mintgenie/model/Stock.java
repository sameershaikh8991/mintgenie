package com.mintgenie.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@NoArgsConstructor
@Data
@AllArgsConstructor
public class Stock {

    private int stock_id;
    private String stock_name;
    private int stock_price;
    private String listedOn;
    private boolean status = true;


}