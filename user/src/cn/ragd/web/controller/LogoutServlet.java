package cn.ragd.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//处理注销请求
public class LogoutServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//获取内存中的session
		HttpSession session = request.getSession(false);
		if(session!=null){
			//移除登陆标记
			session.removeAttribute("user");
		}
		
		//注销成功，跳转到全局消息显示页面，显示注销成功消息，并控制消息显示页面超过6秒后跳转到首页
		request.setAttribute("message", "注销成功，浏览器将在6秒后跳转！！<meta http-equiv='refresh' content='6;url="+request.getContextPath()+"/index.jsp'>");
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
