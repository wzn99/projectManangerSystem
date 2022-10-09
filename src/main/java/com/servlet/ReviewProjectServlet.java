package com.servlet;

import com.dao.ProjectsDao;
import com.dao.impl.ProjectsDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 导师评审部分
 * 向前端发送当期项目的内容
 * 前端提供参数：项目id：project_pid
 * 响应：对应的project_content(字符串)
 */
@WebServlet("/ReviewProjectServlet")
public class ReviewProjectServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置字符集
        req.setCharacterEncoding("UTF-8");
        //获取请求参数
        Integer project_pid = Integer.valueOf(req.getParameter("project_pid"));
        //从数据库获取当期报告的内容
        ProjectsDao projectsDao = new ProjectsDaoImpl();
        String content=projectsDao.getProjectByPid(project_pid);
        //响应
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write(content);
    }
}
