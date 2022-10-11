package com.web;

import com.alibaba.fastjson.JSON;
import com.dao.Can_ReviewDao;
import com.dao.ProjectReportsDao;
import com.dao.Teacher_ReviewDao;
import com.dao.UsersDao;
import com.dao.impl.Can_ReviewDaoImpl;
import com.dao.impl.ProjectReportsDaoImpl;
import com.dao.impl.Teacher_ReviewDaoImpl;
import com.dao.impl.UsersDaoImpl;
import com.pojo.Project_Report;
import com.pojo.User;
import com.service.ProjectReportsService;
import com.service.UserService;
import com.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 导师评审部分
 * 验证导师身份和权限，验证通过则向前端发送该期项目中各组提交的报告
 * 前端提供参数：项目id，导师id，导师密码：project_pid,teacher_uid,password
 * 后端响应： 1.若导师身份认证没通过，则响应"error"
 *          2.若导师身份认证通过，但没有权限，则响应"no permission"
 *          3.若身份和权限验证均通过，响应各组提交的报告(json对象数组 字段：teams_tid,projects_pid,report_content,synthetic)
 *
 */
@WebServlet("/reportsServlet")
public class ReviewReportServlet extends HttpServlet {
    private ProjectReportsService projectReportsService = new ProjectReportsService();
    private UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置字符集
        req.setCharacterEncoding("UTF-8");
        //获取请求参数
        int project_pid = Integer.parseInt(req.getParameter("project_pid"));
        int teacher_uid = Integer.parseInt(req.getParameter("teacher_uid"));
        String password = req.getParameter("password");
        //验证导师id和密码
        User teacher = userService.getTeacherByUid(teacher_uid,password);
        //若没查询到对应导师，则响应”error“
        if(teacher==null){
            resp.setContentType("text/html;charset=utf-8");
            resp.getWriter().write("error");
            return;
        }
        //验证该导师是否有评审该项目的权限,若没有权限，则响应”no permission"
        String canReview = userService.canReview(teacher_uid, project_pid);
        if(canReview.equals("no")){
            resp.setContentType("text/html;charset=utf-8");
            resp.getWriter().write("no permission");
            return;
        }
        //获取当期的所有报告
        List<Project_Report> reports = projectReportsService.reportsToReview(project_pid, teacher_uid);

//        ProjectReportsDao project_reportsDao=new ProjectReportsDaoImpl();
//        List<Project_Report> reports=project_reportsDao.getProject_ReportByPid(project_pid);
//        List<Project_Report> reports_notSubmitted = new ArrayList<Project_Report>();
//        //把未提交的报告添加到列表reports_notSubmitted中
//        Teacher_ReviewDao teacher_reviewDao = new Teacher_ReviewDaoImpl();
//        for (Project_Report report: reports) {
//            Integer team_id=report.getTeams_tid();
//            if(!teacher_reviewDao.is_submitted(teacher_uid,project_pid,team_id)){
//                reports_notSubmitted.add(report);
//            }
//        }
        //发送响应：当期未提交的报告
        String r= JSON.toJSONString(reports);
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(r);
        System.out.println(r);
    }
}
