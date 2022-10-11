package com.mapper;

import com.pojo.Teacher_Review;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface Teacher_ReviewMapper {

    /**
     * 获取某位导师在某期项目中所有暂存的评审
     */
    @Select("select * from teacher_review where project_pid=#{project_pid} " +
            "and teacher_uid=#{teacher_uid}")
    @ResultType(Teacher_Review.class)
    public List<Teacher_Review> getTempReview(@Param("teacher_uid") Integer teacher_uid,
                                              @Param("project_pid") Integer project_pid);

    //判断导师对报告的评审是否提交
    @Select("select submitted from teacher_review where " +
            "teacher_uid=#{teacher_uid} and project_pid=#{project_pid} and team_tid=#{team_tid}")
    public String isReviewSumitted(@Param("teacher_uid") Integer teacher_uid,@Param("project_pid") Integer project_pid,@Param("team_tid") Integer team_tid);

    //暂存评审
    @Insert("insert into teacher_review (teacher_uid, team_tid, project_pid, review, score) " +
            "values (#{teacher_uid,},#{team_tid}#{project_pid},#{review},#{score},#{submitted})")
    public int saveReview(@Param("teacher_uid,") Integer teacher_uid, @Param("team_tid")  Integer team_tid, @Param("project_pid") Integer project_pid,
                          @Param("review") String review,@Param("score") Integer score,@Param("submitted") String submitted);

    //提交评审
    @Update("update teacher_review " +
            "set review=#{review},score=#{score},submitted=#{submitted}" +
            " where teacher_uid=#{teacher_uid} and team_tid=#{team_tid} and project_pid=#{project_pid}")
    public int updateReview(@Param("teacher_uid") Integer teacher_uid, @Param("team_tid") Integer team_tid, @Param("project_pid") Integer project_pid,
                          @Param("review") String review,@Param("score") Integer score,@Param("submitted") String submitted);

    //查找某个导师对某个项目的某个组的报告的评审
    @Select("select * from teacher_review where teacher_uid=#{teacher_uid} and team_tid=#{team_tid} and project_pid=#{project_pid}")
    @ResultType(Teacher_Review.class)
    public Teacher_Review getReview(@Param("teacher_uid") Integer teacher_uid,
                                    @Param("team_tid") Integer team_tid, @Param("project_pid") Integer project_pid);
}
