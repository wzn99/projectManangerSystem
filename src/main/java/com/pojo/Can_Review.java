package com.pojo;

public class Can_Review {
	private String can_review;
	private Integer teacher_uid;
	private Integer project_pid;

	public String getCan_review() {
		return can_review;
	}

	public void setCan_review(String can_review) {
		this.can_review = can_review;
	}

	public Integer getTeacher_uid() {
		return teacher_uid;
	}

	public void setTeacher_uid(Integer teacher_uid) {
		this.teacher_uid = teacher_uid;
	}

	public Integer getProject_pid() {
		return project_pid;
	}

	public void setProject_pid(Integer project_pid) {
		this.project_pid = project_pid;
	}

	@Override
	public String toString() {
		return "Can_Review [can_review=" + can_review + ", teacher_uid=" + teacher_uid + ", project_pid=" + project_pid
				+ "]";
	}
}
