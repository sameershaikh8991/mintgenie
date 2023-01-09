package com.mintgenie.repository;

import com.mintgenie.model.Watchlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WatchlistRepo extends JpaRepository<Watchlist, Integer> {
}
