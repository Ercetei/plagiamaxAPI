package com.infotel.plagiamax.repository;

import org.springframework.stereotype.Repository;

import com.infotel.plagiamax.model.Place;
import com.infotel.plagiamax.repository.base.IBaseRepository;

/**
 * The Interface PlaceCrudRepository.
 */
@Repository
public interface PlaceCrudRepository extends IBaseRepository<Place, Long> {

}
