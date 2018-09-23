package com.infotel.plagiamax.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.infotel.plagiamax.model.BetType;
import com.infotel.plagiamax.model.MatchBet;
import com.infotel.plagiamax.repository.base.IBaseRepository;

/**
 * The Interface MatchBetCrudRepository.
 */
@Repository
public interface MatchBetCrudRepository extends IBaseRepository<MatchBet, Long> {

	/**
	 * Find by user id.
	 *
	 * @param user_id the user id
	 * @return the list
	 */
	@Query(value = ("SELECT mb FROM MatchBet mb INNER JOIN BetType bt ON mb.id = bt.id "
			+ "INNER JOIN BetLine bl ON bt.id = bl.bettype.id INNER JOIN Bet b ON b.id = bl.bet.id "
			+ "INNER JOIN User u ON b.user.id = u.id WHERE u.id = ?1"))
	List<BetType> findByUserId(Long user_id);
	
	/**
	 * Find by matchday id.
	 *
	 * @param matchday_id the matchday id
	 * @return the list
	 */
	@Query(value = ("SELECT mb FROM MatchBet mb "
			+ "INNER JOIN Match m ON m.id = mb.match.id "
			+ "INNER JOIN MatchDay md ON md.id = m.matchday.id "
			+ "WHERE md.id = ?1 "
			+ "AND mb.type = 1 "
			+ "AND (m.status = 3 OR m.status = 4) "
			))
	List<BetType> findByMatchDayId(Long matchday_id);

	/**
	 * Find by match.
	 *
	 * @param match_id the match id
	 * @return the list
	 */
	List<BetType> findByMatch(Long match_id);
	
	
	Optional<MatchBet> findById(Long id);
}
