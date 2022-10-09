package com.pojo;

public class Team {
    private Integer tid;
    private String name;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Teams [tid=" + tid + ", synthetical_review=" + name + "]";
    }
}
