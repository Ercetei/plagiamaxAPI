package com.infotel.plagiamax.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.infotel.plagiamax.model.Bet;
import com.infotel.plagiamax.repository.base.IBaseRepository;

/**
 * The Interface BetCrudRepository. Persists the Bet class inside of the
 * database
 */
@Repository
public interface BetCrudRepository extends IBaseRepository<Bet, Long> {

	/**
	 * Find all the bets for a specific user
	 *
	 * @param user_id : the specific user's id
	 * @return the bet list
	 */
	List<Bet> findByUserId(Long user_id);
}
