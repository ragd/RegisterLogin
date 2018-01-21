package cn.ragd.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.ragd.domain.User;
import cn.ragd.service.impl.BusinessServiceImpl;

//�����½����
public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//��ȡ���ύ���û���������
		String username = request.getParameter("username");
		String password = request.getParameter("password");
				
		//��spring�����õ�service
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("bean.xml");
		BusinessServiceImpl service = (BusinessServiceImpl) context.getBean("service");
		
		User user = service.login(username, password);
		if(user!=null){
			request.getSession().setAttribute("user", user);
			//���û���½�ɹ�����ת��ҳ
			response.sendRedirect(request.getContextPath() + "/index.jsp");
			return;
		}
				
		request.setAttribute("message", "�û�����������󣡣�");
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
