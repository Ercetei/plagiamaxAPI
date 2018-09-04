ypackage com.infotel.plagiamax.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "period")
public class Period {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;
	@Column(name = "player", nullable = false)
	private Player player;
	@Column(name = "team", nullable = false)
	private Team team;
	@Column(name = "startdate", nullable = false)
	private Date startdate;
	private Date enddate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public Period(Long id, Player player, Team team, Date startdate, Date enddate) {
		super();
		this.id = id;
		this.player = player;
		this.team = team;
		this.startdate = startdate;
		this.enddate = enddate;
	}

	public Period() {
		super();
	}
}
