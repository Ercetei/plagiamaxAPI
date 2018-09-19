package com.infotel.plagiamax.controller;

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

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.infotel.plagiamax.controller.base.BaseRestController;
import com.infotel.plagiamax.controller.firebase.Firebase;
import com.infotel.plagiamax.model.Match;
import com.infotel.plagiamax.repository.MatchCrudRepository;
import com.infotel.plagiamax.service.MatchService;
import com.infotel.plagiamax.utils.GenericMerger;
import com.infotel.plagiamax.utils.JsonManager;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

@RestController
@RequestMapping(MatchController.BASE_URL)
public class MatchController extends BaseRestController<Match, Long> {

	public static final String BASE_URL = "/match";

	@Autowired
	private MatchCrudRepository matchCrud;
	Firebase firebase;
	
	@RequestMapping(path = { "/", "" }, method = RequestMethod.GET)
	public ResponseEntity<Iterable<Match>> index() {
		Iterable<Match> matchs = matchCrud.findAll();
				
		new ResponseEntity<Match>(HttpStatus.OK);
		return ResponseEntity.ok(matchs);
	}

	@RequestMapping(path = { "/{index}" }, method = RequestMethod.PATCH)
	public ResponseEntity<Match> updatefields(@PathVariable("index") Long index, @RequestBody Match match) {
		Optional<Match> matchToUpdate = matchCrud.findById(index);
		Match updatedMatch = GenericMerger.<Match>merge(matchToUpdate.get(), match, match.getClass());

		if (updatedMatch.getStatus() == 5) {
			deleteMatchFromFirebase(updatedMatch);
		}
		
		postMatchToFirebase(updatedMatch);

		return ResponseEntity.ok(matchCrud.save(updatedMatch));
	}
	
	@RequestMapping(path = { "/{index}" }, method = RequestMethod.PUT)
	public ResponseEntity<Match> updateItem(@PathVariable("index") Long index, @RequestBody Match match) {
		match.setId((Long) index);
		Match putMatch = matchCrud.save(match);
		new ResponseEntity<Match>(HttpStatus.OK);
		
		if (putMatch.getStatus() == 5) {
			deleteMatchFromFirebase(putMatch);
		}
		
		postMatchToFirebase(putMatch);
		return ResponseEntity.ok(putMatch);
	}

	@RequestMapping(path = { "/", "" }, method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Match> postItem(@RequestBody Match match) {
		new ResponseEntity<Match>(HttpStatus.OK);
		Match savedMatch = matchCrud.save(match);
		postMatchToFirebase(savedMatch);

		return ResponseEntity.ok(savedMatch);
	}

	public void deleteMatchFromFirebase(Match match) {
		final FirebaseDatabase database = FirebaseDatabase.getInstance();
		DatabaseReference ref = database.getReference("matchs/" + match.getId());
		ref.removeValueAsync();
	}

	public void postMatchToFirebase(Match match) {
		final FirebaseDatabase database = FirebaseDatabase.getInstance();
		DatabaseReference ref = database.getReference("matchs/" + match.getId());
		ref.setValueAsync(MatchService.firebaseParser(match));
		ref.push();
	}
	
}