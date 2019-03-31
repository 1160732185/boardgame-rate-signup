package bg.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bg.pojo.Competition;
import bg.pojo.Game;
import bg.pojo.Player;
import bg.pojo.Rate;
import bg.pojo.Table;
import bg.pojo.User;
import bg.service.PlayerService;
import bg.service.impl.PlayerServiceImpl;

public class PlayerServlet extends HttpServlet {
	@Override
protected void service(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	req.setCharacterEncoding("utf-8");
	resp.setContentType("text/html;charset=utf-8");
	String oper=req.getParameter("oper");
	if(oper.equals("login")){checkUserLogin(req,resp);}
	else if(oper.equals("show")){gameshow(req,resp);}
	else if(oper.equals("register")){userRegister(req,resp);}
	else if(oper.equals("out")){userOut(req,resp);}
	else if(oper.equals("rate")){userRate(req,resp);}
	else if(oper.equals("showrate")){userShowRate(req,resp);}
	else if(oper.equals("sign")){userSign(req,resp);}
	else if(oper.equals("dorate")){userDorate(req,resp);}
	else if(oper.equals("buy")){userBuy(req,resp);}
	else if(oper.equals("dosign")){userDosign(req,resp);}
	else if(oper.equals("sit")){userSit(req,resp);}
	else if(oper.equals("dosit")){userDosit(req,resp);}
	else if(oper.equals("deleterate")){userDeleteRate(req,resp);}
	else{System.out.println("没有找到对应操作！"+oper);}
}

private void userDeleteRate(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
	PlayerService ps=new PlayerServiceImpl();
	HttpSession session=req.getSession();//获取session
    Object p=session.getAttribute("player");
    //获取游戏名
    String gno=req.getParameter("gno");
    int pno=((Player) p).getPno();
    System.out.println(pno+gno);
	int index=ps.DeleteRate(pno,gno);
	try {
		resp.sendRedirect("player?oper=showrate");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
}

private void userShowRate(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
	PlayerService ps=new PlayerServiceImpl();
	HttpSession session=req.getSession();//获取session
    Object p=session.getAttribute("player");
    int pno=((Player) p).getPno();
    List<Rate> lr=ps.ShowRate(pno);
    req.setAttribute("lr", lr);	
    try {
		req.getRequestDispatcher("/user/showrate.jsp").forward(req, resp);
	} catch (ServletException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

private void userDosit(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
	PlayerService ps=new PlayerServiceImpl();
	HttpSession session=req.getSession();//获取session
    Object p=session.getAttribute("player");
    //获取游戏名
    String tano=req.getParameter("tano");
    int pno=((Player) p).getPno();
    System.out.println(pno+tano);
	int index=ps.TableSitService(pno,tano);
	if(index==0){
		    try {		
		    	List<Table> lt=ps.TableShowService();
		    	req.setAttribute("lt", lt);	
		    	req.setAttribute("error", 0);
		    		try {
						req.getRequestDispatcher("/user/sit.jsp").forward(req, resp);
					} catch (ServletException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		    		return ;
		    } catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	else if(index==2){ 
		 try {		
		    	List<Table> lt=ps.TableShowService();
		    	req.setAttribute("lt", lt);	
		    	req.setAttribute("error2", 0);
		    		try {
						req.getRequestDispatcher("/user/sit.jsp").forward(req, resp);
					} catch (ServletException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		    		return ;
		    } catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	else{
		try {
			resp.sendRedirect("player?oper=sit");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}

private void userSit(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
	PlayerService ps=new PlayerServiceImpl();	
	List<Table> lt=ps.TableShowService();
	if(lt!=null){
		req.setAttribute("lt", lt);
		try {
			req.getRequestDispatcher("/user/sit.jsp").forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ;
	}
	}

private void userDosign(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
	PlayerService ps=new PlayerServiceImpl();
	HttpSession session=req.getSession();//获取session
    Object p=session.getAttribute("player");
    //获取游戏名
    String cno=req.getParameter("cno");
    int pno=((Player) p).getPno();
    System.out.println(pno+cno);
	int index=ps.CompetitionSignService(pno,cno);
	if(index==0){
		    try {		
		    	List<Competition> lc=ps.CompetitionShowService();
		    	req.setAttribute("lc", lc);	
		    	req.setAttribute("error", 0);
		    		try {
						req.getRequestDispatcher("/user/sign.jsp").forward(req, resp);
					} catch (ServletException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		    		return ;
		    } catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	else{
		try {
			resp.sendRedirect("player?oper=sign");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}

private void userDorate(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
	PlayerService ps=new PlayerServiceImpl();
	HttpSession session=req.getSession();//获取session
    Object p=session.getAttribute("player");
    //获取游戏名
    String gno=req.getParameter("gno");
    System.out.println("99"+gno);
    String scores= req.getParameter("score");
    int score=Integer.parseInt(scores);
    int pno=((Player) p).getPno();
    System.out.println(pno+gno+score);
	int index=ps.PlayerRateService(pno,gno,score);
	if(index==0){
		    try {		
		    	List<Game> lg=ps.GameShowService();
		    	req.setAttribute("lg", lg);	
		    	req.setAttribute("error", 0);
		    		try {
						req.getRequestDispatcher("/user/rate.jsp").forward(req, resp);
					} catch (ServletException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		    		return ;
		    } catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	else{
		try {
			resp.sendRedirect("player?oper=show");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}

private void userBuy(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		
	}

private void userRate(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
	    //获取gno与gname
	    String gno=req.getParameter("gno");
	    System.out.println("66"+gno);
	    req.setAttribute("gno",gno);	
	    String gname=req.getParameter("gname");
		req.setAttribute("gname", gname);
		System.out.println("77"+gno);
		//HttpSession hs=req.getSession();
    	//hs.setAttribute("game",gname);
		try {
			req.getRequestDispatcher("/user/dorate.jsp").forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

private void userRegister(HttpServletRequest req, HttpServletResponse resp) {
	//获取请求信息
	PlayerService ps=new PlayerServiceImpl();	
	String pid=req.getParameter("pid");
	String password=req.getParameter("password");
	String realname=req.getParameter("realname");
    String mobile=req.getParameter("mobile");
	Player p=new Player(0,pid,password,realname,mobile,0);
	//处理
	int index=ps.PlayerRegService(p);
	//响应
		
	}


private void userOut(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession hs=req.getSession();
		hs.invalidate();
		try {
			resp.sendRedirect("/BG/Login.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

private void checkUserLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException {
	//获取请求信息
	String pid=req.getParameter("pid");
	String password=req.getParameter("password");
	System.out.println(pid+":"+password);
    PlayerService ps=new PlayerServiceImpl();
    //校验
    Player p=ps.checkPlayerLoginService(pid, password);
    if(p!=null){ 
    	//获取session
    	HttpSession hs=req.getSession();
    	hs.setAttribute("player",p);
    	//重定向
    	resp.sendRedirect("/BG/main/main.jsp");
    }else{
    	//登录失败（请求转发）
    	try {
    		//添加错误标识
    		req.setAttribute("error", 0);
			req.getRequestDispatcher("/Login.jsp").forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }


}
private void gameshow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//调用service处理请求
PlayerService ps=new PlayerServiceImpl();	
List<Game> lg=ps.GameShowService();
if(lg!=null){
	req.setAttribute("lg", lg);
	req.getRequestDispatcher("/user/rate.jsp").forward(req, resp);
	return ;
}
}
private void userSign(HttpServletRequest req, HttpServletResponse resp) {
	// TODO Auto-generated method stub
	PlayerService ps=new PlayerServiceImpl();	
	List<Competition> lc=ps.CompetitionShowService();
	if(lc!=null){
		req.setAttribute("lc", lc);
		try {
			req.getRequestDispatcher("/user/sign.jsp").forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ;
	}
}
}



