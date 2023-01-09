package com.mintgenie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mintgenie.model.Mutualfund;

@Repository
public interface MutualfundRepo extends JpaRepository<Mutualfund, Integer> {

	
}
