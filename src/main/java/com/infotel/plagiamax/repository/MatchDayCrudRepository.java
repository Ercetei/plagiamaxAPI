package com.infotel.plagiamax.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.infotel.plagiamax.model.MatchDay;
import com.infotel.plagiamax.repository.base.IBaseRepository;

/**
 * The Interface MatchDayCrudRepository.
 */
@Repository
public interface MatchDayCrudRepository extends IBaseRepository<MatchDay, Long> {
	
	@Query(value = ("SELECT md FROM MatchDay md "
			+ "INNER JOIN Season s ON md.season.id = s.id "
			+ "INNER JOIN Competition cn ON s.competition.id = cn.id "
			+ "WHERE cn.id = ?1"))
	List<MatchDay> findByCompetitionId(Long competition_id);
	
	@Query(value = ("SELECT md FROM MatchDay md "
			+ "INNER JOIN Season s ON md.season.id = s.id "
			+ "INNER JOIN Match m on md.id = m.matchday.id "
			+ "INNER JOIN Competition cn ON s.competition.id = cn.id "
			+ "WHERE cn.id = ?1 "
			+ "AND m.id IN(SELECT m.id FROM Match WHERE m.status = 3) "
			+ "GROUP BY md.id "))
	List<MatchDay> findActiveByCompetitionId(Long competition_id);
}
