package cn.ragd.dao.impl;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import cn.ragd.dao.impl.MyRowMapper;
import cn.ragd.dao.UserDao;
import cn.ragd.domain.User;

public class UserDaoImpl implements UserDao {

	//�õ�JdbcTemplate����
	private JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	//�����ݿ��������û�
	public void add(User user) {
		try {
			String sql = "insert into user values(?,?,?,?)";
			jdbcTemplate.update(sql,user.getUsername(),user.getPassword(),user.getEmail(),user.getPhonenumber());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	//�����ݿ��У������û��������룬�����û�
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
	
	//����ע����û��Ƿ������ݿ��д���
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
