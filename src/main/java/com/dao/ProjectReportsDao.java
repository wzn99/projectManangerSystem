package com.dao;

import com.pojo.Project_Report;

import java.util.List;

public interface ProjectReportsDao {
    /**
     * 获取项目报告
     *
     * @param tid 团队的tid
     * @param pid 项目的pid
     * @return 返回项目报告实体
     */
    Project_Report loadProjectReport(int tid, int pid);

    /**
     * 批量获取项目报告
     *
     * @param tid 团队的tid
     * @return 返回项目报告列表
     */
    List<Project_Report> getProjectReports(int tid);

    /**
     * 设定某项目报告的内容
     *
     * @param project_report 项目报告实体{@link Project_Report}
     */
    int setProjectReport(Project_Report project_report);

    /**
     * 添加项目报告
     *
     * @param project_report 项目报告实体{@link Project_Report}
     */
    
    int addProjectReport(Project_Report project_report);
    /**
     * 根据项目的 pid 获取当期项目的所有报告
     * @param pid Project_Report的 Projects_pid
     * @return 对应的List<Project_Report>，若pid不存在返回null
     */
    public List<Project_Report> getProject_ReportByPid(Integer pid);

	//根据团队号和项目号输出
	public Project_Report ShowRepote(Integer teams_tid,Integer projects_pid);
	//根据团队号和项目号输出
	public Project_Report ShowRepote(String teams_tid);
	//根据项目号输出所有提交的团队
	public List<Project_Report> ShowTeam(Integer projects_pid);
	//根据项目号和团队号新增报告
	public boolean Add(Integer projects_pid,Integer teams_tid);
	//修改综合评价
	public boolean Change(Integer projects_pid,Integer teams_tid,String synthetic_review);
}
