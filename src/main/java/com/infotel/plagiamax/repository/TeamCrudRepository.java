package com.infotel.plagiamax.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.infotel.plagiamax.model.Team;
import com.infotel.plagiamax.repository.base.IBaseRepository;

/**
 * The Interface TeamCrudRepository. Persists the Team class inside of the
 * database
 */
@Repository
public interface TeamCrudRepository extends IBaseRepository<Team, Long> {

	/**
	 * Gets the score for a specific team inside of a match.
	 *
	 * @param team_id  : the team id
	 * @param match_id : the match id
	 * @return the team score for the specific match
	 */
	@Query(value = ("SELECT count(ev.id) FROM Event ev "
			+ "WHERE ev.team.id = ?1 AND ev.match.id = ?2 AND ev.status = 1"))
	Integer getTeamScoreByMatch(Long team_id, Long match_id);

	/**
	 * Gets both teams for a specific BetType.
	 *
	 * @param bet_id : the bet id
	 * @return both teams for the match related to the BetType
	 */
	@Query(value = ("SELECT t FROM BetType bt " + "INNER JOIN MatchBet mb ON mb.id = bt.id "
			+ "INNER JOIN Match m ON m.id = mb.match.id " + "INNER JOIN MatchTeam mt ON mt.match.id = m.id "
			+ "INNER JOIN Team t ON t.id = mt.team.id " + "WHERE bt.id = ?1"))
	List<Team> getTeamsByBettypeId(Long bet_id);

}
