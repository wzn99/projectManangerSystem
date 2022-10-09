package com.pojo;

public class Project {
    private Integer pid;
    private String content;
    private String can_submit;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCan_submit() {
        return can_submit;
    }

    public void setCan_submit(String can_submit) {
        this.can_submit = can_submit;
    }

    @Override
    public String toString() {
        return "Projects [pid=" + pid + ", content=" + content + ", can_submit=" + can_submit + "]";
    }
}
