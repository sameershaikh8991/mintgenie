package com.mintgenie.repository;

import com.mintgenie.model.ListId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mintgenie.model.WatchlistData;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface AddRepo extends JpaRepository<WatchlistData, ListId> {
//    @Query(" FROM WatchlistData"
//            + " wd WHERE wd.watchlistid=:start_date AND wd.type=:userName")
//    Optional<WatchlistData> find(@Param("start_date") int watchlistid, );

    Optional<WatchlistData> findByIdWatchlistid(int id);
    Optional<WatchlistData> findByIdStockid(int id);
    Optional<WatchlistData> findByIdWatchlistidAndIdStockid(int watchlistid,int stockid);
//    void deletByIdStockid(int stckid);



    @Transactional
    void deleteByIdWatchlistid(int id);


}
