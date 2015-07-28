
package ca.soccer.domain;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Currency;
import java.util.LinkedList;
import java.util.List;

@Component
@Aspect
public class Logger {

    @Pointcut("execution(* ca.soccer.domain.Helper.validateTeam(Team))" + "&& args(team)")
    public void teamValidationPointcut(Team team) {
    }

    @Before("teamValidationPointcut(team)")
    public void printTeam(Team team) {
        System.out.println();
        System.out.println("Team: \"" + team.getName() + "\" Founded in " + team.getFoundationYear());
        System.out.println("-------------" + "Tainer: " + team.getTrainer().getFirstName() + " " + team.getTrainer().getLastName() + " (Age: " + team.getTrainer().getAge() + ", Salary: " + team.getTrainer().getAnnualSalary() + ")");
        System.out.println("-------------" + "-------------" + "Former Team" + (team.getTrainer().getPreviousTeamList().size() > 1 ? "s:" : ":"));
        for (Team trainerTeam : team.getTrainer().getPreviousTeamList())
            System.out.println("-------------" + "-------------" + trainerTeam.getName());
        int counter = 1;
        for (Player player : team.getPlayers())
            System.out.println("-------------" + "Player # " + counter++ + " " + player.getFirstName() + " " + player.getLastName() + " [" + "Position: " + player.getPosition().name() + "; " + "Born in: "
                    + player.getCountryOfBirth() + "; " + "Age: " + player.getAge() + "; " + "Goals: " + player.getStatistics().getNumberOfGoals() + "; " + "Bookings: " + player.getStatistics().getNumberOfBookings() + "; " + "Annual Salary: " + player.getAnnualSalary() + "]");
    }
}