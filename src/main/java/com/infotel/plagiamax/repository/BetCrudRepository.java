package com.infotel.plagiamax.repository;

import org.springframework.stereotype.Repository;

import com.infotel.plagiamax.model.Bet;
import com.infotel.plagiamax.repository.base.IBaseRepository;

@Repository
public interface BetCrudRepository extends IBaseRepository<Bet, Long> {

	Iterable<Bet> findByUser(Long user_id);
}
