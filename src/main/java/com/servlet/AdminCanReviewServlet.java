package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.dao.Can_ReviewDao;
import com.dao.ProjectsDao;
import com.dao.UsersDao;
import com.dao.impl.Can_ReviewDaoImpl;
import com.dao.impl.ProjectsDaoImpl;
import com.dao.impl.UsersDaoImpl;
import com.pojo.*;

@WebServlet(urlPatterns={"/ShowCanReview","/ChangeReview"})

public class AdminCanReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminCanReviewServlet() {
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
		if(uri.equals(path+"/ShowCanReview")) {
		    Show(request, response);
		}
		else if(uri.equals(path+"/ChangeReview")) {
		    ChangeReview(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	//添加并展示出某项目各个老师的权限
	public void Show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String project_pid = request.getParameter("project_pid");
		UsersDao usersDao = new UsersDaoImpl();
		Can_ReviewDao can_ReviewDao = new Can_ReviewDaoImpl();
		List<User> teacherslist = usersDao.ShowByRole("teacher");
		for(User teacher:teacherslist) {
			//如果找不到对应则增加
			if(can_ReviewDao.GetByuidAndpid(teacher.getUid(), Integer.parseInt(project_pid))==null) {
				can_ReviewDao.AddView("no", teacher.getUid(), Integer.parseInt(project_pid));
			}
		}
		//获得某项目所有权限
		List<Can_Review> can_reviewlist = can_ReviewDao.GetBypid(Integer.parseInt(project_pid));
		request.setAttribute("teacherslist", teacherslist);
		request.setAttribute("can_reviewlist",can_reviewlist);
		request.getRequestDispatcher("ShowCan_Review.jsp").forward(request,response);
	}
	//修改权限
	public void ChangeReview(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Can_ReviewDao can_ReviewDao = new Can_ReviewDaoImpl();
		String path = request.getContextPath();
		String teacher_uid = request.getParameter("teacher_uid");
		String can_review = request.getParameter("can_review");
		String project_pid = request.getParameter("project_pid");
		
		if(can_review.equals("yes")) {
			can_ReviewDao.ChangeView("no", Integer.parseInt(teacher_uid),Integer.parseInt(project_pid));
		}
		else {
			can_ReviewDao.ChangeView("yes", Integer.parseInt(teacher_uid),Integer.parseInt(project_pid));
		}
		response.sendRedirect(path+"/ShowCanReview?project_pid="+project_pid);
	}
}
