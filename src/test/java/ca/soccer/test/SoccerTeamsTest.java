package ca.soccer.test;

import ca.soccer.domain.*;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
/**
 * Created by alejandra on 27/07/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config.class)
public class SoccerTeamsTest{
    @Autowired
    Player player;

    @Autowired
    Trainer trainer;

    @Autowired
    Team team;

    @Autowired
    Team team2;

    @Autowired
    Team team3;

    @Autowired
    Helper helper;

    @Autowired
    TeamValidator teamValidator;
    @Autowired
    Factory factory;
    
    public SoccerTeamsTest() {
    }

    @Test
    public void playersAreValid() {
        Assert.assertTrue(helper.validatePlayer(player));
        Assert.assertTrue(helper.validatePlayer(factory.generateRandomPlayer()));
    }
    @Test
    public void trainersAreValid() {
        Assert.assertTrue(helper.validateTrainer(trainer));
        Assert.assertTrue(helper.validateTrainer(factory.generateRandomTrainer()));
    }
    @Test
    public void teamsAreValid() {
        Assert.assertTrue(helper.validateTeam(team));
        Assert.assertTrue(helper.validateTeam(team2));
        Assert.assertTrue(helper.validateTeam(team3));
        Assert.assertTrue(helper.validateTeam(factory.generateRandomTeam()));
        Assert.assertTrue(teamValidator.validateTeams());
    }
}

