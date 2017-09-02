package cn.tarena.ht.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.tarena.ht.pojo.Dept;
import cn.tarena.ht.service.DeptService;

@Controller
@RequestMapping("/sysadmin/dept/")
public class DeptController {
	@Resource
	private DeptService deptService;
	
	@RequestMapping("list")
	public String toDeptList(Model model){
		//为页面准备部门数据
		List<Dept> deptList = deptService.findDeptList();
		System.out.println(deptList);
		model.addAttribute("deptList", deptList);
		return "sysadmin/dept/jDeptList";
	}
	
/*	//实现停用部门 传入相应部门id --单个部门状态
	@RequestMapping("stop")
	public String toStop(Integer deptId){
		deptService.updateState(deptId,0);
		return "redirect:list";
	}
	
	//实现启用部门 --单个部门状态
	@RequestMapping("start")
	public String toStart(Integer deptId){
		deptService.updateState(deptId,1);
		return "redirect:list";
	}
*/	
	//优化改变状态的方法
	@RequestMapping("stop")
	public String toStop(@RequestParam("deptId")Integer[] deptIds){
		deptService.updateState(deptIds,0);
		return "redirect:list";
	}
	
	@RequestMapping("start")
	public String toStart(@RequestParam("deptId")Integer[] deptIds){
		deptService.updateState(deptIds,1);
		return "redirect:list";
	}
	

/*	//删除单个部门信息
	@RequestMapping("delete")
	public String toDelete(String deptId){
		deptService.deleteOne(deptId);
		return "redirect:list";
	}
*/	
	//遍历部门id 实现多个删除
	@RequestMapping("delete")
	public String toDeleteDept(@RequestParam("deptId")String[] deptIds){
		deptService.deleteDepts(deptIds);
		return "redirect:list";
	}
	
	//新增部门 , 跳转到新增部门的页面
	@RequestMapping("tocreate")
	public String toCreate(Model model){
		//获取当前的所有部门，作为父级部门为下拉列表准备数据
		List<Dept> deptList = deptService.findDeptList();
		//将当前已有部门信息传到页面
		model.addAttribute("deptList", deptList);
		return "sysadmin/dept/jCreateDept";
	}
	
	//保存新增部门的信息
	@RequestMapping("saveDept")
	public String saveDept(Dept dept){
		deptService.saveDept(dept);
		return "redirect:list";
	}
	
	//根据部门id来查看部门详细信息
	@RequestMapping("toview")
	public String toview(String deptId , Model model){
		Dept dept= deptService.findDeptOne(deptId);
		model.addAttribute("dept", dept);
		return "sysadmin/dept/jViewDept";
	}
	
	//转向修改页面
		@RequestMapping("toupdate")
		public String toupdate(String deptId,Model model){
			//准备要修改的数据
			Dept dept = deptService.findDeptOne(deptId);
			
			//准备部门下拉列表
			List<Dept> deptList = deptService.getDeptList();
			
			model.addAttribute("dept", dept);
			model.addAttribute("deptList", deptList);
			
			return "sysadmin/dept/jUpdateDept";
		}
		
		@RequestMapping("updateDept")
		public String updateDept(Dept dept){
			//部门的更新
			deptService.updateDept(dept);
			
			return "redirect:/sysadmin/dept/list";
		}
}
