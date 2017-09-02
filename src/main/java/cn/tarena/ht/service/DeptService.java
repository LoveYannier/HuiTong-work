package cn.tarena.ht.service;

import java.util.List;

import cn.tarena.ht.pojo.Dept;

public interface DeptService {
	//部门信息封装
	public List<Dept> findDeptList();
	//改变部门状态
//	public void updateState(Integer deptId, int i);
	//同时改变多个部门的状态
	public void updateState(Integer[] deptIds, int i);
	//删除部门
//	public void deleteOne(String deptId);
	//删除方法的优化
	public void deleteDepts(String[] deptIds);
	//保存新增部门
	public void saveDept(Dept dept);
	//根据部门id来查看部门信息
	public Dept findDeptOne(String deptId);
	
	//获取已有部门的下拉列表
	public List<Dept> getDeptList();
	//更新部门信息
	public void updateDept(Dept dept);
}
