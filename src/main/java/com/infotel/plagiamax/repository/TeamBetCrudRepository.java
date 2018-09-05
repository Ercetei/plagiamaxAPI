package com.infotel.plagiamax.repository;

import org.springframework.stereotype.Repository;

import com.infotel.plagiamax.model.TeamBet;
import com.infotel.plagiamax.repository.base.IBaseRepository;

@Repository
public interface TeamBetCrudRepository extends IBaseRepository<TeamBet, Long> {

}
