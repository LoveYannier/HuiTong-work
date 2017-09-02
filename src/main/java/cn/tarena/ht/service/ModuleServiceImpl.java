package cn.tarena.ht.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tarena.ht.mapper.ModuleMapper;
import cn.tarena.ht.pojo.Module;

@Service("moduleService")
public class ModuleServiceImpl implements ModuleService{
	@Resource
	private ModuleMapper moduleMapper;

	/**
	 * 查询权限列表 
	 */
	@Override
	public List<Module> findModuleList() {
		return moduleMapper.findModuleList();
	}


	/*@Override
	public void updateState(Integer[] moduleIds, int i) {
		for (Integer moduleId : moduleIds) {
			moduleMapper.updateState(moduleId, i);
		}
	}
*/

	@Override
	public void saveModule(Module module) {
		moduleMapper.saveModule(module);
	}


	@Override
	public void deleteModules(String[] moduleIds) {
		moduleMapper.deleteModules(moduleIds);
	}

	@Override
	public Module findModuleById(String moduleId) {
		return moduleMapper.findModuleById(moduleId);
	}


	@Override
	public void updateModule(Module module) {
		moduleMapper.updateModule(module);
	}


	@Override
	public Module getModuleOneById(String moduleId) {
		return moduleMapper.getModuleOneById(moduleId);
	}

}
