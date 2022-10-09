package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.dao.ProjectsDao;
import com.dao.ProjectReportsDao;
import com.dao.TeamsDao;
import com.dao.UsersDao;
import com.dao.impl.ProjectsDaoImpl;
import com.dao.impl.ProjectReportsDaoImpl;
import com.dao.impl.TeamsDaoImpl;
import com.dao.impl.UsersDaoImpl;
import com.mysql.cj.jdbc.result.UpdatableResultSet;
import com.pojo.*;


@WebServlet(urlPatterns={"/AddProject","/QueryProject","/ChangeSubmit"})

public class AdminProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminProjectServlet() {
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
		if(uri.equals(path+"/AddProject")) {
		    newProject(request, response);
		}
		else if(uri.equals(path+"/QueryProject")) {
			ShowProject(request, response);
		}
		else if(uri.equals(path+"/ChangeSubmit")) {
			ChangeSubmit(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	//新增项目
	public void newProject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pid = request.getParameter("pid");
		String content = request.getParameter("content");
		String cansubmit = request.getParameter("can_submit");
		String can_submit;
		
		if(cansubmit.equals("on")) {
			can_submit="yes";
		}
		else can_submit="no";
		
		ProjectsDao projectDao = new ProjectsDaoImpl();
		Boolean bool = projectDao.Add(Integer.parseInt(pid), content, can_submit);
		if(bool==true) {
			//在Repote表中新增数据
			//newReport(request, response, pid);
			
			request.setAttribute("messages","新增成功");
			request.getRequestDispatcher("AddProject.jsp").forward(request,response);
		}
		else request.setAttribute("messages","新增失败");
		
	}
	//新增项目的同时对reporte表进行更新
	public void newReport(HttpServletRequest request, HttpServletResponse response,String projects_pid) throws ServletException, IOException {
		TeamsDao teamDao = new TeamsDaoImpl();
		ProjectReportsDao project_RepoteDao = new ProjectReportsDaoImpl(); 
		List<Team> teams = teamDao.Show();
		//增加新的行
		for(Team team:teams) {
		    project_RepoteDao.Add(Integer.parseInt(projects_pid), team.getTid());
		}
		
	}
	//显示项目
	public void ShowProject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		ProjectsDao projectDao = new ProjectsDaoImpl();
		List<Project> projectlist=projectDao.Show();
		request.setAttribute("projectlist",projectlist);
		request.getSession().setAttribute("yes","yes");
		request.getSession().setAttribute("no","no");
		request.getRequestDispatcher("ShowProject.jsp").forward(request,response);
	}
	//更改权限
	public void ChangeSubmit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		ProjectsDao projectDao = new ProjectsDaoImpl();
		String path = request.getContextPath();
		String pid = request.getParameter("pid");
		String can_submit = request.getParameter("can_submit");
		if(can_submit.equals("yes")) {
			projectDao.UpdateSubmit(pid, "no");
		}
		else {
			projectDao.UpdateSubmit(pid, "yes");
		}
		response.sendRedirect(path+"/QueryProject");
	}
}
