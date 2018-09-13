package com.infotel.plagiamax.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.infotel.plagiamax.model.Bet;
import com.infotel.plagiamax.repository.base.IBaseRepository;

@Repository
public interface BetCrudRepository extends IBaseRepository<Bet, Long> {

	List<Bet> findByUserId(Long user_id);
}
