package com.infotel.plagiamax.repository;

import org.springframework.stereotype.Repository;

import com.infotel.plagiamax.model.Competition;
import com.infotel.plagiamax.repository.base.IBaseRepository;

/**
 * The Interface CompetitionCrudRepository.
 */
@Repository
public interface CompetitionCrudRepository extends IBaseRepository<Competition, Long> {

}
