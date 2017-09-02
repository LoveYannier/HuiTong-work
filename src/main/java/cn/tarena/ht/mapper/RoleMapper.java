package cn.tarena.ht.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.tarena.ht.pojo.Module;
import cn.tarena.ht.pojo.Role;

public interface RoleMapper {

	//写sql语句的查询语句的注解
	@Select(value="select * from role_p")
	List<Role> findRoleList();

	void saveRole(Role role);

	void deleteRoles(String[] roleIds);

	@Select("select * from role_p where role_id=#{roleId}")
	Role findRoleById(String roleId);

	void updateRole(Role role);

	@Select("select * from role_p where role_id=#{roleId}")
	Role findRoleOne(String roleId);

	void saveRoleModule(@Param("roleId")String roleId,@Param("moduleId") String moduleId);

	void deleteRoleModule(String roleId);

	List<String> findModuleByRoleId(String roleId);

	

}
