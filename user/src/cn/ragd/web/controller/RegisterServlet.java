package cn.ragd.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.ragd.domain.User;
import cn.ragd.exception.UserExistException;
import cn.ragd.service.impl.BusinessServiceImpl;
import cn.ragd.utils.WebUtils;
import cn.ragd.web.formbean.RegisterForm;

//处理注册请求
public class RegisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		
		//1.对提交表单的字段进行合法性校验(把表单数据封装到formbean)
		RegisterForm form = WebUtils.request2Bean(request, RegisterForm.class);
		boolean b = form.validate();
		
		//获取session中的验证码，并校验是否正确
		String sessionVcode = (String)request.getSession().getAttribute("vcode");
		b = form.testVcode(sessionVcode);
		
		//2.如果校验失败，跳回到表单页面，回显校验失败信息
		if(!b){
			//将错误信息存到form域中，带到注册页面中
			request.setAttribute("form", form);
			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
			return;
		}
		
		//3.如果校验成功，则调用service处理注册请求
		User user = new User();
		WebUtils.copyBean(form, user);
		
		//用spring技术得到service
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("bean.xml");
		BusinessServiceImpl service = (BusinessServiceImpl) context.getBean("service");
		
		try {
			service.register(user);
			//6.如果service处理成功，则跳转到全局消息显示页面，显示成功注册消息；并且在6秒后跳转到首页
			request.setAttribute("message", "恭喜您，注册成功！浏览器将在6秒后跳转！！<meta http-equiv='refresh' content='6;url="+request.getContextPath()+"/index.jsp'>");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		} catch (UserExistException e) {
			//4.如果service处理不成功，并且是因为注册用户已存在，则跳回到注册页面，显示注册用户已存在的消息
			form.getErrors().put("username", "注册的用户已存在！");
			request.setAttribute("form", form);
			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
			return;
		} catch (Exception e) {
			//5.如果service处理不成功，并且是因为其他问题，则跳转到网站的全局消息显示页面
			e.printStackTrace();
			request.setAttribute("message", "服务器出现未知错误！");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
