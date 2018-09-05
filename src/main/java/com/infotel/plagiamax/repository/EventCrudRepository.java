package com.infotel.plagiamax.repository;

import org.springframework.stereotype.Repository;

import com.infotel.plagiamax.model.Event;
import com.infotel.plagiamax.repository.base.IBaseRepository;

@Repository
public interface EventCrudRepository extends IBaseRepository<Event, Long> {

}
