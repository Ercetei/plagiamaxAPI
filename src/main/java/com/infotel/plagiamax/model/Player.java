package com.infotel.plagiamax.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.infotel.plagiamax.contract.EventContract;
import com.infotel.plagiamax.contract.MatchPlayerContract;
import com.infotel.plagiamax.contract.PeriodContract;
import com.infotel.plagiamax.contract.PlaceContract;
import com.infotel.plagiamax.contract.PlayerBetContract;
import com.infotel.plagiamax.contract.StatContract;
import com.infotel.plagiamax.model.base.DBItem;

// TODO: Auto-generated Javadoc
/**
 * The Class Player.
 */
@Entity
@Table(name = "player")
public class Player extends DBItem {

	/** The firstname. */
	private String firstname;

	/** The lastname. */
	@Column(nullable = false)
	private String lastname;
	
	/** The birthdate. */
	private Date birthdate;

	/** The status. 
	 * 
	 * */
	@Column(nullable = false)
	private Integer status;

	/** The place. */
	@ManyToOne
	@JsonIgnoreProperties({ PlaceContract.ASSOCIATION_COMPETITION, PlaceContract.ASSOCIATION_MATCH,
			PlaceContract.ASSOCIATION_PLAYER, PlaceContract.ASSOCIATION_TEAM })
	private Place place;

	/** The periods. */
	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = PeriodContract.ASSOCIATION_PLAYER)
	@JsonIgnoreProperties({ PeriodContract.ASSOCIATION_PLAYER, PeriodContract.ASSOCIATION_TEAM })
	private List<Period> periods;

	/** The stats. */
	@OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true, mappedBy = StatContract.ASSOCIATION_PLAYER)
	@JsonIgnoreProperties({ StatContract.ASSOCIATION_CHILDREN, StatContract.ASSOCIATION_PARENT,
			StatContract.ASSOCIATION_PLAYER, PlaceContract.ASSOCIATION_TEAM })
	private List<Stat> stats;

	/** The matchplayers. */
	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = MatchPlayerContract.ASSOCIATION_PLAYER)
	@JsonIgnoreProperties({ MatchPlayerContract.ASSOCIATION_MATCH, MatchPlayerContract.ASSOCIATION_PLAYER })
	private List<MatchPlayer> matchplayers;

	/** The events. */
	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = EventContract.ASSOCIATION_PLAYER)
	@JsonIgnoreProperties({ EventContract.ASSOCIATION_MATCH, EventContract.ASSOCIATION_PLAYER,
			EventContract.ASSOCIATION_TEAM })
	private List<Event> events;

	/** The playerbets. */
	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = PlayerBetContract.ASSOCIATION_PLAYER)
	@JsonIgnoreProperties({ PlayerBetContract.ASSOCIATION_PLAYER })
	private List<PlayerBet> playerbets;

	/**
	 * Gets the playerbets.
	 *
	 * @return the playerbets
	 */
	public List<PlayerBet> getPlayerbets() {
		return playerbets;
	}

	/**
	 * Sets the playerbets.
	 *
	 * @param playerbets the new playerbets
	 */
	public void setPlayerbets(List<PlayerBet> playerbets) {
		this.playerbets = playerbets;
	}

	/**
	 * Gets the firstname.
	 *
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * Sets the firstname.
	 *
	 * @param firstname the new firstname
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * Gets the lastname.
	 *
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * Sets the lastname.
	 *
	 * @param lastname the new lastname
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * Gets the birthdate.
	 *
	 * @return the birthdate
	 */
	public Date getBirthdate() {
		return birthdate;
	}

	/**
	 * Sets the birthdate.
	 *
	 * @param birthdate the new birthdate
	 */
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * Gets the place.
	 *
	 * @return the place
	 */
	public Place getPlace() {
		return place;
	}

	/**
	 * Sets the place.
	 *
	 * @param place the new place
	 */
	public void setPlace(Place place) {
		this.place = place;
	}

	/**
	 * Gets the stats.
	 *
	 * @return the stats
	 */
	public List<Stat> getStats() {
		return stats;
	}

	/**
	 * Sets the stats.
	 *
	 * @param stats the new stats
	 */
	public void setStats(List<Stat> stats) {
		this.stats = stats;
	}

	/**
	 * Gets the periods.
	 *
	 * @return the periods
	 */
	public List<Period> getPeriods() {
		return periods;
	}

	/**
	 * Sets the periods.
	 *
	 * @param periods the new periods
	 */
	public void setPeriods(List<Period> periods) {
		this.periods = periods;
	}

	/**
	 * Gets the matchplayers.
	 *
	 * @return the matchplayers
	 */
	public List<MatchPlayer> getMatchplayers() {
		return matchplayers;
	}

	/**
	 * Sets the matchplayers.
	 *
	 * @param matchplayers the new matchplayers
	 */
	public void setMatchplayers(List<MatchPlayer> matchplayers) {
		this.matchplayers = matchplayers;
	}

	/**
	 * Gets the events.
	 *
	 * @return the events
	 */
	public List<Event> getEvents() {
		return events;
	}

	/**
	 * Sets the events.
	 *
	 * @param events the new events
	 */
	public void setEvents(List<Event> events) {
		this.events = events;
	}

	/**
	 * Instantiates a new player.
	 */
	public Player() {
		super();
	}
}
