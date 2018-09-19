package com.infotel.plagiamax.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infotel.plagiamax.controller.base.BaseRestController;
import com.infotel.plagiamax.model.MatchDay;
import com.infotel.plagiamax.model.Competition;
import com.infotel.plagiamax.repository.MatchDayCrudRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class CompetitionController.
 */
@RestController
@RequestMapping(CompetitionController.BASE_URL)
public class CompetitionController extends BaseRestController<Competition, Long> {

    /** The Constant BASE_URL. */
    public static final String BASE_URL = "/competition";
    
	@Autowired
	private MatchDayCrudRepository matchDayCrud;
	
	@RequestMapping(path = { "/{index}/matchdays" }, method = RequestMethod.GET)
	public ResponseEntity<Iterable<MatchDay>> getMatchDayByCompetition(@PathVariable("index") Long index) {
		Iterable<MatchDay> item = matchDayCrud.findByCompetitionId(index);
		new ResponseEntity<Competition>(HttpStatus.OK);
		return ResponseEntity.ok(item);
	}
    
}