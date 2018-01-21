package cn.ragd.service.impl;

import cn.ragd.dao.UserDao;
import cn.ragd.domain.User;
import cn.ragd.exception.UserExistException;
import cn.ragd.utils.ServiceUtils;

//对web层提供所有的业务服务
public class BusinessServiceImpl {

	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	//对web层提供注册服务
	public void register(User user) throws UserExistException {
		
		//调用UserDaoImpl中的find方法，看新增用户是否已存在
		boolean b = userDao.find(user.getUsername());
		if(b) {
			throw new UserExistException();
		} else {
			user.setPassword(ServiceUtils.md5(user.getPassword()));
			//调用UserDaoImpl中的add方法，新增用户
			userDao.add(user);
		}
	}
	
	//对web层提供登陆服务
	public User login(String username, String password) {
		
		password = ServiceUtils.md5(password);
		//调用UserDaoImpl中的find方法，看用户是否已注册
		return userDao.find(username, password);
	}
}
