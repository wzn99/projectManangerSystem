package com.service;

import com.mapper.ProjectMapper;
import com.mapper.ProjectReportsMapper;
import com.mapper.Teacher_ReviewMapper;
import com.mapper.UserMapper;
import com.pojo.Project_Report;
import com.pojo.Teacher_Review;
import com.pojo.User;
import com.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.ArrayList;
import java.util.List;

public class ProjectReportsService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    //查找登录导师再当期报告的评审中，还没有提交评审的组的报告
    public List<Project_Report> reportsToReview(Integer project_pid,Integer teacher_uid){
        //查找当期的所有报告
        SqlSession sqlSession = factory.openSession();
        ProjectReportsMapper projectReportsMapper = sqlSession.getMapper(ProjectReportsMapper.class);
        List<Project_Report> reports = projectReportsMapper.getProject_ReportByPid(project_pid);
        List<Project_Report> reportsToReview = new ArrayList<>();
        //移除导师已经提交评审的报告
        Teacher_ReviewMapper teacher_reviewMapper = sqlSession.getMapper(Teacher_ReviewMapper.class);
        for(Project_Report report : reports){
            Integer team_id=report.getTeams_tid();
            if(teacher_reviewMapper.isReviewSumitted(teacher_uid,project_pid,team_id).equals("yes")){
                reports.remove(report);
            }
        }
        sqlSession.close();
        return reports;
    }
}
