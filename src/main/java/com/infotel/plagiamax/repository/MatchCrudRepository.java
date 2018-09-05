package com.infotel.plagiamax.repository;

import org.springframework.stereotype.Repository;

import com.infotel.plagiamax.model.Match;
import com.infotel.plagiamax.repository.base.IBaseRepository;

@Repository
public interface MatchCrudRepository extends IBaseRepository<Match, Long> {

}