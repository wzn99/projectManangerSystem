package com.service;

import com.mapper.Can_ReviewMapper;
import com.mapper.ProjectReportsMapper;
import com.mapper.UserMapper;
import com.pojo.User;
import com.util.SqlSessionFactoryUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public User getTeacherByUid(int uid, String password){
        SqlSession sqlSession = factory.openSession();
        ProjectReportsMapper projectReportsMapper = sqlSession.getMapper(ProjectReportsMapper.class);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User teacher = userMapper.getTeacherByUid(uid, password);
        return teacher;
    }

    public String canReview(Integer teacher_uid, Integer project_uid){
        SqlSession sqlSession = factory.openSession();
        Can_ReviewMapper can_reviewMapper = sqlSession.getMapper(Can_ReviewMapper.class);
        String canReview = can_reviewMapper.canReview(teacher_uid, project_uid);
        return canReview;
    }
}
