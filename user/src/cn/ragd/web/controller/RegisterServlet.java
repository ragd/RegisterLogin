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

//����ע������
public class RegisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		
		//1.���ύ�����ֶν��кϷ���У��(�ѱ����ݷ�װ��formbean)
		RegisterForm form = WebUtils.request2Bean(request, RegisterForm.class);
		boolean b = form.validate();
		
		//��ȡsession�е���֤�룬��У���Ƿ���ȷ
		String sessionVcode = (String)request.getSession().getAttribute("vcode");
		b = form.testVcode(sessionVcode);
		
		//2.���У��ʧ�ܣ����ص���ҳ�棬����У��ʧ����Ϣ
		if(!b){
			//��������Ϣ�浽form���У�����ע��ҳ����
			request.setAttribute("form", form);
			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
			return;
		}
		
		//3.���У��ɹ��������service����ע������
		User user = new User();
		WebUtils.copyBean(form, user);
		
		//��spring�����õ�service
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("bean.xml");
		BusinessServiceImpl service = (BusinessServiceImpl) context.getBean("service");
		
		try {
			service.register(user);
			//6.���service����ɹ�������ת��ȫ����Ϣ��ʾҳ�棬��ʾ�ɹ�ע����Ϣ��������6�����ת����ҳ
			request.setAttribute("message", "��ϲ����ע��ɹ������������6�����ת����<meta http-equiv='refresh' content='6;url="+request.getContextPath()+"/index.jsp'>");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		} catch (UserExistException e) {
			//4.���service�����ɹ�����������Ϊע���û��Ѵ��ڣ������ص�ע��ҳ�棬��ʾע���û��Ѵ��ڵ���Ϣ
			form.getErrors().put("username", "ע����û��Ѵ��ڣ�");
			request.setAttribute("form", form);
			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
			return;
		} catch (Exception e) {
			//5.���service�����ɹ�����������Ϊ�������⣬����ת����վ��ȫ����Ϣ��ʾҳ��
			e.printStackTrace();
			request.setAttribute("message", "����������δ֪����");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
