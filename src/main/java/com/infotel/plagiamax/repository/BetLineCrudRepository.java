package com.infotel.plagiamax.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.infotel.plagiamax.model.BetLine;
import com.infotel.plagiamax.repository.base.IBaseRepository;

/**
 * The Interface BetLineCrudRepository. Persists the BetLine class inside of the
 * database
 */
@Repository
public interface BetLineCrudRepository extends IBaseRepository<BetLine, Long> {

	/**
	 * Gets all the bet lines for a specific match.
	 *
	 * @param match_id : the specific match's id
	 * @return all the bet lines
	 */
	@Query(value = ("SELECT bl FROM BetLine bl " + "INNER JOIN MatchBet mb ON mb.id = bl.bettype.id "
			+ "WHERE bl.status = 1 " + "AND mb.match.id = ?1"))
	List<BetLine> getBetLinesByMatch(Long match_id);
}
