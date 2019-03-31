package bg.dao.impl;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import bg.dao.JudgerDao;
import bg.pojo.Judger;
import bg.pojo.Player;

public class JudgerDaoImpl implements JudgerDao {

	@Override
	public Judger checkJudgeLoginDao(String jid, String jpassword) {
		// TODO Auto-generated method stub

		java.sql.Connection conn=null;
		java.sql.PreparedStatement ps=null;
		ResultSet rs=null;
	    Judger j=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/boardgame", "root", "");
		    String sql="select * from judge where jid=? and jpassword=?";
		    ps=conn.prepareStatement(sql);
		    ps.setString(1,jid);
		    ps.setString(2,jpassword);
		    rs=ps.executeQuery();
		    while(rs.next()){
		    	j=new Judger();
		    	j.setJno(rs.getInt("jno"));
		    	j.setJid(rs.getString("jid"));
		    	j.setJname(rs.getString("jname"));
		    	j.setJpassword(rs.getString("jpassword"));
		    	j.setJmobile(rs.getString("jmobile"));
		    }
		
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return j;
	}

	@Override
	public int JudgerScoreDao(int pno, String tano, int score) {
		// TODO Auto-generated method stub
		java.sql.Connection conn=null;
		java.sql.PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/boardgame", "root", "");
			String sql="update sit set score = ? where tano=? and pno=?";
			ps=conn.prepareStatement(sql);
		    ps.setInt(1,score);
		    ps.setString(2,tano);
		    ps.setInt(3,pno);
		    ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 1;
	}

}
