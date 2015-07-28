package ca.soccer.domain;

/**
 * Created by alejandra on 27/07/15.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TeamValidator {
    @Autowired
    Factory factory;

    @Autowired
    Helper helper;

    public boolean validateTeams(){
        for (int i=0; i< factory.getMaxNumberOfTeams()-(factory.teams.size()); i++)
            factory.generateRandomTeam();


        for (Team team: factory.teams){
            if (!helper.validateTeam(team))
                return false;
        }

        return true;
    }
}
