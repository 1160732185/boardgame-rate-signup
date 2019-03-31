package bg.service.impl;

import java.util.List;

import bg.dao.CompetitionDao;
import bg.dao.GameDao;
import bg.dao.PlayerDao;
import bg.dao.impl.CompetitionDaoImpl;
import bg.dao.impl.GameDaoImpl;
import bg.dao.impl.PlayerDaoImpl;
import bg.pojo.Competition;
import bg.pojo.Game;
import bg.pojo.Player;
import bg.pojo.Rate;
import bg.pojo.Table;
import bg.pojo.User;
import bg.service.PlayerService;

public class PlayerServiceImpl implements PlayerService {
//声明Dao层对象
	PlayerDao pd=new PlayerDaoImpl();
	GameDao gd=new GameDaoImpl();
	CompetitionDao cd=new CompetitionDaoImpl();
	@Override
	public Player checkPlayerLoginService(String pid, String password) {
		// TODO Auto-generated method stub
		return pd.checkPlayerLoginDao(pid, password);
	}
	@Override
	public int PlayerRegService(Player p) {
		
		return pd.PlayerRegDao(p);
	}
	@Override
	public List<Game> GameShowService() {
		
		return gd.GameShowDao();
	}
	@Override
	public int PlayerRateService(int pno, String gno, int score) {
		//处理用户评分 TODO Auto-generated method stub
		return pd.PlayerRateDao(pno,gno,score);
	}
	@Override
	public List<Competition> CompetitionShowService() {
		// TODO Auto-generated method stub
		return cd.CompetitionShowDao();
	}
	@Override
	public int CompetitionSignService(int pno, String cno) {
		// TODO Auto-generated method stub
		return cd.CompetitionSignDao(pno,cno);
	}
	@Override
	public List<Table> TableShowService() {
		// TODO Auto-generated method stub
		return cd.TableShowDao();
	}
	@Override
	public int TableSitService(int pno, String tano) {
		// TODO Auto-generated method stub
		return cd.TableSitDao(pno,tano);
	}
	@Override
	public List<Rate> ShowRate(int pno) {
		// TODO Auto-generated method stub
		return pd.ShowRateDao(pno);
	}
	@Override
	public int DeleteRate(int pno, String gno) {
		// TODO Auto-generated method stub
		return pd.DeleteRateDao(pno,gno);
	}

}
