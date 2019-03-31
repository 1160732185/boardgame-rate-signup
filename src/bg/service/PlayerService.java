package bg.service;

import java.util.List;

import bg.pojo.Competition;
import bg.pojo.Player;
import bg.pojo.Game;
import bg.pojo.Rate;
import bg.pojo.Table;

public interface PlayerService {
Player checkPlayerLoginService(String pid,String password);
List<Game> GameShowService();
int PlayerRegService(Player p);
int PlayerRateService(int pno, String gno, int score);
List<Competition> CompetitionShowService();
int CompetitionSignService(int pno, String cno);
List<Table> TableShowService();
int TableSitService(int pno, String tano);
List<Rate>ShowRate(int pno);
int DeleteRate(int pno, String gno);
}
