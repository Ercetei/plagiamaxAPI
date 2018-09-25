package com.infotel.plagiamax.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.infotel.plagiamax.model.BetType;
import com.infotel.plagiamax.model.MatchBet;
import com.infotel.plagiamax.repository.base.IBaseRepository;

// TODO: Auto-generated Javadoc
/**
 * The Interface MatchBetCrudRepository. Persists the MatchBet class inside of
 * the database
 */
@Repository
public interface MatchBetCrudRepository extends IBaseRepository<MatchBet, Long> {

	/**
	 * Finds all the matchBets for a specific user.
	 *
	 * @param user_id : the user id
	 * @return the MatchBet list
	 */
	@Query(value = ("SELECT mb FROM MatchBet mb INNER JOIN BetType bt ON mb.id = bt.id "
			+ "INNER JOIN BetLine bl ON bt.id = bl.bettype.id INNER JOIN Bet b ON b.id = bl.bet.id "
			+ "INNER JOIN User u ON b.user.id = u.id WHERE u.id = ?1"))
	List<BetType> findByUserId(Long user_id);

	/**
	 * Finds all the MatchBets of type 1 for a specific MatchDay.
	 *
	 * @param matchday_id : the matchday id
	 * @return MatchBet list
	 */
	@Query(value = ("SELECT mb FROM MatchBet mb " + "INNER JOIN Match m ON m.id = mb.match.id "
			+ "INNER JOIN MatchDay md ON md.id = m.matchday.id " + "WHERE md.id = ?1 " + "AND mb.type = 1 "
			+ "AND (m.status = 3 OR m.status = 4) "))
	List<BetType> findByMatchDayId(Long matchday_id);

	/**
	 * Finds all the MatchBet for a specific match.
	 *
	 * @param match_id : the match id
	 * @return the MatchBet list;
	 */
	List<BetType> findByMatch(Long match_id);
}
