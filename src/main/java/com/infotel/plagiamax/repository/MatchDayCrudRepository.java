package com.infotel.plagiamax.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.infotel.plagiamax.model.MatchDay;
import com.infotel.plagiamax.repository.base.IBaseRepository;

/**
 * The Interface MatchDayCrudRepository.Persists the MatchDay class inside of the
 * database
 */
@Repository
public interface MatchDayCrudRepository extends IBaseRepository<MatchDay, Long> {

	/**
	 * Find by competition id.
	 *
	 * @param competition_id the competition id
	 * @return the list
	 */
	@Query(value = ("SELECT md FROM MatchDay md " + "INNER JOIN Season s ON md.season.id = s.id "
			+ "INNER JOIN Competition cn ON s.competition.id = cn.id " + "WHERE cn.id = ?1"))
	List<MatchDay> findByCompetitionId(Long competition_id);

	/**
	 * Find active by competition id.
	 *
	 * @param competition_id the competition id
	 * @return the list
	 */
	@Query(value = ("SELECT md FROM MatchDay md " + "INNER JOIN Season s ON md.season.id = s.id "
			+ "INNER JOIN Match m on md.id = m.matchday.id " + "INNER JOIN Competition cn ON s.competition.id = cn.id "
			+ "WHERE cn.id = ?1 " + "AND m.id IN(SELECT m.id FROM Match WHERE m.status = 3) " + "GROUP BY md.id "))
	List<MatchDay> findActiveByCompetitionId(Long competition_id);
}
