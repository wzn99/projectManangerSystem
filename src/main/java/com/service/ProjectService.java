package com.service;

import com.mapper.ProjectMapper;
import com.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class ProjectService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public String getProjectByPid(Integer pid){
        SqlSession sqlSession = factory.openSession();
        ProjectMapper projectMapper = sqlSession.getMapper(ProjectMapper.class);

        String content = projectMapper.getProjectByPid(pid);

        sqlSession.close();
        return content;
    }
}
