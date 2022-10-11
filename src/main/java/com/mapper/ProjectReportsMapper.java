package com.mapper;

import com.pojo.Project_Report;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProjectReportsMapper {

    @Select("select * from project_reports where projects_pid = #{pid}")
    @ResultType(Project_Report.class)
    public List<Project_Report> getProject_ReportByPid(Integer pid);

}
