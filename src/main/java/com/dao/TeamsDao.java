package com.dao;

import java.util.List;

import com.pojo.Team;

public interface TeamsDao {
    /**
     * 通过team id获取Teams
     *
     * @param tid Teams的tid
     * @return {@link Team}
     */
    Team getTeam(int tid);
    
	//获取所有队伍信息
	public List<Team> Show();
	//根据tid删除团队信息
	public boolean DeleteTeam(Integer tid);
	//根据tid修改团队信息
	public boolean ChangeTeam(Integer tid,String name);
	//根据tid获取团队信息
	public Team GetByTid(Integer tid);
	//新增团队
	public boolean Add(Integer tid,String name);
}
