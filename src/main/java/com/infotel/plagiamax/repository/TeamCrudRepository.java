package com.infotel.plagiamax.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.infotel.plagiamax.model.Team;
import com.infotel.plagiamax.repository.base.IBaseRepository;

/**
 * The Interface TeamCrudRepository.
 */
@Repository
public interface TeamCrudRepository extends IBaseRepository<Team, Long>{
	
	@Query(value = ("SELECT COUNT(ev) FROM Event ev WHERE ev.team.id = ?1 AND ev.match.id = ?2 AND status = 1"))
	Integer getTeamScoreByMatch(Long team_id, Long match_id);
	
/*	@Query(value = ("SELECT t FROM Bet b "
			+ "INNER JOIN BetLine bl ON bl.bet.id = b.id "
			+ "INNER JOIN BetType bt ON bl.bettype.id = bt.id "
			+ "INNER JOIN MatchBet mb ON mb.id = bt.id "
			+ "INNER JOIN Match m ON m.id = mb.match.id "
			+ "INNER JOIN MatchTeam mt ON mt.match.id = m.id "
			+ "INNER JOIN Team t ON t.id = mt.team.id "
			+ "WHERE b.id = ?1"))
	List<Team> getTeamsByBetId(Long bet_id);*/
	
	@Query(value = ("SELECT t FROM BetType bt "
			+ "INNER JOIN MatchBet mb ON mb.id = bt.id "
			+ "INNER JOIN Match m ON m.id = mb.match.id "
			+ "INNER JOIN MatchTeam mt ON mt.match.id = m.id "
			+ "INNER JOIN Team t ON t.id = mt.team.id "
			+ "WHERE bt.id = ?1"))
	List<Team> getTeamsByBettypeId(Long bet_id);
}
