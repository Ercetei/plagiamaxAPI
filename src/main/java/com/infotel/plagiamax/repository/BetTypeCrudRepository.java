package com.infotel.plagiamax.repository;

import org.springframework.stereotype.Repository;

import com.infotel.plagiamax.model.BetType;
import com.infotel.plagiamax.repository.base.IBaseRepository;

@Repository
public interface BetTypeCrudRepository extends IBaseRepository<BetType, Long>{

}

