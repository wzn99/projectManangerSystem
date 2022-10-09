package com.dao;

import java.util.List;

import com.pojo.Can_Review;

/**
 * 执行Can_Review表相关的增删改查操作
 */
public interface Can_ReviewDao {

    /**
     * 判断某个导师是否拥有评审某个项目的权限
     * @param teacher_uid
     * @param project_uid
     * @return 如果有评审权限则返回true，否则返回false
     */
    public boolean canReview(Integer teacher_uid,Integer project_uid);
    
	//传入老师和项目号，修改can_review值
	public boolean ChangeView(String can_review,Integer teacher_uid,Integer project_pid);
	//传入老师和项目号，查询结果
	public Can_Review GetByuidAndpid(Integer teacher_uid,Integer project_pid);
	//传入老师号和项目号，增加权限
	public boolean AddView(String can_review,Integer teacher_uid,Integer project_pid);
	//传入项目号，获得该项目所有权限
	public List<Can_Review> GetBypid(Integer project_pid);
}
