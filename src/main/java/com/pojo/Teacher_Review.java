package com.pojo;

public class Teacher_Review {
    private Integer teacher_uid;
    private Integer team_tid;
    private Integer project_pid;
    private String review;
    private Integer score;
    private String submitted;

    public Integer getTeacher_uid() {
        return teacher_uid;
    }

    public void setTeacher_uid(Integer teacher_uid) {
        this.teacher_uid = teacher_uid;
    }

    public Integer getTeam_tid() {
        return team_tid;
    }

    public void setTeam_tid(Integer team_tid) {
        this.team_tid = team_tid;
    }

    public Integer getProject_pid() {
        return project_pid;
    }

    public void setProject_pid(Integer project_pid) {
        this.project_pid = project_pid;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getSubmitted() {
        return submitted;
    }

    public void setSubmitted(String submitted) {
        this.submitted = submitted;
    }

    @Override
    public String toString() {
        return "Teacher_Review [teacher_uid=" + teacher_uid + ", team_tid=" + team_tid + ", project_pid=" + project_pid
                + ", review=" + review + "]";
    }
}
