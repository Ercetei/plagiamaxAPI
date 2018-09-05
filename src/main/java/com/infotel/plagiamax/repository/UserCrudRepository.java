package com.infotel.plagiamax.repository;

import org.springframework.stereotype.Repository;

import com.infotel.plagiamax.model.User;
import com.infotel.plagiamax.repository.base.IBaseRepository;

@Repository
public interface UserCrudRepository extends IBaseRepository<User, Long>{
	

}
