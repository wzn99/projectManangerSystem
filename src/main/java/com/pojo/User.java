package com.pojo;

public class User {
    private Integer uid;

    private String name;
    private String telephone_number;
    private String email;
    private String password;
    private String role;
    private Integer teams_tid;

    public User() {
    }

    public User(Integer uid, String name, String telephone_number, String email, String password, String role, Integer teams_tid) {
        this.uid = uid;
        this.name = name;
        this.telephone_number = telephone_number;
        this.email = email;
        this.password = password;
        this.role = role;
        this.teams_tid = teams_tid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone_number() {
        return telephone_number;
    }

    public void setTelephone_number(String telephone_number) {
        this.telephone_number = telephone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getTeams_tid() {
        return teams_tid;
    }

    public void setTeams_tid(Integer teams_tid) {
        this.teams_tid = teams_tid;
    }

    @Override
    public String toString() {
        return "UID [uid=" + uid + ", telephone_number=" + telephone_number + ", email=" + email + ", password="
                + password + ", role=" + role + ", teams_tid=" + teams_tid + "]";
    }

}
