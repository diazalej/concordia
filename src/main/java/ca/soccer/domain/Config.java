
package ca.soccer.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class Config {
    @Bean
    public Logger getLogger() {
        return new Logger();
    }

    Factory factory = new Factory();

    @Bean(name = "factory")
    Factory getFactory() {
        return factory;
    }

    @Bean(name = "player")
    Player getPlayer() {

        return factory.generateRandomPlayer();
    }

    @Bean(name = "team")
    Team getTeam() {

        return factory.generateRandomTeam();
    }

    @Bean(name = "team2")
    Team getTeam2() {
        return factory.generateRandomTeam();
    }

    @Bean(name = "team3")
    Team getTeam3() {

        return factory.generateRandomTeam();
    }

    @Bean(name = "trainer")
    Trainer getTrainer() {

        return factory.generateRandomTrainer();
    }

    @Bean(name = "helper")
    Helper getHelper() {
        return new Helper();
    }

    @Bean(name = "teamValidator")
    TeamValidator TeamValidator() {
        return new TeamValidator();
    }
}

