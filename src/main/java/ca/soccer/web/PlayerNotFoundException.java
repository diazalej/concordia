package ca.soccer.web;

/**
 * Created by alejandra on 30/08/15.
 */
public class PlayerNotFoundException extends RuntimeException{
private String playerId;
        public PlayerNotFoundException(String playerId) {
            this.playerId = playerId;
        }
        public String getPlayerId() {
            return playerId;
        }
}