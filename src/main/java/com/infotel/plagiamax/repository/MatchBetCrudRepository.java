package com.infotel.plagiamax.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.infotel.plagiamax.model.BetType;
import com.infotel.plagiamax.model.MatchBet;
import com.infotel.plagiamax.repository.base.IBaseRepository;

@Repository
public interface MatchBetCrudRepository extends IBaseRepository<MatchBet, Long> {

	@Query(value = ("SELECT mb FROM MatchBet mb INNER JOIN BetType bt ON mb.id = bt.id "
			+ "INNER JOIN BetLine bl ON bt.id = bl.bettype.id INNER JOIN Bet b ON b.id = bl.bet.id "
			+ "INNER JOIN User u ON b.user.id = u.id WHERE u.id = ?1"))
	List<BetType> findByUserId(Long user_id);
}
