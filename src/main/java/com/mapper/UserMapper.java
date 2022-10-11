package com.mapper;

import com.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    /*
    根据id和密码查找导师
     */
    @Select("select * from users where uid=#{uid} and password=#{password} and role = 'teacher'")
    @ResultType(User.class)
    public User getTeacherByUid(@Param("uid") int uid, @Param("password") String password);
}
