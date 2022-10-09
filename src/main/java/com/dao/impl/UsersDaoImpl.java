package com.dao.impl;

import java.util.List;

import com.dao.UsersDao;
import com.dao.base.BaseDao;
import com.pojo.User;

public class UsersDaoImpl extends BaseDao<User> implements UsersDao {
    @Override
    public User getUserByLogin(String email, String password) {
        User user = super.load(
                "select * from users where email like ? and password like ?",
                email,
                password);
        return user;
    }

    @Override
    public User getUserByEmail(String email) {
        User user = super.load(
                "select * from users where email like ?",
                email
        );
        return user;
    }

    @Override
    public int setUserMessage(User user) {
        return super.executeUpdate("update users set telephone_number = ?, email = ?, password = ? where uid = ?",
                user.getTelephone_number(), user.getEmail(), user.getPassword(), user.getUid());
    }


	@Override
	public User getTeacherByUid(int uid,String password) {
		User user = super.load(
				"select * from users where uid =? and password=? and role = 'teacher'",
				uid,password);
		return user;
	}

	@Override
	public boolean newUser(Integer uid, String name, String telephone_number, String email, String password, String role,
			Integer teams_tid) {
		if(super.executeUpdate("insert into Users values(?,?,?,?,?,?,?)", uid,name,telephone_number,email,password
				,role,teams_tid)>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean changeUser(Integer uid, String name, String telephone_number, String email, String password, String role,
			Integer teams_tid) {
		if(super.executeUpdate("update users set name=?, telephone_number=?,email=?,password=?,role=?,teams_tid=? where uid=?", name,telephone_number,email,password,role,teams_tid,uid)>0)
			return true;
		return false;
	}

	@Override
	public boolean deleteUser(Integer uid) {
		if(super.executeUpdate("delete from users where uid = ?", uid)>0)
			return true;
		return false;
	}

	@Override
	public List<User> Show() {
		
		return super.executeQuery("select * from Users");
	}

	@Override
	public User getByUid(Integer uid) {
		User user = super.load("select * from users where uid = ?", uid);
		return user;
	}

	@Override
	public List<User> ShowByRole(String role) {
		return super.executeQuery("select * from Users where role = ?",role);
	}
}
