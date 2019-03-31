package bg.service.impl;

import java.util.List;

import bg.dao.CompetitionDao;
import bg.dao.GameDao;
import bg.dao.JudgerDao;
import bg.dao.PlayerDao;
import bg.dao.impl.CompetitionDaoImpl;
import bg.dao.impl.GameDaoImpl;
import bg.dao.impl.JudgerDaoImpl;
import bg.dao.impl.PlayerDaoImpl;
import bg.pojo.Judger;
import bg.pojo.Scoring;
import bg.pojo.Table;
import bg.service.JudgerService;

public class JudgerServiceImpl implements JudgerService {
	JudgerDao jd=new JudgerDaoImpl();
	PlayerDao pd=new PlayerDaoImpl();
	GameDao gd=new GameDaoImpl();
	CompetitionDao cd=new CompetitionDaoImpl();
	@Override
	public Judger checkJudgerLoginService(String jid, String jpassword) {
		// TODO Auto-generated method stub
		return jd.checkJudgeLoginDao(jid,jpassword);
	}
	@Override
	public List<Table> TableSuperviseService() {
		// TODO Auto-generated method stub
		return cd.TableSuperviseDao();
	}
	@Override
	public int TableSuperviseService(int jno, String tano) {
		// TODO Auto-generated method stub
		return cd.TableSuperviseDao(jno,tano);
	}
	@Override
	public List<Scoring> ScoringService(int jno) {
		// TODO Auto-generated method stub
		
		return cd.ScoringServiceDao(jno);
	}
	@Override
	public int JudgerScoreService(int pno, String tano, int score) {
		// TODO Auto-generated method stub
		return jd.JudgerScoreDao(pno,tano,score);
	}

	}


