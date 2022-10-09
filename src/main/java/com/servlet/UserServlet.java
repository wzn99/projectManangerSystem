package com.servlet;

import com.dao.UsersDao;
import com.dao.impl.UsersDaoImpl;
import com.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


@WebServlet("/user.do")
public class UserServlet extends HttpServlet {
    /**
     * 获取当前用户
     *
     * @param session {@link HttpSession}类型的会话
     * @return {@link User} 当前用户
     * @throws ServletException 用户为空时返回
     */
    protected User getCurrentUser(HttpSession session) throws ServletException {
        if (session.getAttribute("user") == null) {
            throw new ServletException("当前用户为空，请先登录!");
        } else return (User) session.getAttribute("user");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        //获取当前类中所有的方法
        Method[] methods = this.getClass().getMethods();

        //获取操作符，路由到对应操作
        //前端中需规定operate参数的值，如/user.do?operate=login表示登录
        String operate = req.getParameter("operate");

        //根据operate值找到对应方法
        for (Method m : methods) {
            String methodName = m.getName();

            //找到和operate同名的方法，通过反射技术调用
            //注意：反射调用的方法需声明为public
            if (operate.equals(methodName)) {
                try {
                    m.invoke(this, req, resp);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
                return;
            }
        }

        throw new RuntimeException("operate值非法");
    }

    /**
     * 处理登录请求
     * url /user.do?operate=login
     */
    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        String email = req.getParameter("email");
        String pwd = req.getParameter("pwd");

        UsersDao usersDao = new UsersDaoImpl();
        User currentUser = usersDao.getUserByLogin(email, pwd);

        if (currentUser != null) {
            // 将当前user保存到会话中
            HttpSession session = req.getSession();
            session.setAttribute("user", currentUser);
            String role = currentUser.getRole();
            //根据当前角色类型跳转到不同的页面
            switch (role) {
			case "member":
				resp.sendRedirect("team_index.jsp");
				break;
			case "teacher":	//导师不能直接登录
	        	req.setAttribute("login_message", "failed");
	            req.setAttribute("email", email);
	            req.getRequestDispatcher("login.jsp").forward(req, resp);
				break;
			case "admin":
				resp.sendRedirect("admin_index.jsp");
				break;
			default:
				throw new IllegalArgumentException("Unexpected value");
			}
        	req.setAttribute("login_message", "success");
        }
        else {
        	req.setAttribute("login_message", "failed");
            req.setAttribute("email", email);
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }

    /**
     * 处理信息修改
     * url /user.do?operate=modifyMessage
     * 前端需要提供的参数:
     * telephone_number 修改的电话号码
     * email 修改的邮箱
     * pwd 修改的密码
     */
    public void modifyMessage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        User currentUser = getCurrentUser(req.getSession());
        String pastEmail = currentUser.getEmail();

        String telephone_number = req.getParameter("telephone_number");
        String email = req.getParameter("email");
        String pwd0 = req.getParameter("pwd0");
        String pwd1 = req.getParameter("pwd1");
        String pwd2 = req.getParameter("pwd2");
        if (!telephone_number.isEmpty()) currentUser.setTelephone_number(telephone_number);
        if (!email.isEmpty()) currentUser.setEmail(email);
        if (!pwd0.isEmpty() || !pwd1.isEmpty() || !pwd2.isEmpty() ) {
        	if (pwd0.isEmpty()) {
        		req.setAttribute("pwd_message", "请输入原密码！");
                req.getRequestDispatcher("pwd_failed.jsp").forward(req, resp);
        	}
        	else if (pwd1.isEmpty()) {
        		req.setAttribute("pwd_message", "请输入新密码！");
                req.getRequestDispatcher("pwd_failed.jsp").forward(req, resp);
        	}
        	else if (pwd2.isEmpty()) {
        		req.setAttribute("pwd_message", "请输入确认密码！");
                req.getRequestDispatcher("pwd_failed.jsp").forward(req, resp);
        	}
        	else {
        		if (!pwd0.equals(currentUser.getPassword())) {
            		req.setAttribute("pwd_message", "原密码错误！");
                    req.getRequestDispatcher("pwd_failed.jsp").forward(req, resp);           			
        		}
        		if (!pwd1.equals(pwd2)) {
            		req.setAttribute("pwd_message", "两次新密码不一致！");
                    req.getRequestDispatcher("pwd_failed.jsp").forward(req, resp);        			
        		}
        		else {
                	currentUser.setPassword(pwd1);
                	req.getRequestDispatcher("success.jsp").forward(req, resp);
        		}
        	}
        }

        UsersDao usersDao = new UsersDaoImpl();
        if (usersDao.setUserMessage(currentUser) == 1) {
            // 修改信息成功，这里最好改成弹窗
            req.getRequestDispatcher("success.jsp").forward(req, resp);
        } else {
            // 修改失败，邮箱已被占用
        	currentUser.setEmail(pastEmail);
            req.getRequestDispatcher("failed.jsp").forward(req, resp);
        }
    }
}
