package com.infotel.plagiamax.repository.security;

import org.springframework.stereotype.Repository;

import com.infotel.plagiamax.model.security.SecurityRole;
import com.infotel.plagiamax.repository.base.IBaseRepository;

/**
 * The Interface SecurityRoleCrudRepository.
 */
@Repository
public interface SecurityRoleCrudRepository extends  IBaseRepository<SecurityRole, Long> {

}
