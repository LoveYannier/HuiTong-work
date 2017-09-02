package cn.tarena.ht.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.tarena.ht.pojo.Module;
import cn.tarena.ht.service.ModuleService;

@Controller
@RequestMapping("/sysadmin/module/")
public class ModuleController extends BaseController{
	@Resource
	private ModuleService moduleService;

	//查看权限列表
	@RequestMapping("list")
	public String toModuleList(Model model){
		List<Module> moduleList = moduleService.findModuleList();
		model.addAttribute("moduleList", moduleList);
		return "sysadmin/module/jModuleList";
	}
	
//	//修改启用状态
//	@RequestMapping("stop")
//	public String toStop(@RequestParam("moduleId") Integer[] moduleIds){
//		moduleService.updateState(moduleIds,0);
//		return "redirect:list";
//	}
//	
//	@RequestMapping("start")
//	public String toStart(@RequestParam("moduleId") Integer[] moduleIds){
//		moduleService.updateState(moduleIds,1);
//		return "redirect:list";
//		
//	}
	
	//新增权限模块
	@RequestMapping("tocreate")
	public String toCreateModule(Model model){
//		准备下拉父级模块列表
		List<Module> moduleList = moduleService.findModuleList();
		model.addAttribute("moduleList", moduleList);
		return "sysadmin/module/jCreateModule";
	}
	
	@RequestMapping("saveModule")
	public String toSaveModule(Module module){
		moduleService.saveModule(module);
		return "redirect:list";
	}
	
	//删除权限模块
	@RequestMapping("delete")
	public String toDeleteModules(@RequestParam("moduleId")String[] moduleIds){
		moduleService.deleteModules(moduleIds);
		return "redirect:list";
		
	}
	
	//修改权限模块
	@RequestMapping("toupdate")
	public String toUpdateModule(String moduleId , Model model){
		Module module = moduleService.findModuleById(moduleId);
		model.addAttribute("module", module);
		return"sysadmin/module/jUpdateModule";
	}
	
	//保存更新
	@RequestMapping("updateModule")
	public String updateModule(Module module ,Model model){
		moduleService.updateModule(module);
		model.addAttribute("module", module);
		return "redirect:list";
	}
	
	//查看模块
	@RequestMapping("toview")
	public String toViewModule(String moduleId ,Model model){
		Module module = moduleService.getModuleOneById(moduleId);
		model.addAttribute("module", module);
		return "sysadmin/module/jViewModule";
	}
	

}
