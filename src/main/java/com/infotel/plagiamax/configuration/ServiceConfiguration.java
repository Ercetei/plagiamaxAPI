package com.infotel.plagiamax.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.infotel.plagiamax.repository.EventCrudRepository;

/**
 * The Class ServiceConfiguration.
 */
@Configuration
public class ServiceConfiguration {

	private static final EventCrudRepository EventCrudRepository = null;

	@Bean
	public EventCrudRepository eventCrudRepository() {
		
	    return EventCrudRepository;
	}

}
