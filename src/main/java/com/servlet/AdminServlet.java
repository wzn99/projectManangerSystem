package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.dao.UsersDao;
import com.dao.impl.UsersDaoImpl;
import com.pojo.*;

@WebServlet(urlPatterns={"/AddUser","/UserAdd","/UserQuery","/UserDelete","/UserChange","/ChangeUser","/Return"})
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
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
		if(uri.equals(path+"/UserQuery")) {
		    ShowUser(request, response);
		}
		else if(uri.equals(path+"/UserAdd")) {
		    newUser(request, response);
		}
		else if(uri.equals(path+"/UserDelete")) {
		    DeleteUser(request, response);
		}
		else if(uri.equals(path+"/UserChange")) {
		    UserChange(request, response);
		}
		else if(uri.equals(path+"/ChangeUser")) {
			ChangeUser(request, response);
		}
		else if(uri.equals(path+"/AddUser")) {
			ToAdd(request, response);
		}
		else if(uri.equals(path+"/Return")) {
			Back(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
    //新增用户函数
	public void newUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getParameter("uid");
		String name = request.getParameter("name");
		String telephone_number = request.getParameter("telephone_number");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		String teams_tid = request.getParameter("teams_tid");
		
		UsersDao usersDao = new UsersDaoImpl();
		Boolean bool = usersDao.newUser(Integer.parseInt(uid),name, telephone_number, email, password, role, Integer.parseInt(teams_tid));
		if(bool==true) {
			request.setAttribute("messages","新增成功");
			request.getRequestDispatcher("AddUser.jsp").forward(request,response);
		}
		else request.setAttribute("messages","新增失败");
		
	}
	//显示用户信息函数
	public void ShowUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		UsersDao usersDao = new UsersDaoImpl();
		List<User> userlist=usersDao.Show();
		request.setAttribute("userlist",userlist);
		request.getRequestDispatcher("ShowUser.jsp").forward(request,response);
	
	}
	//删除用户信息
	public void DeleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		UsersDao usersDao = new UsersDaoImpl();
		String uid = request.getParameter("uid");
		String path = request.getContextPath();
		Boolean bool = usersDao.deleteUser(Integer.parseInt(uid));
		if(bool==true) {
		    response.sendRedirect(path+"/UserQuery");
		}
	}
	//跳转到修改界面
	public void UserChange(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		UsersDao usersDao = new UsersDaoImpl();
		String uid = request.getParameter("uid");
		User user = usersDao.getByUid(Integer.parseInt(uid));
		request.setAttribute("user",user);
		request.getRequestDispatcher("ChangeUser.jsp").forward(request,response);
	}
	//修改学生信息
	public void ChangeUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		UsersDao usersDao = new UsersDaoImpl();
		String path = request.getContextPath();
		String uid = request.getParameter("uid");
		String name = request.getParameter("name");
		String telephone_number = request.getParameter("telephone_number");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		String teams_tid = request.getParameter("teams_tid");
		Boolean bool = usersDao.changeUser(Integer.parseInt(uid), name, telephone_number, email, password, role, Integer.parseInt(teams_tid));
		if(bool==true) {
		    response.sendRedirect(path+"/UserQuery");
		}
		
	}
	//跳转到增加界面
	public void ToAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.getRequestDispatcher("AddUser.jsp").forward(request,response);
	}
	//返回主界面
	public void Back(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.getRequestDispatcher("admin_main.jsp").forward(request,response);
	}
}
