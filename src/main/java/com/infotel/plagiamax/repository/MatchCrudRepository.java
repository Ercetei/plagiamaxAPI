package com.infotel.plagiamax.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import com.infotel.plagiamax.model.Match;
import com.infotel.plagiamax.repository.base.IBaseRepository;

/**
 * The Interface MatchCrudRepository. Persists the Match class inside of the
 * database
 */
@Repository
public interface MatchCrudRepository extends IBaseRepository<Match, Long> {

	/**
	 * Finds all the matches of status "In progress" or "To come" for a specific
	 * matchday inside of a defined competition
	 *
	 * @param matchday_id    : the matchday id
	 * @param competition_id : the competition id
	 * @return the list
	 */
	@Query(value = ("SELECT m FROM Match m " + "INNER JOIN MatchDay md ON md.id = m.matchday.id "
			+ "INNER JOIN Season s ON md.season.id = s.id " + "INNER JOIN Competition cn ON s.competition.id = cn.id "
			+ "WHERE md.id = ?1 AND cn.id = ?2 " + "AND (m.status = 3 OR m.status = 4) "))
	List<Match> findByMatchDayId(Long matchday_id, Long competition_id);

	/**
	 * Finds all the matches for a specific matchday
	 *
	 * @param matchday_id : the matchday id
	 * @return the match list
	 */
	List<Match> findByMatchdayId(Long matchday_id);

	/**
	 * Finds a match for a specific BetType
	 *
	 * @param Bettype_id : the bettype id
	 * @return the Match
	 */
	@Query(value = ("SELECT m from Match m " + "INNER JOIN MatchBet mb ON m.id = mb.match.id " + "WHERE mb.id = ?1"))
	Optional<Match> findByBettypeId(Long Bettype_id);
}
