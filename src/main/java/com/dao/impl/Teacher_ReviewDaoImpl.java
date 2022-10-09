package com.dao.impl;

import com.dao.Teacher_ReviewDao;
import com.pojo.Teacher_Review;
import com.dao.base.BaseDao;

import java.util.List;

public class Teacher_ReviewDaoImpl extends BaseDao<Teacher_Review> implements Teacher_ReviewDao {
    @Override
    public int saveReview(Integer teacher_uid, Integer team_tid,
                           Integer project_pid, String review, Integer score, String submitted) {
        Integer i=super.executeUpdate("INSERT into teacher_review" +
                        " values(?,?,?,?,?,?)"
                ,teacher_uid,team_tid,project_pid,review,score,submitted);
        return i;
    }

    @Override
    public int updateReview(Integer teacher_uid, Integer team_tid, Integer project_pid, Integer score, String review,String submitted) {
        Integer i=super.executeUpdate(
          "update teacher_review set submitted=?,score=?,review=? where" +
                  " teacher_uid=? and team_tid=? and project_pid=?",
                 submitted,score,review,teacher_uid,team_tid,project_pid);
        return i;
    }

    @Override
    public List<Teacher_Review> getTempReview(Integer teacher_uid, Integer project_pid) {
        List<Teacher_Review> tempReviews = super.executeQuery(
          "select*from teacher_review where submitted='no' and " +
                  "teacher_uid=? and project_pid=?",teacher_uid,project_pid);
        return tempReviews;
    }

    @Override
    public boolean isReviewExist(Integer teacher_uid, Integer team_tid, Integer project_pid) {
        Teacher_Review teacher_review = super.load(
                "select*from teacher_review where teacher_uid=? and team_tid=? and project_pid=?"
        ,teacher_uid,team_tid,project_pid);
        if(teacher_review!=null)return true;
        return false;
    }

    @Override
    public boolean is_submitted(Integer teacher_uid, Integer project_pid, Integer team_tid) {
        Teacher_Review teacher_review = super.load(
                "select*from teacher_review where submitted='yes'" +
                        " and teacher_uid=? and project_pid=? and team_tid=?",
                teacher_uid,project_pid,team_tid);
        if (teacher_review!=null)return true;
        return false;
    }

	@Override
	public List<Teacher_Review> ReadView(Integer team_tid, Integer project_pid) {
		return super.executeQuery("select * from Teacher_Review where team_tid=? and project_pid =?",
				team_tid,project_pid);
	}
}
