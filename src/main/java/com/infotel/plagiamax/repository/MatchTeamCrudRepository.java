package com.infotel.plagiamax.repository;

import org.springframework.stereotype.Repository;

import com.infotel.plagiamax.model.MatchTeam;
import com.infotel.plagiamax.repository.base.IBaseRepository;

@Repository
public interface MatchTeamCrudRepository extends IBaseRepository<MatchTeam, Long> {

}