package cn.ragd.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cn.ragd.domain.User;

public class MyRowMapper implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet rs, int num) throws SQLException {
		//从结果集里面得到数据
		String username = rs.getString("username");
		String password = rs.getString("password");
		String email = rs.getString("email");
		String phonenumber = rs.getString("phonenumber");
		
		//把得到的数据封装到对象里面
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		user.setPhonenumber(phonenumber);
		
		return user;
	}
	
}
