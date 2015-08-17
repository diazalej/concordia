package ca.soccer.domain;
import org.springframework.stereotype.Component;
@Component
public class Team{

	private String name; 
	private Trainer trainer; 
	private Player[] players = new Player[22]; 
	private Integer foundationYear;

	public Team() {}

	public Team(String name, Trainer trainer, Player[] players, Integer foundationYear){
		this.name = name;
		this.trainer = trainer;
		this.players = players;
		this.foundationYear = foundationYear;
	}

	public String getName(){
		return name;
	}

	public void setName(String name) {

		this.name = name;
	}
	public Trainer getTrainer(){
		return trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

	public Player[] getPlayers(){

		return players;
	}

	public void setPlayers(Player[] players) {
	    this.players = players;
	}

	public Integer getFoundationYear(){
		return foundationYear;
	}

	public void setFoundationYear(Integer foundationYear) {
	    this.foundationYear = foundationYear;
	}

	@Override
	public boolean equals(Object obj) {
	    boolean returnValue = false;
	    try {
		   returnValue = this.name.equals(((Team) obj).name);
	    } catch (RuntimeException e){
		   return false;
	    }
	    return returnValue;
	}

}
