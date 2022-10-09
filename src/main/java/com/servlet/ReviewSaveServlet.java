package com.servlet;

import com.dao.ProjectReportsDao;
import com.dao.Teacher_ReviewDao;
import com.dao.impl.ProjectReportsDaoImpl;
import com.dao.impl.Teacher_ReviewDaoImpl;
import com.pojo.Project_Report;

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
 * 保存导师暂存或提交的评审结果
 * 前端提供参数：项目id,导师id,团队id,评分,评审意见：project_pid,teacher_uid,project_pid,score,review
 * 前端提供参数：若导师暂存评审结果，发送一个值不为null的temp参数；若导师提交评审结果，发送一个值不为null的submit参数
 * 响应：后端保存数据，不发送响应
 */
@WebServlet("/ReviewSaveServlet")
public class ReviewSaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置字符集
        req.setCharacterEncoding("UTF-8");
        //获取请求参数
        Integer project_pid = Integer.valueOf(req.getParameter("project_pid"));
        Integer teacher_uid= Integer.valueOf(req.getParameter("teacher_uid"));
        Integer team_tid = Integer.valueOf(req.getParameter("team_tid"));
        Integer score = Integer.valueOf(req.getParameter("score"));
        String review = req.getParameter("review");
        String temp = req.getParameter("temp");
        String submit = req.getParameter("submit");
        String submitted = "";
        if(temp!=null&&submit==null) submitted="no";
        if(temp==null&&submit!=null) submitted="yes";
        //判断导师是否已经提交全部评审
        //获取当期的所有报告
        ProjectReportsDao project_reportsDao=new ProjectReportsDaoImpl();
        List<Project_Report> reports=project_reportsDao.getProject_ReportByPid(project_pid);
        List<Project_Report> reports_notSubmitted = new ArrayList<Project_Report>();
        //把未提交的报告添加到列表reports_notSubmitted中
        Teacher_ReviewDao teacher_reviewDao1 = new Teacher_ReviewDaoImpl();
        for (Project_Report report: reports) {
            Integer team_id=report.getTeams_tid();
            if(!teacher_reviewDao1.is_submitted(teacher_uid,project_pid,team_id)){
                reports_notSubmitted.add(report);
            }
        }
        //如果没有待提交评审的报告，此时进行暂存或提交不修改数据库,直接返回
        if(reports_notSubmitted.size()==0){
            return;
        }
        //保存到数据库
        Teacher_ReviewDao teacher_reviewDao = new Teacher_ReviewDaoImpl();
        //若分数为0~100之间的数，进行保存
        if(score>=0&&score<=100){
            //若数据中没有保存该条记录，则insert数据
            if(!teacher_reviewDao.isReviewExist(teacher_uid,team_tid,project_pid)){
                teacher_reviewDao.saveReview(teacher_uid,team_tid,project_pid,review,score,submitted);
            }else {//若数据中有暂存的记录，则update数据
                teacher_reviewDao.updateReview(teacher_uid,team_tid,project_pid,score,review,submitted);
            }
        }
    }
}
