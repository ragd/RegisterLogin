package cn.ragd.utils;

import java.util.Enumeration;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class WebUtils {
	
	//将request中的数据封装到bean中                                                                                                   // RegisterForm.class
	public static <T> T request2Bean(HttpServletRequest request, Class<T> beanClass) {
		
		try{
			//1.创建要封装数据的bean
			T bean = beanClass.newInstance();
			
			//2.把request中的数据整到bean中
			Enumeration enu = request.getParameterNames();
			while(enu.hasMoreElements()){
				String name = (String) enu.nextElement();  //username password email phonenumber verifycode
				String value = request.getParameter(name);
				BeanUtils.setProperty(bean, name, value);
			}
			return bean;
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void copyBean(Object src, Object dest){
		try {
			BeanUtils.copyProperties(dest, src);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
