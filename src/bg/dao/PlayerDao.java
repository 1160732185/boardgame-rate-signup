package bg.dao;

import java.util.List;

import bg.pojo.Player;
import bg.pojo.Game;
import bg.pojo.Rate;

public interface PlayerDao {
Player checkPlayerLoginDao(String pid,String password);


int PlayerRegDao(Player p);


int PlayerRateDao(int pno, String gno, int score);


List<Rate> ShowRateDao(int pno);


int DeleteRateDao(int pno, String gno);
}
