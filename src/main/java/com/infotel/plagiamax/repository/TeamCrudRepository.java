package com.infotel.plagiamax.repository;

import org.springframework.stereotype.Repository;

import com.infotel.plagiamax.model.Team;
import com.infotel.plagiamax.repository.base.IBaseRepository;

/**
 * The Interface TeamCrudRepository.
 */
@Repository
public interface TeamCrudRepository extends IBaseRepository<Team, Long>{

}
