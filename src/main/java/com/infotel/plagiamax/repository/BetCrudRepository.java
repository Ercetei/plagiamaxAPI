package com.infotel.plagiamax.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.infotel.plagiamax.model.Bet;
import com.infotel.plagiamax.repository.base.IBaseRepository;

// TODO: Auto-generated Javadoc
/**
 * The Interface BetCrudRepository.
 */
@Repository
public interface BetCrudRepository extends IBaseRepository<Bet, Long> {
	
	/**
	 * Find by user id.
	 *
	 * @param user_id the user id
	 * @return the list
	 */
	List<Bet> findByUserId(Long user_id);
}
