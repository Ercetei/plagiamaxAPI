package com.infotel.plagiamax.repository.base;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * The Interface IBaseRepository.
 * Extends the interface CrudRepository to get all the basic crud methods
 *
 * @param <T> the generic object type
 * @param <ID> the generic ID type
 */
@NoRepositoryBean
public interface IBaseRepository<T, ID extends Serializable> extends CrudRepository<T, ID> {

}
