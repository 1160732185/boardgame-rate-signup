package bg.dao.impl;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bg.dao.CompetitionDao;
import bg.pojo.Competition;
import bg.pojo.Game;
import bg.pojo.Scoring;
import bg.pojo.Table;

public class CompetitionDaoImpl implements CompetitionDao {

	@Override
	public List<Competition> CompetitionShowDao() {
		java.sql.Connection conn=null;
		java.sql.PreparedStatement ps=null;
		ResultSet rs=null;
		List<Competition> lc=new ArrayList<Competition>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/boardgame", "root", "");
		    String sql="select * from competition";
		    ps=conn.prepareStatement(sql);
		    rs=ps.executeQuery();
		    while(rs.next()){
		    	Competition c=new Competition();
		    	c.setCno(rs.getString("cno"));
		    	c.setCname(rs.getString("cname"));
		    	c.setGno(rs.getString("gno"));
		    	c.setCpno(rs.getInt("cpno"));
		    	lc.add(c);
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
		return lc;
	}

	@Override
	public int CompetitionSignDao(int pno, String cno) {
		// TODO Auto-generated method stub
				java.sql.Connection conn=null;
				java.sql.PreparedStatement ps=null;
				ResultSet rs=null;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/boardgame", "root", "");
				    
					String sql="select * from sign where pno = ? and cno = ?" ;
					ps=conn.prepareStatement(sql);
				    ps.setInt(1,pno);
				    ps.setString(2,cno);
				    rs=ps.executeQuery();
				    //System.out.println("这个"+rs.getInt("pno"));
					if(rs.next()){return 0;}
					else{
					sql="insert into sign values(?,?)";
				    ps=conn.prepareStatement(sql);
				    ps.setInt(1,pno);
				    ps.setString(2,cno);
				    ps.execute();
					sql="select * from competition where cno = ?";
					ps=conn.prepareStatement(sql);
				    ps.setString(1,cno);
				    rs=ps.executeQuery();
				    int cpno=0;
				    while(rs.next()){
				    	cpno=rs.getInt("cpno");
				    }
				    cpno++;
					//System.out.println("sum:"+sum+" "+count);
				    sql="update competition set cpno = ? where cno = ?";
					ps=conn.prepareStatement(sql);
				    ps.setFloat(1,cpno);
				    ps.setString(2,cno);
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
	public List<Table> TableShowDao() {
		// TODO Auto-generated method stub
		java.sql.Connection conn=null;
		java.sql.PreparedStatement ps=null;
		ResultSet rs=null;
		List<Table> lt=new ArrayList<Table>();
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/boardgame", "root", "");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		    String sql="select * from gametable";
		    try {
				ps=conn.prepareStatement(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    try {
				rs=ps.executeQuery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    try {
				while(rs.next()){
					Table t=new Table();
					t.setTano(rs.getString("tano"));
					t.setCno(rs.getString("cno"));
					t.setJno(rs.getInt("jno"));
					t.setPmax(rs.getInt("pmax"));
					t.setPnow(rs.getInt("pnow"));
					lt.add(t);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		 
		return lt;
	}

	@Override
	public int TableSitDao(int pno, String tano) {
		// TODO Auto-generated method stub
		java.sql.Connection conn=null;
		java.sql.PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/boardgame", "root", "");
			conn.setAutoCommit(false);
			String sql="select * from gametable where tano = ?";
			ps=conn.prepareStatement(sql);
		    ps.setString(1,tano);
		    rs=ps.executeQuery();
		    int pnow=0;
		    int pmax=0;
		    while(rs.next()){
		    	pnow=rs.getInt("pnow");
		    	pmax=rs.getInt("pmax");
		    }
		    if(pnow>=pmax) return 2;
		    sql="select * from sit where pno = ? and tano = ?" ;
			ps=conn.prepareStatement(sql);
		    ps.setInt(1,pno);
		    ps.setString(2,tano);
		    rs=ps.executeQuery();
		    //System.out.println("这个"+rs.getInt("pno"));
			if(rs.next()){return 0;}
			else{
			sql="insert into sit (pno,tano,stime) values(?,?,?)";
		    ps=conn.prepareStatement(sql);
		    ps.setInt(1,pno);
		    ps.setString(2,tano);
		    Date nowTime=new Date();
	        java.sql.Date date = new java.sql.Date(nowTime.getTime());//进行日期的转换
		    ps.setDate(3,date);
		    ps.execute();
			//System.out.println("sum:"+sum+" "+count);
		    pnow++;
		    sql="update gametable set pnow = ? where tano = ?";
			ps=conn.prepareStatement(sql);
		    ps.setFloat(1,pnow);
		    ps.setString(2,tano);
		    System.out.println(ps);
		    ps.execute();
		    conn.commit();
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
	public List<Table> TableSuperviseDao() {
		java.sql.Connection conn=null;
		java.sql.PreparedStatement ps=null;
		ResultSet rs=null;
		List<Table> lt=new ArrayList<Table>();
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/boardgame", "root", "");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		    String sql="select * from gametable where jno is null";
		    try {
				ps=conn.prepareStatement(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    try {
				rs=ps.executeQuery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    try {
				while(rs.next()){
					Table t=new Table();
					t.setTano(rs.getString("tano"));
					t.setCno(rs.getString("cno"));
					t.setJno(rs.getInt("jno"));
					t.setPmax(rs.getInt("pmax"));
					t.setPnow(rs.getInt("pnow"));
					lt.add(t);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		 
		return lt;
	}

	@Override
	public int TableSuperviseDao(int jno, String tano) {
		// TODO Auto-generated method stub
		java.sql.Connection conn=null;
		java.sql.PreparedStatement ps=null;
		ResultSet rs=null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/boardgame", "root", "");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
			String sql="update gametable set jno =  ? where tano = ?" ;
			try {
				ps=conn.prepareStatement(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    try {
				ps.setInt(1,jno);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    try {
				ps.setString(2,tano);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    try {
				ps.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   
		
		return 1;	
		
	}

	@Override
	public List<Scoring> ScoringServiceDao(int jno) {
		// TODO Auto-generated method stub
		java.sql.Connection conn=null;
		java.sql.PreparedStatement ps=null;
		ResultSet rs=null;
		List<Scoring> ls=new ArrayList<Scoring>();
		System.out.println(jno);	
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/boardgame", "root", "");
					String sql="select * from gametable t,sit s where t.tano=s.tano and t.jno=? and score is null ";
		
				    ps=conn.prepareStatement(sql);
				    System.out.println(jno);
				    ps.setInt(1,jno);
					System.out.println(ps);
				    rs=ps.executeQuery();
					while(rs.next()){
					Scoring s=new Scoring();
					s.setTano(rs.getString("tano"));
					s.setPno(rs.getInt("pno"));
					ls.add(s);
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
			return ls;
	}
	}


