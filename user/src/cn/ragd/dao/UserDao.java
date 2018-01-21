package cn.ragd.dao;

import cn.ragd.domain.User;

public interface UserDao {

	//向数据库中增加用户
	void add(User user);

	//从数据库中，根据用户名和密码，查找用户
	User find(String username, String password);

	//查找注册的用户是否在数据库中存在
	boolean find(String username);

}