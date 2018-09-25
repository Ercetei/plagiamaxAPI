package com.infotel.plagiamax.repository;

import org.springframework.stereotype.Repository;

import com.infotel.plagiamax.model.Season;
import com.infotel.plagiamax.repository.base.IBaseRepository;

/**
 * The Interface SeasonCrudRepository. Persists the Season class inside of the
 * database
 */
@Repository
public interface SeasonCrudRepository extends IBaseRepository<Season, Long> {

}
