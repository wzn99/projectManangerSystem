package com.web;

import com.alibaba.fastjson.JSON;
import com.dao.Teacher_ReviewDao;
import com.dao.impl.Teacher_ReviewDaoImpl;
import com.pojo.Teacher_Review;
import com.service.Teacher_ReviewService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 导师评审部分
 * 向前端发送暂存的评审内容
 * 前端提供参数：导师id,项目id：teacher_uid,project_pid
 * 响应：该导师评审该期项目时暂存的评审内容(json对象数组  字段：teacher_uid,team_tid,project_pid,project_pid,review,score,submitted)
 */
@WebServlet("/tempReviewServlet")
public class ReviewTempServlet extends HttpServlet {
    private Teacher_ReviewService teacher_reviewService = new Teacher_ReviewService();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置字符集
        req.setCharacterEncoding("UTF-8");
        //获取请求参数
        Integer teacher_uid = Integer.valueOf(req.getParameter("teacher_uid"));
        Integer project_pid = Integer.valueOf(req.getParameter("project_pid"));
        //从数据库获取暂存的Teacher_Review
        List<Teacher_Review> tempReviews = teacher_reviewService.getTempReview(teacher_uid, project_pid);
//        Teacher_ReviewDao teacher_reviewDao = new Teacher_ReviewDaoImpl();
//        List<Teacher_Review> tempReview = teacher_reviewDao.getTempReview(teacher_uid,project_pid);
        //发送响应：暂存的Teacher_Review
        String t= JSON.toJSONString(tempReviews);
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(t);
    }
}
