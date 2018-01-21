package cn.ragd.web.formbean;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

//用户注册提交的表单bean
public class RegisterForm {

	private String username;
	private String password;
	private String password2;
	private String email;
	private String phonenumber;
	private String verifycode;
	private Map errors = new HashMap();
	
	public Map getErrors() {
		return errors;
	}
	public void setErrors(Map errors) {
		this.errors = errors;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getVerifycode() {
		return verifycode;
	}
	public void setVerifycode(String verifycode) {
		this.verifycode = verifycode;
	}
	
	//验证用户提交表单的合法性
	public boolean validate() {
		boolean isOK = true;
		
		if(this.username==null || this.username.trim().equals("")) {
			isOK = false;
			errors.put("username", "用户名不能为空！");
		} else {
			if(!this.username.matches("[A-Za-z]{3,8}")) {
				isOK = false;
				errors.put("username", "用户名必须是3-8位字母！");
			}
		}
		
		if(this.password==null || this.password.trim().equals("")) {
			isOK = false;
			errors.put("password", "密码不能为空！");
		} else {
			if(!this.password.matches("\\d{3,8}")) {
				isOK = false;
				errors.put("password", "密码必须是3-8位数字！");
			}
		}
		
		if(this.password2==null || this.password2.trim().equals("")) {
			isOK = false;
			errors.put("password2", "确认密码不能为空！");
		} else {
			if(!this.password.equals(this.password2)) {
				isOK = false;
				errors.put("password2", "两次密码要一致！");
			}
		}
		
		if(this.email==null || this.email.trim().equals("")) {
			isOK = false;
			errors.put("email", "邮箱不能为空！");
		} else {
			if(!this.email.matches("\\w+@\\w+(\\.\\w+)+")) {
				isOK = false;
				errors.put("email", "邮箱格式不对！");
			}
		}
		
		if(this.phonenumber==null || this.phonenumber.trim().equals("")) {
			isOK = false;
			errors.put("phonenumber", "电话号码不能为空！");
		}
		
		return isOK;
	}
	
	//验证用户填写的验证码是否正确
	public boolean testVcode(String sessionVcode) {
		boolean isOK = true;
		if(this.verifycode==null || this.verifycode.trim().equals("")) {
			isOK = false;
			errors.put("verifycode", "验证码不能为空！");
		} else {
			if(!(this.verifycode.equals(sessionVcode))) {
				isOK = false;
				errors.put("verifycode", "验证码不匹配！(区分大小写)");
			}
		}
		
		return isOK;
	}
}
