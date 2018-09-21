package com.infotel.plagiamax.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.infotel.plagiamax.model.BetLine;
import com.infotel.plagiamax.repository.base.IBaseRepository;

/**
 * The Interface BetLineCrudRepository.
 */
@Repository
public interface BetLineCrudRepository extends IBaseRepository<BetLine, Long> {
	
	@Query(value = ("SELECT bl FROM BetLine bl "
			+ "INNER JOIN MatchBet mb ON mb.id = bl.bettype.id "
			+ "WHERE bl.status = 1 "
			+ "AND mb.match.id = ?1"))
	List<BetLine> getCurrentBetLineByMatch(Long match_id);
	
}
