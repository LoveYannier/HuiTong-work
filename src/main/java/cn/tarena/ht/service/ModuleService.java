package cn.tarena.ht.service;

import java.util.List;

import cn.tarena.ht.pojo.Module;

public interface ModuleService {

	/**
	 * 查询权限列表
	 * @return
	 */
	List<Module> findModuleList();

//	void updateState(Integer[] moduleIds, int i);

	void saveModule(Module module);

	void deleteModules(String[] moduleIds);

	Module findModuleById(String moduleId);

	void updateModule(Module module);

	Module getModuleOneById(String moduleId);

}
