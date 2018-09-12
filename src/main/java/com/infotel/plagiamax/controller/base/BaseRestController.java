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

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.internal.FirebaseRequestInitializer;
import com.infotel.plagiamax.model.base.DBItem;
import com.infotel.plagiamax.repository.base.IBaseRepository;

@RestController
public abstract class BaseRestController<T, ID extends Serializable> {

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
		DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
		mDatabase.setValueAsync(item);
		return ResponseEntity.ok(crudRepository.save(item));
	}
	
	@RequestMapping(path = { "/{index}", "" }, method = RequestMethod.PUT)
	public ResponseEntity<T> updateItem(@PathVariable("index") ID index, @RequestBody T item) {
		((DBItem) item).setId((Long)index);
		new ResponseEntity<T>(HttpStatus.OK);
		return ResponseEntity.ok(crudRepository.save(item));
	}
	
	@RequestMapping(path = { "/{index}", "" }, method = RequestMethod.DELETE)
	public void deleteItem(@PathVariable("index") ID index) {
		crudRepository.delete(crudRepository.findById(index).get());
		new ResponseEntity<T>(HttpStatus.NO_CONTENT);
	}
}
