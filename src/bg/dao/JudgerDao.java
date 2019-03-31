package bg.dao;

import bg.pojo.Judger;

public interface JudgerDao {

	Judger checkJudgeLoginDao(String jid, String jpassword);

	int JudgerScoreDao(int pno, String tano, int score);

}
