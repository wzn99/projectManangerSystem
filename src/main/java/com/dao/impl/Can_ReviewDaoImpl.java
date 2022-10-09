package com.dao.impl;

import java.util.List;

import com.dao.Can_ReviewDao;
import com.pojo.Can_Review;
import com.dao.base.BaseDao;

public class Can_ReviewDaoImpl extends BaseDao<Can_Review> implements Can_ReviewDao {

    @Override
    public boolean canReview(Integer teacher_uid, Integer project_uid) {
        Can_Review can_review=super.load("select*from can_review where" +
                " can_review='yes' and teacher_uid=? and project_pid=? ",teacher_uid,project_uid);
        if(can_review!=null)return true;
        return false;
    }

	@Override
	public boolean ChangeView(String can_review,Integer teacher_uid, Integer project_pid) {
		if(super.executeUpdate("update Can_Review set can_review = ? where teacher_uid = ? and project_pid= ?",
				can_review,teacher_uid,project_pid)>0)
			return true;
		return false;
	}

	@Override
	public Can_Review GetByuidAndpid(Integer teacher_uid, Integer project_pid) {
		return super.load("select * from Can_Review where teacher_uid = ? and project_pid = ?",teacher_uid,project_pid);
	}

	@Override
	public boolean AddView(String can_review, Integer teacher_uid, Integer project_pid) {
		if(super.executeUpdate("insert into Can_Review values(?,?,?)", can_review,teacher_uid,project_pid)>0) {
			return true;
		}
		return false;
	}

	@Override
	public List<Can_Review> GetBypid(Integer project_pid) {
		return super.executeQuery("select * from Can_Review where project_pid = ?",project_pid);
	}
}
