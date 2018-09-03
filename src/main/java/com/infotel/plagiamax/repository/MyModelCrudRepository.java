package com.infotel.plagiamax.repository;

import org.springframework.stereotype.Repository;

import com.infotel.plagiamax.model.MyModel;
import com.infotel.plagiamax.repository.base.*;

@Repository
public interface MyModelCrudRepository extends IBaseRepository<MyModel, Long>{

}
