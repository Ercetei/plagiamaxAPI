package com.infotel.plagiamax.repository;

import org.springframework.stereotype.Repository;

import com.infotel.plagiamax.model.MatchPlayer;
import com.infotel.plagiamax.repository.base.IBaseRepository;

@Repository
public interface MatchPlayerCrudRepository extends IBaseRepository<MatchPlayer, Long> {

}