package com.infotel.plagiamax.controller.base;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infotel.plagiamax.repository.base.IBaseRepository;

@RestController
public abstract class BaseRestController<T,ID extends Serializable> {

	@Autowired
	private IBaseRepository<T, ID> crudRepository;

    @RequestMapping(path={"/", ""}, method=RequestMethod.GET)
    public ResponseEntity<Iterable<T>> index() {
        Iterable<T> items = crudRepository.findAll();
        new ResponseEntity<T>(HttpStatus.OK);
		return ResponseEntity.ok(items);
    }

    @RequestMapping("/{index}")
    public ResponseEntity<Optional<T>> getByIndex(@PathVariable("index") ID index) {
        Optional<T> item = crudRepository.findById(index);
    	new ResponseEntity<T>(HttpStatus.OK);
		return ResponseEntity.ok(item);
    }

    @RequestMapping(path={"/", ""}, method=RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<T> postItem(@RequestBody T item) {
    	crudRepository.save(item);
    	new ResponseEntity<T>(HttpStatus.OK);
		return ResponseEntity.ok(item);
    }

    @RequestMapping(path={"/", ""}, method=RequestMethod.PUT)
    @Secured("ROLE_USER")
    public ResponseEntity<T> updateItem(@RequestBody T item) {
    	crudRepository.save(item);
    	new ResponseEntity<T>(HttpStatus.OK);
		return ResponseEntity.ok(item);
    }
    
    @RequestMapping(path={"/", ""}, method=RequestMethod.DELETE)
    @Secured("ROLE_USER")
    public ResponseEntity<T> deleteItem(@RequestBody T item) {
    	crudRepository.delete(item);
        new ResponseEntity<T>(HttpStatus.OK);
		return ResponseEntity.ok(item);
    }
}
