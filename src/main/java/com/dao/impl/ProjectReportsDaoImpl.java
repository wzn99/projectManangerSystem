package com.dao.impl;

import com.dao.ProjectReportsDao;
import com.dao.base.BaseDao;
import com.pojo.Project_Report;

import java.util.List;

public class ProjectReportsDaoImpl extends BaseDao<Project_Report> implements ProjectReportsDao {
    @Override
    public Project_Report loadProjectReport(int tid, int pid) {
        return super.load(
                "select * from project_reports where teams_tid = ? and projects_pid = ?",
                tid,
                pid
        );
    }

    @Override
    public List<Project_Report> getProjectReports(int tid) {
        return super.executeQuery(
                "select * from project_reports",
                tid
        );
    }

    @Override
    public int addProjectReport(Project_Report project_report) {
        return super.executeUpdate(
                "insert into project_reports values(?, ?, ?);",
                project_report.getTeams_tid(),
                project_report.getProjects_pid(),
                project_report.getReport_content()
        );
    }

    @Override
    public int setProjectReport(Project_Report project_report) {
        return super.executeUpdate(
                "update project_reports set report_content = ? where teams_tid = ? and projects_pid = ?",
                project_report.getReport_content(),
                project_report.getTeams_tid(),
                project_report.getProjects_pid()
        );
    }
    
    @Override
    public List<Project_Report> getProject_ReportByPid(Integer pid) {
        List<Project_Report> reports = super.executeQuery(
                "select * from project_reports where projects_pid = ?",
                pid);
        return reports;
    }

	@Override
	public Project_Report ShowRepote(Integer teams_tid, Integer projects_pid) {
		return super.load("select * from Project_Reports where teams_tid=? and projects_pid =?",
				teams_tid,projects_pid);
	}

	@Override
	public Project_Report ShowRepote(String teams_tid) {
		List<Project_Report> list = super.executeQuery("select * from Project_Reports where teams_tid=?",
				teams_tid);
		return list.get(0);
	}
	
	@Override
	public List<Project_Report> ShowTeam(Integer projects_pid) {
		return super.executeQuery("select * from Project_Reports where projects_pid = ?",
				projects_pid);
	}

	@Override
	public boolean Add(Integer projects_pid, Integer teams_tid) {
		if(super.executeUpdate("insert into Project_Reports values(?,?,?,?)", 
				teams_tid,projects_pid,"暂无报告","暂无评价")>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean Change(Integer projects_pid, Integer teams_tid,String synthetic_review) {
		if(super.executeUpdate("update Project_Reports set synthetic_review =? where projects_pid=? and teams_tid=?",
				synthetic_review,projects_pid,teams_tid)>0)
			return true;
		return false;
	}
}
