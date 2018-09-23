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

/**
 * The Class MatchController.
 */
@RestController
@RequestMapping(MatchController.BASE_URL)
public class MatchController extends BaseRestController<Match, Long> {

	/** The Constant BASE_URL. */
	public static final String BASE_URL = "/match";

	/** The firebase. */
	private Firebase firebase;

	/** The match service. */
	@Autowired
	private MatchService matchService;

	/**
	 * Updates only the given fields for a Match at a specific id. Calls the
	 * manageWinnings function to manage the bet results when a match is over.
	 *
	 * @param index : the match id
	 * @param match : the match to update
	 * @return the updated item
	 */
	@RequestMapping(path = { "/{index}" }, method = RequestMethod.PATCH)
	public ResponseEntity<Match> updateFields(@PathVariable("index") Long index, @RequestBody Match match) {
		Optional<Match> matchToUpdate = ((MatchCrudRepository) crudRepository).findById(index);
		Match updatedMatch = GenericMerger.<Match>merge(matchToUpdate.get(), match, match.getClass());

		if (updatedMatch.getStatus() == 5) {
			matchService.manageWinnings(updatedMatch);
			deleteMatchFromFirebase(updatedMatch);
		}

		postMatchToFirebase(updatedMatch);

		return ResponseEntity.ok(((MatchCrudRepository) crudRepository).save(updatedMatch));
	}

	/**
	 * Replaces a match. Deletes the match from Firebase when it is over.
	 *
	 * @param index : the match id
	 * @param match : the match to update
	 * @return the updated item
	 */
	@RequestMapping(path = { "/{index}" }, method = RequestMethod.PUT)
	public ResponseEntity<Match> updateItem(@PathVariable("index") Long index, @RequestBody Match match) {
		match.setId((Long) index);
		Match putMatch = ((MatchCrudRepository) crudRepository).save(match);
		new ResponseEntity<Match>(HttpStatus.OK);

		if (putMatch.getStatus() == 5) {
			deleteMatchFromFirebase(putMatch);
		}

		postMatchToFirebase(putMatch);
		return ResponseEntity.ok(putMatch);
	}

	/**
	 * Persists a match inside the database.
	 *
	 * @param match : the match to persist
	 * @return the persisted match
	 */
	@RequestMapping(path = { "/", "" }, method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Match> postItem(@RequestBody Match match) {
		new ResponseEntity<Match>(HttpStatus.OK);
		Match savedMatch = ((MatchCrudRepository) crudRepository).save(match);
		postMatchToFirebase(savedMatch);

		return ResponseEntity.ok(savedMatch);
	}

	/**
	 * Gets the match by bettype id.
	 *
	 * @param index : the bettype id
	 * @return the match for a specific bettype
	 */
	@RequestMapping(path = { "/bettype/{index}" }, method = RequestMethod.GET)
	public ResponseEntity<Match> getMatchByBettypeId(@PathVariable("index") Long index) {
		Optional<Match> match = ((MatchCrudRepository) crudRepository).findByBettypeId(index);
		new ResponseEntity<Match>(HttpStatus.OK);
		return ResponseEntity.ok(match.get());
	}

	/**
	 * Delete the row from firebase if it is not useful anymore.
	 *
	 * @param match : the match to delete
	 */
	public void deleteMatchFromFirebase(Match match) {
		final FirebaseDatabase database = FirebaseDatabase.getInstance();
		DatabaseReference ref = database.getReference("matchs/" + match.getId());
		ref.removeValueAsync();
	}

	/**
	 * Create or update a row for a match in the firebase database.
	 *
	 * @param match : the match to persist
	 */
	public void postMatchToFirebase(Match match) {
		final FirebaseDatabase database = FirebaseDatabase.getInstance();
		DatabaseReference ref = database.getReference("matchs/" + match.getId());
		ref.setValueAsync(MatchService.firebaseParser(match));
		ref.push();
	}
}
