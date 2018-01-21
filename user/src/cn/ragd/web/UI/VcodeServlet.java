package cn.ragd.web.UI;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.ragd.utils.VerifyCode;

public class VcodeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		VerifyCode verifyCode = new VerifyCode();
        VerifyCode.output(verifyCode.getImage(),response.getOutputStream());//ʵ�����뿪ʼ���У��ڴ�֮ǰ��֤����δ���ɣ�ֵΪnull
        System.out.println("vcode_img "+verifyCode.getText()+"");
        request.getSession().setAttribute("vcode",verifyCode.getText());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

}
