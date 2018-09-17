package com.infotel.plagiamax.controller.base;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infotel.plagiamax.model.User;
import com.infotel.plagiamax.model.base.DBItem;
import com.infotel.plagiamax.repository.base.IBaseRepository;
import com.infotel.plagiamax.utils.GenericMerger;

@RestController
public abstract class BaseRestController<T, ID extends Serializable> {

	// TODO: A supprimer en prod
	Logger logger = LoggerFactory.getLogger(BaseRestController.class);

	@Autowired
	private IBaseRepository<T, ID> crudRepository;

	@RequestMapping(path = { "/", "" }, method = RequestMethod.GET)
	public ResponseEntity<Iterable<T>> index() {
		Iterable<T> items = crudRepository.findAll();
		new ResponseEntity<T>(HttpStatus.OK);
		return ResponseEntity.ok(items);
	}

	@RequestMapping(path = { "/{index}" }, method = RequestMethod.GET)
	public ResponseEntity<Optional<T>> getByIndex(@PathVariable("index") ID index) {
		Optional<T> item = crudRepository.findById(index);
		new ResponseEntity<T>(HttpStatus.OK);
		return ResponseEntity.ok(item);
	}

	@RequestMapping(path = { "/", "" }, method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<T> postItem(@RequestBody T item) {
		new ResponseEntity<T>(HttpStatus.OK);
		return ResponseEntity.ok(crudRepository.save(item));
	}

	@RequestMapping(path = { "/{index}" }, method = RequestMethod.PUT)
	public ResponseEntity<T> updateItem(@PathVariable("index") ID index, @RequestBody T item) {
		((DBItem) item).setId((Long) index);
		new ResponseEntity<T>(HttpStatus.OK);
		return ResponseEntity.ok(crudRepository.save(item));
	}

	@RequestMapping(path = { "/{index}" }, method = RequestMethod.PATCH)
	public ResponseEntity<T> updatefields(@PathVariable("index") ID index, @RequestBody T item) {
		Optional<T> dbItem = crudRepository.findById(index);
		T itemToReturn = GenericMerger.merge(dbItem.get(), item, item.getClass());
		new ResponseEntity<User>(HttpStatus.OK);
		return ResponseEntity.ok(crudRepository.save(itemToReturn));
	}

	@RequestMapping(path = { "/{index}" }, method = RequestMethod.DELETE)
	public void deleteItem(@PathVariable("index") ID index) {
		crudRepository.delete(crudRepository.findById(index).get());
		new ResponseEntity<T>(HttpStatus.NO_CONTENT);
	}
}
