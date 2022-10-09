package com.dao;

import com.pojo.Teacher_Review;
import java.util.List;

/**
 * 执行Teacher_Review表相关的增删改查操作
 */
public interface Teacher_ReviewDao {

    /**
     * 新增记录，保存导师的评审内容
     * @param teacher_uid
     * @param team_tid
     * @param project_pid
     * @param review
     * @param score
     * @param submitted
     * @return 影响的行数
     */
    public int saveReview(Integer teacher_uid, Integer team_tid,Integer project_pid,
                          String review,Integer score,String submitted);

    /**
     * 更新记录，保存导师的评审内容
     * @param teacher_uid
     * @param team_tid
     * @param project_pid
     * @param score
     * @param review
     * @param submitted
     * @return 影响的行数
     */
    public int updateReview(Integer teacher_uid,Integer team_tid,Integer project_pid,Integer score,String review,String submitted);


    /**
     * 获取某位导师在某期项目中暂存的评审
     * @param teacher_uid
     * @param project_pid
     * @return
     */
    public List<Teacher_Review> getTempReview(Integer teacher_uid,Integer project_pid);


    /**
     * 判断某条评审记录是否已经存在
     * @param teacher_uid
     * @param team_tid
     * @param project_pid
     * @return 若已经存在则返回true，否则返回false
     */
    public boolean isReviewExist(Integer teacher_uid,Integer team_tid,Integer project_pid);


    /**
     * 判断某个导师对某个项目的某个组的评审是否已经提交
     * @param teacher_uid
     * @param project_pid
     * @param team_tid
     * @return 已提交则返回true,否则返回false
     */
    public boolean is_submitted(Integer teacher_uid,Integer project_pid,Integer team_tid);
    
	//根据团队号，项目号返回评审意见
	public List<Teacher_Review> ReadView(Integer team_tid,Integer project_pid);

}
