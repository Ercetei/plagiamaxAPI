package com.infotel.plagiamax.repository;

import org.springframework.stereotype.Repository;

import com.infotel.plagiamax.model.PlayerBet;
import com.infotel.plagiamax.repository.base.IBaseRepository;

/**
 * The Interface PlayerBetCrudRepository.
 */
@Repository
public interface PlayerBetCrudRepository extends IBaseRepository<PlayerBet, Long> {

}
