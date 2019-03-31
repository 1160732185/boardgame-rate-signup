package bg.dao;

import java.util.List;

import bg.pojo.Competition;
import bg.pojo.Scoring;
import bg.pojo.Table;

public interface CompetitionDao {

	List<Competition> CompetitionShowDao();

	int CompetitionSignDao(int pno, String cno);

	List<Table> TableShowDao();

	int TableSitDao(int pno, String tano);

	List<Table> TableSuperviseDao();

	int TableSuperviseDao(int jno, String tano);

	List<Scoring> ScoringServiceDao(int jno);


}
