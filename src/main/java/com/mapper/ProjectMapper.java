package com.mapper;

public interface ProjectMapper {

    /**
     * 根据项目的pid获取项目的content
     * @param pid
     * @return 对应的Projects的content
     */
    public String getProjectByPid(Integer pid);
}
