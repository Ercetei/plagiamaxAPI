package com.infotel.plagiamax.repository;

import org.springframework.stereotype.Repository;

import com.infotel.plagiamax.model.MatchDay;
import com.infotel.plagiamax.repository.base.IBaseRepository;

/**
 * The Interface MatchDayCrudRepository.
 */
@Repository
public interface MatchDayCrudRepository extends IBaseRepository<MatchDay, Long> {

}
