package com.infotel.plagiamax.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.infotel.plagiamax.model.Team;
import com.infotel.plagiamax.repository.base.IBaseRepository;

/**
 * The Interface TeamCrudRepository.
 */
@Repository
public interface TeamCrudRepository extends IBaseRepository<Team, Long>{
	
	@Query(value = ("SELECT count(ev.id) FROM Event ev "
			+ "WHERE ev.team.id = ?1 AND ev.match.id = ?2 AND ev.status = 1"))
	Integer getTeamScoreByMatch(Long team_id, Long match_id);
	
}
