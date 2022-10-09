package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.dao.TeamsDao;
import com.dao.UsersDao;
import com.dao.impl.TeamsDaoImpl;
import com.dao.impl.UsersDaoImpl;
import com.pojo.Team;
import com.pojo.User;

@WebServlet(urlPatterns={"/ShowTeam","/TeamChange","/ChangeTeam","/TeamDelete","/AddTeam"})

public class AdminTeamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminTeamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		String path = request.getContextPath();
		
		if(uri.equals(path+"/ShowTeam")) {
		    ShowTeam(request, response);
		}
		else if(uri.equals(path+"/TeamChange")) {
		    TeamChange(request, response);
		}
        else if(uri.equals(path+"/ChangeTeam")) {
		    ChangeUser(request, response);
		}
        else if(uri.equals(path+"/TeamDelete")) {
		    DeleteTeam(request, response);
		}
        else if(uri.equals(path+"/AddTeam")) {
		    newTeam(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	//显示团队信息函数
	public void ShowTeam(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		TeamsDao TeamsDao = new TeamsDaoImpl();
		List<Team> teamlist = TeamsDao.Show();
			
		request.setAttribute("teamlist",teamlist);
		request.getRequestDispatcher("ShowTeam.jsp").forward(request,response);
		
	}
	//删除用户信息
	public void DeleteTeam(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		TeamsDao TeamsDao = new TeamsDaoImpl();
		String tid = request.getParameter("tid");
		String path = request.getContextPath();
		Boolean bool = TeamsDao.DeleteTeam(Integer.parseInt(tid));
		if(bool==true) {
			   response.sendRedirect(path+"/ShowTeam");
		}
	}
	//跳转到修改界面
	public void TeamChange(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		TeamsDao TeamsDao = new TeamsDaoImpl();
		String tid = request.getParameter("tid");
		Team team = TeamsDao.GetByTid(Integer.parseInt(tid));
		
		request.setAttribute("team",team);
		request.getRequestDispatcher("ChangeTeam.jsp").forward(request,response);
	}
	//修改团队信息
	public void ChangeUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		TeamsDao TeamsDao = new TeamsDaoImpl();
		String path = request.getContextPath();
		String tid = request.getParameter("tid");
		String name = request.getParameter("name");
		
		Boolean bool = TeamsDao.ChangeTeam(Integer.parseInt(tid), name);
		if(bool==true) {
			response.sendRedirect(path+"/ShowTeam");
		}
			
	}
    //新增团队
	public void newTeam(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tid = request.getParameter("tid");
		String name = request.getParameter("name");
		
		TeamsDao TeamsDao = new TeamsDaoImpl();
		Boolean bool = TeamsDao.Add(Integer.parseInt(tid), name);
		if(bool==true) {
			request.setAttribute("messages","新增成功");
			request.getRequestDispatcher("AddTeam.jsp").forward(request,response);
		}
		else request.setAttribute("messages","新增失败");
		
	}
}
