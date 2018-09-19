package com.infotel.plagiamax.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.infotel.plagiamax.model.BetType;
import com.infotel.plagiamax.repository.base.IBaseRepository;

/**
 * The Interface BetTypeCrudRepository.
 */
@Repository
public interface BetTypeCrudRepository extends IBaseRepository<BetType, Long> {

}
