package com.mintgenie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mintgenie.model.Watchlist;

@Repository
public interface EditRepo extends JpaRepository<Watchlist, Integer> {
	
	

}
