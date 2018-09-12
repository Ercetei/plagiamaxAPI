package com.infotel.plagiamax.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.infotel.plagiamax.model.Team;
import com.infotel.plagiamax.repository.base.IBaseRepository;

@Repository
public interface TeamCrudRepository extends IBaseRepository<Team, Long>{
	
	Optional<Team> findByMatchTeamId(Long matchteams);
}
