package com.infotel.plagiamax.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import com.infotel.plagiamax.model.Match;
import com.infotel.plagiamax.repository.base.IBaseRepository;

/**
 * The Interface MatchCrudRepository.
 */
@Repository
public interface MatchCrudRepository extends IBaseRepository<Match, Long> {
	
	@Query(value = ("SELECT m FROM Match m "
			+ "INNER JOIN MatchDay md ON md.id = m.matchday.id "
			+ "INNER JOIN Season s ON md.season.id = s.id "
			+ "INNER JOIN Competition cn ON s.competition.id = cn.id "
			+ "WHERE md.id = ?1 AND cn.id = ?2 "
			+ "AND (m.status = 3 OR m.status = 4) "
			))
	List<Match> findByMatchDayId(Long matchday_id, Long competition_id);
	
	List<Match> findByMatchdayId(Long matchday_id);
	
	@Query(value = ("SELECT m from Match m "
			+ "INNER JOIN MatchBet mb ON m.id = mb.match.id "
			+ "WHERE mb.id = ?1"))
	Optional<Match> findByBettypeId(Long Bettype_id);
}

