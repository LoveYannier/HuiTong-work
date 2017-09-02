package cn.tarena.ht.mapper;


import java.util.List;
import java.util.Map;

import cn.tarena.ht.pojo.Dept;

public interface DeptMapper {
	//查询所有的部门
	public List<Dept> findDeptList();
	//修改部门的状态
	public void updateState(Map<String, Object> map);
	//删除部门
//	public void deleteOne(String deptId);
	//优化删除方法
	public void deleteDepts(String[] deptIds);
	//保存新增部门
	public void saveDept(Dept dept);
	//查看部门信息
	public Dept findDeptOne(String deptId);
	//获取已有的部门
	public List<Dept> getDeptList();
	//更新部门信息
	public void updateDept(Dept dept);

}
