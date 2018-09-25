package com.infotel.plagiamax.repository;

import org.springframework.stereotype.Repository;

import com.infotel.plagiamax.model.MatchPlayer;
import com.infotel.plagiamax.repository.base.IBaseRepository;

/**
 * The Interface MatchPlayerCrudRepository. Persists the MatchPlayer class inside of the
 * database
 */
@Repository
public interface MatchPlayerCrudRepository extends IBaseRepository<MatchPlayer, Long> {

}