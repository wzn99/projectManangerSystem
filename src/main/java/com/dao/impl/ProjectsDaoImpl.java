package com.dao.impl;

import com.dao.ProjectsDao;
import com.dao.base.BaseDao;
import com.pojo.Project;
import com.pojo.Project_Report;

import java.util.List;

public class ProjectsDaoImpl extends BaseDao<Project> implements ProjectsDao {

    @Override
    public List<Project> getAllProjects() {
        return super.executeQuery(
                "select * from projects"
        );
    }
    
    @Override
    public String getProjectByPid(Integer pid) {
        Project projects=super.load("select*from projects where pid=?",pid);
        return projects.getContent();
    }

	@Override
	public boolean Add(Integer pid, String content, String can_submit) {
		if(super.executeUpdate("insert into Projects values(?,?,?)", pid,content,can_submit)>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean UpdateSubmit(String pid, String can_submit) {
		if(super.executeUpdate("update Projects set can_submit = ? where pid = ?", can_submit,pid)>0)
			return true;
		return false;
	}

	@Override
	public List<Project> Show() {
		
		return super.executeQuery("select * from Projects");
	}
}
