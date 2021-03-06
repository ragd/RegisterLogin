package cn.ragd.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.ragd.domain.User;
import cn.ragd.service.impl.BusinessServiceImpl;

//处理登陆请求
public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//获取到提交的用户名和密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
				
		//用spring技术得到service
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("bean.xml");
		BusinessServiceImpl service = (BusinessServiceImpl) context.getBean("service");
		
		User user = service.login(username, password);
		if(user!=null){
			request.getSession().setAttribute("user", user);
			//让用户登陆成功后，跳转首页
			response.sendRedirect(request.getContextPath() + "/index.jsp");
			return;
		}
				
		request.setAttribute("message", "用户名或密码错误！！");
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
