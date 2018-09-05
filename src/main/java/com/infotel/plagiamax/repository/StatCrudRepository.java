package com.infotel.plagiamax.repository;

import org.springframework.stereotype.Repository;

import com.infotel.plagiamax.model.Stat;
import com.infotel.plagiamax.repository.base.IBaseRepository;

@Repository
public interface StatCrudRepository extends IBaseRepository<Stat, Long> {

}
