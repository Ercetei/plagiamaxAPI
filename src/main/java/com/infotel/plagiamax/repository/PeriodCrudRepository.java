package com.infotel.plagiamax.repository;

import org.springframework.stereotype.Repository;

import com.infotel.plagiamax.model.Period;
import com.infotel.plagiamax.repository.base.IBaseRepository;

/**
 * The Interface PeriodCrudRepository. Persists the Period class inside of the
 * database
 */
@Repository
public interface PeriodCrudRepository extends IBaseRepository<Period, Long> {

}
