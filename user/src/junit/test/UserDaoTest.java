package junit.test;

import org.junit.Test;

import cn.ragd.dao.UserDao;
import cn.ragd.dao.impl.UserDaoImpl;
import cn.ragd.domain.User;

public class UserDaoTest {

	/*@Test
	public void testAdd() {
		User user = new User();
		user.setEmail("bb@sina.com");
		user.setPassword("123");
		user.setUsername("bbbb");
		user.setPhonenumber("18843153353");
			
		UserDaoImpl dao = new UserDaoImpl();
		dao.add(user);
	}*/
	
	@Test
	public void testFindByUsername() {
		UserDao dao = new UserDaoImpl();
		System.out.println(dao.find("bbbb"));
	}
}
