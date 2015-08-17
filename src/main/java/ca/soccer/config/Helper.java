package ca.soccer.config;

import ca.soccer.config.Factory;
import ca.soccer.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Helper {

    @Autowired
    Factory factory;

    List<Position> positionList = new ArrayList<Position>(Position.values().length);

    public Helper() {
        for (Position position : Position.values())
            positionList.add(position);
    }


    private boolean validateName(String name) {
        if (name == null || name.trim().equals("") == true || name.matches(".*\\d.*")){
            return false;
        }else{
            return true;
        }
    }


    public boolean validateTeam(Team team) {
        if (team == null)
            return false;

        if (this.validateName(team.getName()) == false) {
            return false;
        }

        if (team.getTrainer() == null)
            return false;

        if (team.getPlayers() == null || team.getPlayers().length != 22)
            return false;

        for (Player player : team.getPlayers()) {
            if (player == null) return false;
        }

        if (team.getFoundationYear() == null || team.getFoundationYear() < 1950)
            return false;

        return true;
    }

    public boolean validateTrainer(Trainer trainer) {
        if (trainer == null)
            return false;

        if (this.validateName(trainer.getFirstName()) == false) {
            return false;
        }

        if (this.validateName(trainer.getLastName()) == false) {
            return false;
        }

        if (trainer.getAge() == null || trainer.getAge() < 40) return false;

        if (trainer.getAnnualSalary() == null) return false;



        return true;
    }

    public boolean validatePlayer(Player player) {

        if (this.validateName(player.getFirstName()) == false) {
            return false;
        }

        if (this.validateName(player.getLastName()) == false) {
            return false;
        }

        if (this.validateName(player.getCountryOfBirth()) == false) {
            return false;
        }

        if (player.getAge() == null || (player.getAge() < 20 && player.getAge() > 30))
            return false;

        if (player.getAnnualSalary() == null)
            return false;

        if (!validatePosition(player.getPosition()))
            return false;

        if (!validateStatistics(player.getStatistics()))
            return false;

        return true;
    }

    public boolean validateStatistics(Statistics statistics) {
        if (statistics == null) {
            return false;
        }

        if (statistics.getNumberOfBookings() == null || statistics.getNumberOfGoals() == null || statistics.getNumberOfBookings() < 0 || statistics.getNumberOfGoals() < 0) {
            return false;
        }
        return true;
    }

    public boolean validatePosition(Position position) {
        if (position == null)
            return false;

        if (!positionList.contains(position))
            return false;

        return true;
    }

}
