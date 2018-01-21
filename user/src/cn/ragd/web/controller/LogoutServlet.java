package cn.ragd.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//����ע������
public class LogoutServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//��ȡ�ڴ��е�session
		HttpSession session = request.getSession(false);
		if(session!=null){
			//�Ƴ���½���
			session.removeAttribute("user");
		}
		
		//ע���ɹ�����ת��ȫ����Ϣ��ʾҳ�棬��ʾע���ɹ���Ϣ����������Ϣ��ʾҳ�泬��6�����ת����ҳ
		request.setAttribute("message", "ע���ɹ������������6�����ת����<meta http-equiv='refresh' content='6;url="+request.getContextPath()+"/index.jsp'>");
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
