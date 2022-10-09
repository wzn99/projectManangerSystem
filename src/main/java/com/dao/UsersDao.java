package com.dao;

import java.util.List;

import com.pojo.User;

/**
 * 执行User表相关的增删改查操作
 */
public interface UsersDao {
    /**
     * 根据输入的邮箱和密码获取登录的用户
     *
     * @param email    输入的邮箱
     * @param password 输入的密码
     * @return User        对应的{@link User}，若邮箱或密码错误则返回null
     */
    User getUserByLogin(String email, String password);

    /**
     * 根据email获取登陆的用户
     *
     * @param email 输入的邮箱
     * @return User        对应的{@link User}，若邮箱不存在则返回null
     */
    User getUserByEmail(String email);

    /**
     * 修改用户信息
     *
     * @param user 新的{@link User}用户
     * @return 若修改成功，返回1
     */
    int setUserMessage(User user);

	/**
	 * 根据id获取导师用户
	 * @param uid 导师的uid
	 * @param password 导师密码
	 * @return 对应的User，若该导师不存在则返回null
	 */
	public User getTeacherByUid(int uid,String password);
	
	//新增角色
	public boolean newUser(Integer uid, String name, String telephone_number, String email, String password, 
			               String role,
                           Integer teams_tid);
	//根据学生的uid修改角色信息
	public boolean changeUser(Integer uid, String name ,String telephone_number, String email, String password, 
            String role,
            Integer teams_tid);
	//根据学生的uid查询角色信息
	public User getByUid(Integer uid);
	//根据学生uid删除角色信息
	public boolean deleteUser(Integer uid);
	//展示用户所有信息，返回用户列表
	public List<User> Show();
	//展示特定用户的信息
	public List<User> ShowByRole(String role);
}
