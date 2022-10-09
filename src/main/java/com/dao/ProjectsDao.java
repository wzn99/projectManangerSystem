package com.dao;

import com.pojo.Project;

import java.util.List;

public interface ProjectsDao {
    /**
     * 获取所有项目的列表
     *
     * @return 所有项目的列表
     */
    List<Project> getAllProjects();
    
    /**
     * 根据项目的pid获取项目的content
     * @param pid
     * @return 对应的Projects的content
     */
    public String getProjectByPid(Integer pid);
    
	//向Project表中添加一项新的数据,添加成功返回true
	public boolean Add(Integer pid, String content,String can_submit);
	
	//对序号为pid的can_submit项进行更改，更改为参数can_submit
	public boolean UpdateSubmit(String pid,String can_submit);
	
	//显示所有报告
	public List<Project> Show();
}
