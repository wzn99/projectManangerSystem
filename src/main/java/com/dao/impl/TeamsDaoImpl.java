package com.dao.impl;

import java.util.List;

import com.dao.TeamsDao;
import com.dao.base.BaseDao;
import com.pojo.Team;

public class TeamsDaoImpl extends BaseDao<Team> implements TeamsDao {
    @Override
    public Team getTeam(int tid) {
        return super.load(
                "select * from teams where tid = ?",
                tid
        );
    }

	@Override
	public List<Team> Show() {
		return super.executeQuery("select * from Teams");
	}

	@Override
	public boolean DeleteTeam(Integer tid) {
		if(super.executeUpdate("delete from Teams where tid = ?", tid)>0)
			return true;
		return false;
	}

	@Override
	public boolean ChangeTeam(Integer tid,String name) {
		if(super.executeUpdate("update teams set name=? where tid=?", name, tid)>0)
			return true;
		return false;
	}

	@Override
	public Team GetByTid(Integer tid) {
		return super.load("select * from teams where tid = ?", tid);
	}

	@Override
	public boolean Add(Integer tid, String name) {
		if(super.executeUpdate("insert into teams values(?,?)", tid, name)>0) {
			return true;
		}
		return false;
	}
}
