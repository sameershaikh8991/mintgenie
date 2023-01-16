package com.mintgenie.repository;

import com.mintgenie.dto.StockDTO;
import com.mintgenie.model.Watchlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WatchlistRepo extends JpaRepository<Watchlist, Integer> {

    @Query(value = "select stockid from watchlist_data t where t.watchlistid =:id ", nativeQuery = true )
    List<Integer> findAllStocksFromWatchlist(@Param("id") int watchlistid);
}
