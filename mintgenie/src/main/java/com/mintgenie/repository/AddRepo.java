package com.mintgenie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mintgenie.model.WatchlistData;

@Repository
public interface AddRepo extends JpaRepository<WatchlistData, Integer> {

}
