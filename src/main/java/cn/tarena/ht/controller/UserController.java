package cn.tarena.ht.controller;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.tarena.ht.pojo.Dept;
import cn.tarena.ht.pojo.Role;
import cn.tarena.ht.pojo.User;
import cn.tarena.ht.pojo.UserInfo;
import cn.tarena.ht.service.UserService;
import cn.tarena.ht.tool.MD5Hash;

@Controller
@RequestMapping("/sysadmin/user/")
public class UserController extends BaseController{//继承 绑定日期格式

	@Resource
	private UserService userService;
	
	//查看用户信息
	@RequestMapping("list")
	public String toUserList(Model model){
		List<User> userList = userService.findUserList();
		System.out.println(userList);
		model.addAttribute("userList", userList);
		return "sysadmin/user/jUserList";
	}
	
	//改变状态 启用
	@RequestMapping("start")
	public String toStart(@RequestParam("userId")String[] userIds){
		userService.updateState(userIds,1);
		return "redirect:list";
	}
	
	//改变状态 停用
	@RequestMapping("stop")
	public String toStop(@RequestParam("userId")String[] userIds){
		userService.updateState(userIds,0);
		return "redirect:list";
	}
	
	//删除用户
	@RequestMapping("delete")
	public String toDelete(@RequestParam("userId")String[] userIds){
		userService.deleteUsers(userIds);
		return "redirect:list";
	}
	
	//新增用户
	@RequestMapping("tocreate")
	public String toCreate(Model model){
		/*
		 * 下拉列表：
		 * 需要信息---部门的信息（ID 名称）
		 * ---上级领导 领导的姓名 id
		 * ---用户级别
		 */
		//1、准备部门的下拉列表
		List<Dept> deptList = userService.findDeptList();
		//2、准备上级领导的下拉列表
		List<UserInfo> managerList = userService.findManagerList();
		model.addAttribute("deptList", deptList);
		model.addAttribute("managerList", managerList);
		return "sysadmin/user/jUserCreate";
	}
	
	//保存新增用户
	@RequestMapping("saveUser")
	public String toSaveUser(User user){
//		保存用户信息 ---user_p
		//用户id任意生成
		String uuid = UUID.randomUUID().toString();
		user.setUserId(uuid);
		UserInfo userInfo = user.getUserInfo();
		userInfo.setUserInfoId(uuid);
		
		//用户密码加密
		String username = user.getUsername();
		String password = user.getPassword();
		//密文密码
		String md5Hash = MD5Hash.getMD5Hash(password, username);
		user.setPassword(md5Hash);
		
		userService.saveUser(user);
		userService.saveUserInfo(userInfo);
		return "redirect:list";
	}
	
	//修改用户信息
	@RequestMapping("toupdate")
	public String toUpdateUser(String userId , Model model){
		User user = userService.findUserOne(userId);
		//1、准备部门的下拉列表
		List<Dept> deptList = userService.findDeptList();
		//2、准备上级领导的下拉列表
		List<UserInfo> managerList = userService.findManagerList();
		model.addAttribute("user", user);
		model.addAttribute("deptList", deptList);
		model.addAttribute("managerList", managerList);
		return "sysadmin/user/jUpdateUser";
	}
	//保存更改信息
	@RequestMapping("updateUser")
	public String updateUser(User user){
		userService.updateUser(user);
		
		UserInfo userInfo =  user.getUserInfo();
		userInfo.setUserInfoId(user.getUserId());
		
		userService.updateUserInfo(userInfo);
		
		return "redirect: list";
	}
	//查看用户信息
	@RequestMapping("toview")
	public String toViewUser(String userId , Model model){
		User user = userService.findUserOne(userId);
		model.addAttribute("user", user);
		return "sysadmin/user/jViewUser";
	}
	
	//转向角色页面
	@RequestMapping("toUserRole")
	public String toUserRole(String userId,Model model) throws JsonProcessingException{
		//准备的参数 -- 角色的信息--从数据库中查询
		List<Role> roleList = userService.findRoleList();
		
		//用字符串 接受根据userId查找当前的用户的角色id
		List<String> userRIdList = userService.findRoleByUserId(userId);
		//遍历角色列表
		for (Role role : roleList) {
			//判断用户已有的角色id中是否有此角色
			if(userRIdList.contains(role.getRoleId())){
				//有，则将此项的checked属性设置为true
				role.setChecked("true");
			}
		}
		
		//将转换String序列化为一个json串
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(roleList);
		model.addAttribute("json", json);
		model.addAttribute("userId", userId);
		
		return "sysadmin/user/jUserRole";
	}
	
	@RequestMapping("saveUserRole")
	public String saveUserRole(String userId,String[] roleIds){
		userService.saveUserRole(userId,roleIds);
		System.out.println(userId+""+roleIds);
		return "redirect:list";
	}

}
