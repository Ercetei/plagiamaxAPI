package com.infotel.plagiamax.repository;

import org.springframework.stereotype.Repository;

import com.infotel.plagiamax.model.Player;
import com.infotel.plagiamax.repository.base.IBaseRepository;

/**
 * The Interface PlayerCrudRepository. Persists the Player class inside of the
 * database
 */
@Repository
public interface PlayerCrudRepository extends IBaseRepository<Player, Long> {

}
