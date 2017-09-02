package cn.tarena.ht.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	

	//转向欢迎页面
	@RequestMapping("/home")
	public String home(){
		return "/home/fmain";
	}
	
	//转向tilte标题栏页面
	@RequestMapping("/title")
	public String title(){
		return "/home/title";
	}
	
	/*
	 * 实现动态转向
	 * restFul结构 {moduleName}/Left 注解：@PathVariable
	 * 页面与controller之间传递的参数： {moduleName}
	 * 优点：不必写多个转向页面的方法
	 */
	
	//动态的左侧页面
	@RequestMapping("{moduleName}/Left") 
	public String homeLeft(@PathVariable String moduleName){
		return "/"+moduleName+"/left";
	}
	
	//动态的操作页面
	@RequestMapping("{moduleName}/Main")
	public String homeMain(@PathVariable String moduleName){
		return "/"+moduleName+"/main";
	}
	

}
