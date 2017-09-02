package cn.tarena.ht.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tarena.ht.mapper.DeptMapper;
import cn.tarena.ht.pojo.Dept;

@Service("deptService")
public class DeptServiceImpl implements DeptService{

	@Resource
	private DeptMapper deptMapper;
	
	@Override
	public List<Dept> findDeptList() {
		return deptMapper.findDeptList();
	}

/*	@Override
	public void updateState(Integer deptId, int i) {
		Map<String,Object> map =  new HashMap<String,Object>();
		map.put("deptId", deptId);
		map.put("state", i);
		deptMapper.updateState(map);
	}
*/
	@Override
	public void updateState(Integer[] deptIds, int i) {
		for (Integer deptId : deptIds) {
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("deptId", deptId);
			map.put("state", i);
			deptMapper.updateState(map);
			
		}
	}

	@Override
	public void deleteDepts(String[] deptIds) {
		deptMapper.deleteDepts(deptIds);
	}

	@Override
	public void saveDept(Dept dept) {

		deptMapper.saveDept(dept);
	}

	@Override
	public Dept findDeptOne(String deptId) {
		return deptMapper.findDeptOne(deptId);
	}

	@Override
	public List<Dept> getDeptList() {
		return deptMapper.getDeptList();
	}

	@Override
	public void updateDept(Dept dept) {
		deptMapper.updateDept(dept);
	}

/*	@Override
	public void deleteOne(String deptId) {
		deptMapper.deleteOne(deptId);
	}
*/

}
