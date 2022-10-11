package com.service;

import com.mapper.Teacher_ReviewMapper;
import com.pojo.Teacher_Review;
import com.util.SqlSessionFactoryUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class Teacher_ReviewService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public List<Teacher_Review> getTempReview(Integer teacher_uid,Integer project_pid){
        SqlSession sqlSession = factory.openSession();
        Teacher_ReviewMapper teacher_reviewMapper = sqlSession.getMapper(Teacher_ReviewMapper.class);
        List<Teacher_Review> tempReviews = teacher_reviewMapper.getTempReview(teacher_uid, project_pid);
        sqlSession.close();
        return tempReviews;
    }

    public int saveReview(Integer teacher_uid, Integer team_tid, Integer project_pid,
                           String review,  Integer score,String submitted){
        SqlSession sqlSession = factory.openSession(true);//自动提交
        Teacher_ReviewMapper teacher_reviewMapper = sqlSession.getMapper(Teacher_ReviewMapper.class);
        int i = teacher_reviewMapper.saveReview(teacher_uid, team_tid, project_pid, review, score,submitted);
        sqlSession.close();
        return i;
    }

    public int updateReview(Integer teacher_uid, Integer team_tid, Integer project_pid,
                          String review,  Integer score,String submitted){
        SqlSession sqlSession = factory.openSession(true);//自动提交
        Teacher_ReviewMapper teacher_reviewMapper = sqlSession.getMapper(Teacher_ReviewMapper.class);
        int i = teacher_reviewMapper.updateReview(teacher_uid, team_tid, project_pid, review, score,submitted);
        sqlSession.close();
        return i;
    }

    public Teacher_Review getReview(Integer teacher_uid, Integer team_tid, Integer project_pid) {
        SqlSession sqlSession = factory.openSession();
        Teacher_ReviewMapper teacher_reviewMapper = sqlSession.getMapper(Teacher_ReviewMapper.class);
        Teacher_Review teacher_review = teacher_reviewMapper.getReview(teacher_uid, team_tid, project_pid);
        return teacher_review;
    }
}
