package com.infotel.plagiamax.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.infotel.plagiamax.model.Event;
import com.infotel.plagiamax.repository.base.IBaseRepository;

/**
 * The Interface EventCrudRepository.
 */
@Repository
public interface EventCrudRepository extends IBaseRepository<Event, Long> {

	
	List<Event> findByTeamId(Long team_id);
}
