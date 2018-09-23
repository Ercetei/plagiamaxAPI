package com.infotel.plagiamax.controller.base;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infotel.plagiamax.model.base.DBItem;
import com.infotel.plagiamax.repository.base.IBaseRepository;
import com.infotel.plagiamax.utils.GenericMerger;

/**
 * The Class BaseRestController.
 *
 * @param <T> the object type
 * @param <ID> the id type
 */
@RestController
public abstract class BaseRestController<T, ID extends Serializable> {

	/** The crud repository. */
	@Autowired
	protected IBaseRepository<T, ID> crudRepository;

	/**
	 * Gets all the elements for the object type.
	 *
	 * @return the elements
	 */
	@RequestMapping(path = { "/", "" }, method = RequestMethod.GET)
	public ResponseEntity<Iterable<T>> index() {
		Iterable<T> items = crudRepository.findAll();
		new ResponseEntity<T>(HttpStatus.OK);
		return ResponseEntity.ok(items);
	}

	/**
	 * Gets the element with the specific id for the object type.
	 *
	 * @param index : the id
	 * @return the element
	 */
	@RequestMapping(path = { "/{index}" }, method = RequestMethod.GET)
	public ResponseEntity<Optional<T>> getByIndex(@PathVariable("index") ID index) {
		Optional<T> item = crudRepository.findById(index);
		new ResponseEntity<T>(HttpStatus.OK);
		return ResponseEntity.ok(item);
	}

	/**
	 * Persists an item of the object type inside the database.
	 *
	 * @param item : the item to persist
	 * @return the persisted item
	 */
	@RequestMapping(path = { "/", "" }, method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<T> postItem(@RequestBody T item) {
		new ResponseEntity<T>(HttpStatus.OK);
		return ResponseEntity.ok(crudRepository.save(item));
	}

	/**
	 * Replaces an item of the object type at a specific id.
	 *
	 * @param index : the id
	 * @param item  : the item to update
	 * @return the updated item
	 */
	@RequestMapping(path = { "/{index}" }, method = RequestMethod.PUT)
	public ResponseEntity<T> updateItem(@PathVariable("index") ID index, @RequestBody T item) {
		((DBItem) item).setId((Long) index);
		new ResponseEntity<T>(HttpStatus.OK);
		return ResponseEntity.ok(crudRepository.save(item));
	}

	/**
	 * Updates only the given fields for an item of the object type at a specific
	 * id.
	 *
	 * @param index : the id
	 * @param item  : the item to update
	 * @return the updated item
	 */
	@RequestMapping(path = { "/{index}" }, method = RequestMethod.PATCH)
	public ResponseEntity<T> updateFields(@PathVariable("index") ID index, @RequestBody T item) {
		Optional<T> dbItem = crudRepository.findById(index);
		T itemToReturn = GenericMerger.merge(dbItem.get(), item, item.getClass());
		return ResponseEntity.ok(crudRepository.save(itemToReturn));
	}

	/**
	 * Deletes an item at a specific id.
	 *
	 * @param index : the id
	 */
	@RequestMapping(path = { "/{index}" }, method = RequestMethod.DELETE)
	public void deleteItem(@PathVariable("index") ID index) {
		crudRepository.delete(crudRepository.findById(index).get());
		new ResponseEntity<T>(HttpStatus.NO_CONTENT);
	}
}
