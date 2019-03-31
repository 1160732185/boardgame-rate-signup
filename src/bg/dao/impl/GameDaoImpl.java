package bg.dao.impl;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bg.dao.GameDao;
import bg.pojo.Game;

public class GameDaoImpl implements GameDao{

	@Override
	public List<Game> GameShowDao() {
		java.sql.Connection conn=null;
		java.sql.PreparedStatement ps=null;
		ResultSet rs=null;
		List<Game> lg=new ArrayList<Game>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/boardgame", "root", "");
		    String sql="select * from game";
		    ps=conn.prepareStatement(sql);
		    rs=ps.executeQuery();
		    while(rs.next()){
		    	Game g=new Game();
		    	g.setGno(rs.getString("gno"));
		    	System.out.println("1"+g.getGno());
		    	g.setGname(rs.getString("gname"));
		    	g.setRate(rs.getFloat("grate"));
		    	g.setDifficulty(rs.getInt("difficulty"));
		    	g.setDno(rs.getString("dno"));
		    	g.setTno(rs.getString("tno"));
		    	g.setSales(rs.getInt("sales"));
		    	lg.add(g);
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
		return lg;
	}

}
