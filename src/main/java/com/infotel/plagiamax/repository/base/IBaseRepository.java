package com.infotel.plagiamax.repository.base;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * The Interface IBaseRepository.
 *
 * @param <T> the generic type
 * @param <ID> the generic type
 */
@NoRepositoryBean
public interface IBaseRepository<T, ID extends Serializable> extends CrudRepository<T, ID>{

}
