package com.mintgenie.repository;

import com.mintgenie.model.WatchlistData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface WatchlistDataRepo extends JpaRepository<WatchlistData, Integer> {
    //stockid, watchlistid, type, user_id
    @Transactional
    @Modifying
    @Query(value = "delete from watchlist_data where stockid =:sid and watchlistid =:wid and user_id= :uid", nativeQuery = true)
    void deleteStock(@Param("sid") int sid, @Param("wid") int wid, @Param("uid") int uid);


}
