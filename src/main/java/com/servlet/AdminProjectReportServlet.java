package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.dao.ProjectReportsDao;
import com.dao.Teacher_ReviewDao;
import com.dao.TeamsDao;
import com.dao.UsersDao;
import com.dao.impl.ProjectReportsDaoImpl;
import com.dao.impl.Teacher_ReviewDaoImpl;
import com.dao.impl.TeamsDaoImpl;
import com.dao.impl.UsersDaoImpl;
import com.pojo.Project_Report;
import com.pojo.Teacher_Review;
import com.pojo.Team;
import com.pojo.User;

@WebServlet(urlPatterns={"/ShowTeamRepote","/ShowRepote","/ChangeSynthetic_review"})
//需要传project_pid
//需要传projects_pid和teams_tid
//需要传project_pid和team_tid和synthetic_review

public class AdminProjectReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminProjectReportServlet() {
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
		if(uri.equals(path+"/ShowTeamRepote")) {
		    Show(request, response);
		}
		else if(uri.equals(path+"/ShowRepote")) {
		    ShowRepote(request, response);
		}
		else if(uri.equals(path+"/ChangeSynthetic_review")) {
			ChangeSynthetic_review(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	//显示某个项目的所有团队信息
	public void Show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		ProjectReportsDao ProjectReportsDao = new ProjectReportsDaoImpl();
		TeamsDao TeamsDao = new TeamsDaoImpl();
		
		String project_pid = request.getParameter("project_pid");
		
		List<Project_Report> teamsRepotes = ProjectReportsDao.ShowTeam(Integer.parseInt(project_pid));
		List<Team> teams = TeamsDao.Show();
		
		request.setAttribute("teamsRepotes",teamsRepotes);
		request.setAttribute("teams",teams);
		request.getRequestDispatcher("ShowTeamRepotes.jsp").forward(request,response);
	}
	//显示某项目某团队的详细信息
	public void ShowRepote(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		ProjectReportsDao ProjectReportsDao = new ProjectReportsDaoImpl();
		Teacher_ReviewDao teacher_ReviewDao = new Teacher_ReviewDaoImpl();
		UsersDao usersDao = new UsersDaoImpl();
		
		String project_pid = request.getParameter("projects_pid");
		String team_tid = request.getParameter("teams_tid");
		
		Project_Report reports = ProjectReportsDao.ShowRepote(Integer.parseInt(team_tid), Integer.parseInt(project_pid));
		List<Teacher_Review> reviewlist = teacher_ReviewDao.ReadView(Integer.parseInt(team_tid), Integer.parseInt(project_pid));
		List<User> teacherslist = usersDao.ShowByRole("teacher");
		//Project_Report reports = ProjectReportsDao.ShowRepote(team_tid);
		
		request.setAttribute("report_content",reports.getReport_content());
		request.setAttribute("synthetic_review",reports.getSyntheticReview());
		request.setAttribute("project_pid",project_pid);
		request.setAttribute("team_tid",team_tid);
		request.setAttribute("reviewlist",reviewlist);
		request.setAttribute("teacherslist",teacherslist);
		
		request.getRequestDispatcher("ShowRepote.jsp").forward(request,response);
		
	}
	//修改综合评价
	public void ChangeSynthetic_review(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		ProjectReportsDao ProjectReportsDao = new ProjectReportsDaoImpl();
		String synthetic_review = request.getParameter("synthetic_review");
		String project_pid = request.getParameter("project_pid");
		String team_tid = request.getParameter("team_tid");
		
		Boolean bool = ProjectReportsDao.Change(Integer.parseInt(project_pid), Integer.parseInt(team_tid), synthetic_review);
		if(bool==true) {
			String path = request.getContextPath();
			response.sendRedirect(path+"/ShowRepote?teams_tid="+team_tid+"&projects_pid="+project_pid);
			
		}
	}
}
