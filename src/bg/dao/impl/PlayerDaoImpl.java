package bg.dao.impl;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bg.dao.PlayerDao;
import bg.pojo.Game;
import bg.pojo.Player;
import bg.pojo.Rate;
import bg.pojo.User;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class PlayerDaoImpl implements PlayerDao {

	@Override
	public Player checkPlayerLoginDao(String pid, String password) {
 
		java.sql.Connection conn=null;
		java.sql.PreparedStatement ps=null;
		ResultSet rs=null;
	    Player p=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/boardgame", "root", "");
		    String sql="select * from player where pid=? and password=?";
		    ps=conn.prepareStatement(sql);
		    ps.setString(1,pid);
		    ps.setString(2,password);
		    rs=ps.executeQuery();
		    while(rs.next()){
		    	p=new Player();
		    	p.setPno(rs.getInt("pno"));
		    	p.setPid(rs.getString("pid"));
		    	p.setRealname(rs.getString("realname"));
		    	p.setPassword(rs.getString("password"));
		    	p.setMobile(rs.getString("mobile"));
		    	p.setBalance(rs.getInt("balance"));
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
		return p;
	}


	@Override
	public int PlayerRegDao(Player p) {
		//用户注册
		int index = 0;
		java.sql.Connection conn=null;
		java.sql.PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/boardgame", "root", "");
		    String sql="insert into player values(default,?,?,?,?,0)";
		    ps=conn.prepareStatement(sql);
		    ps.setString(1, p.getPid());
		    ps.setString(2, p.getPassword());
		    ps.setString(3, p.getRealname());
		    ps.setString(4, p.getMobile());
		    index=ps.executeUpdate();
		
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
		return index;
	}


	@Override
	public int PlayerRateDao(int pno, String gno, int score) {
		// TODO Auto-generated method stub
		java.sql.Connection conn=null;
		java.sql.PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/boardgame", "root", "");
		    
			String sql="select * from ratet where pno = ? and gno = ?" ;
			ps=conn.prepareStatement(sql);
		    ps.setInt(1,pno);
		    ps.setString(2,gno);
		    rs=ps.executeQuery();
		    //System.out.println("这个"+rs.getInt("pno"));
			if(rs.next()){return 0;}
			else{
			sql="insert into ratet values(?,?,?)";
		    ps=conn.prepareStatement(sql);
		    ps.setInt(1,pno);
		    ps.setString(2,gno);
		    ps.setInt(3,score);
		    ps.execute();
			sql="select * from ratet where gno = ?";
			ps=conn.prepareStatement(sql);
		    ps.setString(1,gno);
		    rs=ps.executeQuery();
		    int sum=0;
		    int count=0;
		    while(rs.next()){
		    sum+=rs.getInt("rate");
		    count++;
		    }
			System.out.println("sum:"+sum+" "+count);
		    sql="update game set grate = ? where gno = ?";
			ps=conn.prepareStatement(sql);
		    ps.setFloat(1,(float)sum/count);
		    ps.setString(2,gno);
		    System.out.println(ps);
		    ps.execute();
			}
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


	@Override
	public List<Rate> ShowRateDao(int pno) {
		// TODO Auto-generated method stub
		
		java.sql.Connection conn=null;
		java.sql.PreparedStatement ps=null;
		ResultSet rs=null;
		List<Rate> lr=new ArrayList<Rate>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/boardgame", "root", "");
		    String sql="select * from ratet where pno=?";
		    ps=conn.prepareStatement(sql);
		    ps.setInt(1,pno);
		    rs=ps.executeQuery();
		    while(rs.next()){
		    	Rate r=new Rate();
		    	r.setPno(rs.getInt("pno"));
		    	System.out.println();
		    	r.setGno(rs.getString("gno"));
		    	r.setRate(rs.getInt("rate"));
		    	lr.add(r);
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
		return lr;
		
		
		
	}


	@Override
	public int DeleteRateDao(int pno, String gno) {
		// TODO Auto-generated method stub
		java.sql.Connection conn=null;
		java.sql.PreparedStatement ps=null;
		ResultSet rs=null;
		List<Rate> lr=new ArrayList<Rate>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/boardgame", "root", "");
		    String sql="delete from ratet where pno=? and gno=?";
		    ps=conn.prepareStatement(sql);
		    ps.setInt(1,pno);
		    ps.setString(2,gno);
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
		
		return 0;
	}
	}



