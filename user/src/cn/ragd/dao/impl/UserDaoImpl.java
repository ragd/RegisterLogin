package cn.ragd.dao.impl;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import cn.ragd.dao.impl.MyRowMapper;
import cn.ragd.dao.UserDao;
import cn.ragd.domain.User;

public class UserDaoImpl implements UserDao {

	//得到JdbcTemplate对象
	private JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	//向数据库中增加用户
	public void add(User user) {
		try {
			String sql = "insert into user values(?,?,?,?)";
			jdbcTemplate.update(sql,user.getUsername(),user.getPassword(),user.getEmail(),user.getPhonenumber());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	//从数据库中，根据用户名和密码，查找用户
	public User find(String username, String password) {
		try {
			String sql = "select * from user where username=? and password=?";
			User user = jdbcTemplate.queryForObject(sql, new MyRowMapper(), username, password);
			if (user == null) {
				return null;
			}
			return user;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	//查找注册的用户是否在数据库中存在
	public boolean find(String username) {
			String sql = "select * from user where username=?";
			try {
				User user = jdbcTemplate.queryForObject(sql, new MyRowMapper(), username);
				if (user == null) {
					return false;
				}
				return true;
			} catch (EmptyResultDataAccessException e) {
				return false;
			}
	}
}
