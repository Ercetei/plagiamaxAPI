package com.infotel.plagiamax.repository;

import org.springframework.stereotype.Repository;

import com.infotel.plagiamax.model.BetType;
import com.infotel.plagiamax.repository.base.IBaseRepository;

/**
 * The Interface BetTypeCrudRepository. Persists the BetType class inside of the
 * database
 */
@Repository
public interface BetTypeCrudRepository extends IBaseRepository<BetType, Long> {

}
