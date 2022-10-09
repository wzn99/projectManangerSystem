package com.pojo;

public class Project_Report {
    private Integer teams_tid;
    private Integer projects_pid;
    private String report_content;

    private String synthetic_review;
    public Project_Report() {
    }

    public Project_Report(Integer teams_tid, Integer projects_pid, String report_content) {
        this.teams_tid = teams_tid;
        this.projects_pid = projects_pid;
        this.report_content = report_content;
    }

    public Integer getTeams_tid() {
        return teams_tid;
    }

    public void setTeamsTid(Integer teams_tid) {
        this.teams_tid = teams_tid;
    }

    public Integer getProjects_pid() {
        return projects_pid;
    }

    public void setProjectsPid(Integer projects_pid) {
        this.projects_pid = projects_pid;
    }

    public String getReport_content() {
        return report_content;
    }

    public void setReportContent(String report_content) {
        this.report_content = report_content;
    }

    public String getSyntheticReview() {
        return synthetic_review;
    }

    public void setSyntheticReview(String synthetic_review) {
        this.synthetic_review = synthetic_review;
    }


    @Override
    public String toString() {
        return "Project_Reports [teams_tid=" + teams_tid + ", projects_pid=" + projects_pid + ", report_content="
                + report_content + "]";
    }
}
