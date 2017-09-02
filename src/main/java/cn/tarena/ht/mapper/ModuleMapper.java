package cn.tarena.ht.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.tarena.ht.pojo.Module;

public interface ModuleMapper {

	List<Module> findModuleList();

//	void updateState(@Param("moduleId")Integer moduleId, @Param("state")int i);

	void saveModule(Module module);

	void deleteModules(String[] moduleIds);

	@Select("select * from module_p where module_id = #{moduleId}")
	Module findModuleById(String moduleId);

	void updateModule(Module module);

	Module getModuleOneById(String moduleId);

	List<Module> findModuleStartList();
	

	
}
