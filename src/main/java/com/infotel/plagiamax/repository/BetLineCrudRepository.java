package com.infotel.plagiamax.repository;

import org.springframework.stereotype.Repository;

import com.infotel.plagiamax.model.BetLine;
import com.infotel.plagiamax.repository.base.IBaseRepository;

@Repository
public interface BetLineCrudRepository extends IBaseRepository<BetLine, Long> {

}
