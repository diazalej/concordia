package ca.soccer.db;
import java.util.List;
import ca.soccer.domain.Player;
/**
 * Repository interface with operations for {@link Player} persistence.
 * @author habuma
 */
public interface PlayerRepository {
    public List<Player> findPlayers(int max, int count);
    List<Player> findPlayers(int max, int count,int startingAt);
    Player findOne(String playerId);
    public Player save(Player player);
}