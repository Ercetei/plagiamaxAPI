package com.infotel.plagiamax.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.infotel.plagiamax.model.Event;
import com.infotel.plagiamax.repository.base.IBaseRepository;

/**
 * The Interface EventCrudRepository. Persists the Event class inside of the
 * database
 */
@Repository
public interface EventCrudRepository extends IBaseRepository<Event, Long> {

	/**
	 * Finds all the events for a specific team
	 *
	 * @param team_id : the specific team's id
	 * @return the events list
	 */
	List<Event> findByTeamId(Long team_id);
}
