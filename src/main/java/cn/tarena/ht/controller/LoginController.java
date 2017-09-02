package cn.tarena.ht.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mysql.jdbc.StringUtils;

import cn.tarena.ht.pojo.User;
import cn.tarena.ht.service.UserService;

@Controller
public class LoginController extends BaseController{

	@Resource
	private UserService userService;
	
	@RequestMapping("/validate/doLogin")
	public String doLogin(String username , String password,HttpSession session){
		/**
		 * isNullOrEmpty 如果数据为“”或者为null 则为true
		 */
		if(StringUtils.isNullOrEmpty(username)||StringUtils.isNullOrEmpty(password)){
			//用session域向页面传值
			session.setAttribute("loginFailed", 2);
			return "forward:/login.jsp";
		}
		/**
		 * 登陆的实现方式
		 * 1、通过用户传入的username查询数据库 看是否有当前用户
		 * 2、通过用户传入的password与查询回来的user的password进行比较
		
		User user = userService.findUserByUserName(username);
		if(user != null && password.equals(user.getPassword())){
			return "redirect:/index.jsp";
		}
		 */
		
		/**
		 * 使用shiro来实现登陆校验
		 */
		//令牌
		UsernamePasswordToken token = new UsernamePasswordToken(username, password); 
		//请求的对象
		Subject subject = SecurityUtils.getSubject();
		try {
			//调用shiro的登陆验证 将令牌传入
			subject.login(token);
			//用session域传递用户名
			subject.getSession().setAttribute("username", username);
			return "redirect:/index.jsp";			
		} catch (Exception e) {
			session.setAttribute("loginFailed", 1);
			return "forward:/login.jsp";
		}
		
	}
	
}
