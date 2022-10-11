package com.mapper;

import com.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

public interface Can_ReviewMapper {

    @Select("select can_review from can_review where teacher_uid=#{teacher_uid} and project_pid=#{project_pid}")
    @ResultType(String.class)
    public String canReview(@Param("teacher_uid") Integer teacher_uid,@Param("project_pid") Integer project_uid);
}
