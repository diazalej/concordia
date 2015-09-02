package ca.soccer.db;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ca.soccer.config.FactoryLocal;
import ca.soccer.domain.Player;

import java.util.ArrayList;
import java.util.List;


@Repository
@Transactional
public class HibernatePlayerRepository implements PlayerRepository {

    List<Player> playerList=new ArrayList<Player>();
    Player playerTemp;

    @Autowired SessionFactory sessionFactory;

    public HibernatePlayerRepository() {
    }

    public List<Player> findPlayers(int max, int count) {
        return findPlayers(max,count,0);
    }
    @Autowired
    FactoryLocal factory;
    public List<Player> findPlayers(int max, int count, int startingAt) {
        int currentSize=playerList.size();
        if (playerList.size()<count){
            for (int i=0; i<count-currentSize;i++){
                playerTemp=factory.generateRandomPlayer();
                save(playerTemp);
            }
        }
        syncListWithDB();
        if (startingAt>0 && (startingAt+count)<playerList.size()){
            return playerList.subList(startingAt,startingAt+count);
        }
        return playerList;
    }
    public Player findOne(String playerId) {
        syncListWithDB();
        for(Player playerCurrent: playerList)
            if (playerCurrent.getFirstName().equals(playerId.replace("%20"," ")))
                return playerCurrent;
        return null;
    }
    public Player save(Player player) {
        sessionFactory.getCurrentSession().persist(player);
        if (findOne(player.getFirstName())!=null) {
            playerList.remove(findOne(player.getFirstName()));
        }
        playerList.add(player);
        //serialiseList();
        return player;
    }
    private void syncListWithDB(){
        String hql = " FROM Player";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        List results = query.list();
        for (Object obj: results){
            if (!playerList.contains(obj))
                playerList.add((Player)obj);
        }
    }

}