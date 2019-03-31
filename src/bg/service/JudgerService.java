package bg.service;

import java.util.List;

import bg.pojo.Competition;
import bg.pojo.Judger;
import bg.pojo.Player;
import bg.pojo.Game;
import bg.pojo.Scoring;
import bg.pojo.Table;

public interface JudgerService {

	Judger checkJudgerLoginService(String jid, String jpassword);

	List<Table> TableSuperviseService();

	int TableSuperviseService(int jno, String tano);

	List<Scoring> ScoringService(int jno);

	int JudgerScoreService(int pno, String tano, int score);

}
