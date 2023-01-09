package com.mintgenie.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mutualfunds")
public class Mutualfund {

//	Mutualfunds_id, Mutualfunds_name, mutualfunds_price, mutualfunds_ratings, oney_return, 
	// threey_return, fivey_return, status, mutual_funds_id, mutual_funds_name,
	// mutual_funds_price

	@Id
	private int Mutualfunds_id;
	private String Mutualfunds_name;
	private int mutualfunds_price;
	private int mutualfunds_ratings;
	private int oney_return;
	private int threey_return;
	private int fivey_return;
	private int status;

	public Mutualfund() {
		super();
	}

	public Mutualfund(int Mutualfunds_id, String Mutualfunds_name, int mutualfunds_price, int mutualfunds_ratings,
			int oney_return, int threey_return, int fivey_return, int status) {
		super();
		this.Mutualfunds_id = Mutualfunds_id;
		this.Mutualfunds_name = Mutualfunds_name;
		this.mutualfunds_price = mutualfunds_price;
		this.mutualfunds_ratings = mutualfunds_ratings;
		this.oney_return = oney_return;
		this.threey_return = threey_return;
		this.fivey_return = fivey_return;
		this.status = status;
	}

	public int getMutualfunds_id() {
		return Mutualfunds_id;
	}

	public String getMutualfunds_name() {
		return Mutualfunds_name;
	}

	public int getmutualfunds_price() {
		return mutualfunds_price;
	}

	public int getMutualfunds_ratings() {
		return mutualfunds_ratings;
	}

	public int getOney_return() {
		return oney_return;
	}

	public int getThreey_return() {
		return threey_return;
	}

	public int getFivey_return() {
		return fivey_return;
	}

	public int getStatus() {
		return status;
	}

}
