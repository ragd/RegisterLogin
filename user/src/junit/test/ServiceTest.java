package junit.test;

import java.util.Date;

import org.junit.Test;

import cn.ragd.domain.User;
import cn.ragd.exception.UserExistException;
import cn.ragd.service.impl.BusinessServiceImpl;

public class ServiceTest {

	/*@Test
	public void testRegister() {
		User user = new User();
		user.setUsername("gggg");
		user.setPassword("123");
		user.setEmail("bb@sina.com");
		user.setPhonenumber("18843153353");
		
		BusinessServiceImpl service = new BusinessServiceImpl();
		try {
			service.register(user);
			System.out.println("注册成功");
		} catch (UserExistException e) {
			System.out.println("用户已存在");
		}
	}*/
	
	@Test
	public void testLogin() {
		BusinessServiceImpl service = new BusinessServiceImpl();
		User user = service.login("gggg", "123");
		System.out.println(user);
	}
}
