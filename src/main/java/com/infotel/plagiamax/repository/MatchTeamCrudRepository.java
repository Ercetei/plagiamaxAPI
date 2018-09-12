package com.infotel.plagiamax.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.infotel.plagiamax.model.MatchTeam;
import com.infotel.plagiamax.repository.base.IBaseRepository;

// TODO: Auto-generated Javadoc
/**
 * The Interface MatchTeamCrudRepository.
 */
@Repository
public interface MatchTeamCrudRepository extends IBaseRepository<MatchTeam, Long> {

	/**
	 * Find by match id.
	 *
	 * @param match the match
	 * @return the optional
	 */
	Optional<MatchTeam> findByMatchId(Long match);
	
	/**
	 * Find by team id.
	 *
	 * @param team the team
	 * @return the optional
	 */
	Optional<MatchTeam> findByTeamId(Long team);
}