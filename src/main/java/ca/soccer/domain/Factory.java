
package ca.soccer.domain;
/**
 * Created by alejandra on 27/07/15.
 */

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;

@Component
public class Factory {

    private final int maxNumberOfGoals = 100;
    private final int maxNumberOfBookins = 40;

    private String firstName;
    private String lastName;
    private Integer age;
    private String birthCountry;
    private BigDecimal annualSalary;
    private Position position;
    private Statistics statistics;

    int foundationTeamYear = 1950;
    private int fistTrainerAge = (new GregorianCalendar().get(Calendar.YEAR)) - foundationTeamYear;
    private Trainer firstRandomTrainer = null;
    Team firstRandomTeam = null;
    List<Team> teams = new ArrayList<Team>();
    private List<Team> previousTeamList;
    private Team previousTeamTemp;
    private int randomIndexTemp;



    private Random random = new Random();
    private String[] playersBirthCounty = {"Espagne", "Brazil", "Colombia", "Argentina", "Mexico", "Alemania", "Paraguay", "Venezuela", "Francia", "Gana", "Camerun"};
    private String[] teamNameList = {"Espagne", "Brazil", "Colombia", "Argentina", "Mexico", "Alemania", "Paraguay", "Venezuela", "Francia", "Gana", "Camerun"};

    private String[] firstNameList = {"Cristiano", "leonel", "Falcao", "James", "Iker", "Inestia", "Neymar", "Xavi", "Gareth", "Sergio", "Xabi", "Angel", "David", "Sergio", "Thiago", "Daniel", "Carlos", "Toni", "Samuel", "Manuel", "Milo", "Lala"};
    private String[] lastNameList = {"Ronaldo", "messi", "Garcia", "Rodriguez", "Casillas", "Lujan", "Dasilva", "Hernandez", "Bale", "Ramos", "Alonso", "Dimaria", "Villa", "Aguero", "Silva", "Alves", "Tevez", "Kroos", "Etoo", "Terry", "Milto", "Kompany"};


    public Factory() {
    }

    public static Factory getInstance() {
        return new Factory();
    }

    private Trainer getFirstTrainer() {
        if (firstRandomTrainer == null) {
            firstRandomTrainer = new Trainer(generateFisrtName(), generateLastName(), fistTrainerAge, null, generateAnnualSalary());
        }
        return firstRandomTrainer;
    }


    private Team getFirstRandomTeam() {
        if (firstRandomTeam == null) {
            firstRandomTeam = new Team(generateTeamName(), null, generatePlayersArray(22), generateTeamYear());
            firstRandomTeam.setFoundationYear(foundationTeamYear);
            firstRandomTeam.setTrainer(getFirstTrainer());
            List<Team> firstTrainerPreviousTeamList = new ArrayList<Team>();
            firstTrainerPreviousTeamList.add(firstRandomTeam);
            getFirstTrainer().setPreviousTeamList(firstTrainerPreviousTeamList);
            teams.add(firstRandomTeam);
        }
        return firstRandomTeam;
    }

    public Player[] generatePlayersArray(int length) {
        if (length < 1) return null;
        Player[] playerArray = new Player[length];
        for (int i = 0; i < playerArray.length; i++)
            playerArray[i] = generateRandomPlayer();
        return playerArray;
    }

    public Team generateRandomTeam() {
        if (teams.size() >= teamNameList.length)
            throw new RuntimeException("Max Number of Teams Already Created");
        Team team = null;
        if (teams.size() < 1) {
            return getFirstRandomTeam();
        } else {
            team = new Team(generateTeamName(), generateRandomTrainer(), generatePlayersArray(22), generateTeamYear());
            teams.add(team);
        }
        return team;
    }



    public Trainer generateRandomTrainer() {
        Trainer trainer;
        firstName = generateFisrtName();
        lastName = generateLastName();
        age = generateTrainerAge();
        annualSalary = generateAnnualSalary();
        previousTeamList = new ArrayList<Team>();
        if (teams.size() > 1) {
            int previousTeamNumber = random.nextInt(teams.size() + 1) - 1;
            for (int i = 0; i <= previousTeamNumber + 1; i++) {
                previousTeamTemp = chooseRandomExistingTeam();
                if (!previousTeamList.contains(previousTeamTemp)) {
                    previousTeamList.add(previousTeamTemp);
                }
            }
        } else {
            previousTeamList.add(getFirstRandomTeam());
        }
        trainer = new Trainer(firstName, lastName, age, previousTeamList, annualSalary);
        return trainer;
    }



    private Team chooseRandomExistingTeam() {
        Team teamTemp = null;
        randomIndexTemp = random.nextInt(teams.size());
        teamTemp = teams.get(randomIndexTemp);
        return teamTemp;
    }

    public Player generateRandomPlayer() {
        Player player;
        firstName = generateFisrtName();
        lastName = generateLastName();
        age = generatePlayerAge();
        birthCountry = generateBirthCountry();
        annualSalary = generateAnnualSalary();
        Position position = generatePosition();
        Statistics statistics = generateStatistics();
        player = new Player(firstName, lastName, age, birthCountry, annualSalary, position, statistics);
        return player;
    }

    public String generateTeamName() {
        if (teams.size() >= teamNameList.length)
            throw new RuntimeException("No more random teams can be created");
        List<String> existingTeamsNameListTemp = new LinkedList<String>();
        for (Team currentExistingTeam : teams) {
            existingTeamsNameListTemp.add(currentExistingTeam.getName());
        }
        String teamNameTemp;
        while (existingTeamsNameListTemp.contains(teamNameTemp = teamNameList[random.nextInt(teamNameList.length)])) ;
        return teamNameTemp;
    }

    private String generateBirthCountry() {
        return playersBirthCounty[random.nextInt(playersBirthCounty.length)];
    }
    
    private BigDecimal generateAnnualSalary() {
        return new BigDecimal(80000+ Math.random() * (200000 - 80000));
    }

    private Position generatePosition() {
        return Position.values()[random.nextInt(Position.values().length)];
    }


    private Statistics generateStatistics() {
        return new Statistics(1 + random.nextInt(maxNumberOfGoals), 1 + random.nextInt(maxNumberOfBookins));
    }

    private String generateFisrtName() {
        return firstNameList[random.nextInt(firstNameList.length)];
    }

    public int generateTeamYear() {
        return foundationTeamYear + random.nextInt((new GregorianCalendar().get(Calendar.YEAR)) - foundationTeamYear);
    }

    private String generateLastName() {
        return lastNameList[random.nextInt(lastNameList.length)];
    }

    private int generatePlayerAge() {
        return 20 + random.nextInt(3);
    }

    private int generateTrainerAge() {
        return 40 + random.nextInt(40);
    }

    public int getMaxNumberOfTeams() {
        return teamNameList.length;
    }
}

