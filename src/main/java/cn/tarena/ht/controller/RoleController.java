package cn.tarena.ht.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.tarena.ht.pojo.Module;
import cn.tarena.ht.pojo.Role;
import cn.tarena.ht.service.ModuleService;
import cn.tarena.ht.service.RoleService;

@Controller
@RequestMapping("/sysadmin/role/")
public class RoleController extends BaseController{

	@Resource
	private RoleService roleService;

	
	@RequestMapping("list")
	public String toRoleList(Model model){
		//准备角色数据
		List<Role> roleList = roleService.findRoleList();
		model.addAttribute("roleList", roleList);
		return "sysadmin/role/jRoleList";
	}
	
	@RequestMapping("tocreate")
	public String toCreate(){
		return "sysadmin/role/jCreateRole";
	}
	
	@RequestMapping("saveRole")
	public String saveRole(Role role){
		roleService.saveRole(role);
		return "redirect:list";
	}
	
	//删除角色
	@RequestMapping("delete")
	public String toDeleteRole(@RequestParam("roleId")String [] roleIds){
		roleService.deleteRoles(roleIds);
		return "redirect:list";
	}
	
	//更新角色
	@RequestMapping("toupdate")
	public String toUpdateRole(String roleId,Model model){
		//准备哟啊修改的id
		Role role= roleService.findRoleById(roleId);
		model.addAttribute("role", role);
		return "sysadmin/role/jUpdateRole";
		
	}
	
	//保存更新
	@RequestMapping("updateRole")
	public String updateRole(Role role,Model model){
		roleService.updateRole(role);
		model.addAttribute("role", role);
		return "redirect:list";
	}
	
	//查看
	@RequestMapping("toview")
	public String toViewRole(String roleId , Model model){
		Role role = roleService.findRoleOne(roleId);
		model.addAttribute("role", role);
		return "sysadmin/role/jViewRole";
	}
	
	/**
	 * 给角色添加相应的权限 根据角色id选择角色 根据权限ids去赋予角色相应的多种权限
	 * @param roleId 角色id ：选定角色
	 * @param moduleIds 权限ids ： 获取已有的权限树
	 * @param model 向页面传值
	 * @return 
	 * @throws JsonProcessingException
	 */
	@RequestMapping("toRoleModule")
	public String toRoleModule(String roleId,String[] moduleIds,Model model) throws JsonProcessingException{
		//准备权限数据 列表
		List<Module> moduleList = roleService.findModuleList();
		
		/*
		 * 重新进入角色权限页面时回显已有的权限
		 */
		//获取角色上已有的权限的id
		List<String> roleMIdList = roleService.findModuleByRole(roleId);
		//获取 遍历权限列表
		for (Module module : moduleList) {
			//判断角色中是否包含此权限  包含则将checked设置为true
			
			System.out.println(module);
			if(roleMIdList.contains(module.getModuleId())){
				module.setChecked("true");
			}
		}
		
		
		//将权限数据转换为json串 传入页面
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(moduleList);
		model.addAttribute("json", json);
		model.addAttribute("roleId", roleId);
		return "sysadmin/role/jRoleModule";
	}
	
	/**
	 * 向角色页面保存添加上的权限
	 * @param roleId 指定角色的id
	 * @param moduleIds 选中的权限ids
	 * @return 
	 */
	@RequestMapping("saveRoleModule")
	public String toSaveRoleModule(String roleId , String[] moduleIds){
		
		roleService.saveRoleModule(roleId,moduleIds);
		return "redirect:list";
	}
}
