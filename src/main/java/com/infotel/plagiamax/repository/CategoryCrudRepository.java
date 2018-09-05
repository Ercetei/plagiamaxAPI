package com.infotel.plagiamax.repository;

import org.springframework.stereotype.Repository;

import com.infotel.plagiamax.model.Category;
import com.infotel.plagiamax.repository.base.IBaseRepository;

@Repository
public interface CategoryCrudRepository extends IBaseRepository<Category, Long> {

}
