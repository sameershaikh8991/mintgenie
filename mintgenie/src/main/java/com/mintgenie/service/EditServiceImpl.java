package com.mintgenie.service;

import com.mintgenie.dto.WatchlistDTO;
import com.mintgenie.model.Count;
import com.mintgenie.model.Watchlist;
import com.mintgenie.payload.ModelMapperPayload;
import com.mintgenie.repository.EditRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditServiceImpl implements EditService {

    @Autowired
    EditRepo editRepo;

    @Autowired
    Count count;

    @Autowired
    private ModelMapperPayload modelMapperPayload;

    @Override
    public WatchlistDTO renameWatchList(WatchlistDTO watchlistDTO, int id) {
        Watchlist watchlist = this.editRepo.findById(id).get();
        System.out.println("In impl...");
        System.out.println(watchlistDTO.getWatchlistName());

        watchlist.setWatchlistName(watchlistDTO.getWatchlistName());

        Watchlist updatedWatchlistName = this.editRepo.save(watchlist);
        WatchlistDTO watchlistDTO1 = this.modelMapperPayload.watchlistToDto(updatedWatchlistName);
        return watchlistDTO1;
//		watchlistOG.setType(watchlistOG.getType());
//		watchlistOG.setNumberOfStocks(watchlistOG.getNumberOfStocks());
//		watchlistOG.setType(watchlistOG.getType());
//		watchlistOG.setUserId(watchlistOG.getUserId());


    }

    @Override
    public Watchlist getById(int id) {
        // TODO Auto-generated method stub
        Watchlist watchlist = editRepo.findById(id).get();
        return watchlist;

    }

    @Override
    public void deleteById(int id) {
        Watchlist watchlist = this.editRepo.findById(id).get();
        this.editRepo.delete(watchlist);
    }

    @Override
    public WatchlistDTO updatestockNumber(int id, int number) {
        Watchlist watchlist = this.editRepo.findById(id).get();

        watchlist.setNumberOfStocks(number);

        Watchlist updatestockNo = this.editRepo.save(watchlist);
        WatchlistDTO watchlistDTO = this.modelMapperPayload.watchlistToDto(updatestockNo);

        return watchlistDTO;

    }


}
