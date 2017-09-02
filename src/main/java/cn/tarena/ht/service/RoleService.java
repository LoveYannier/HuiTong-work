package cn.tarena.ht.service;

import java.util.List;

import cn.tarena.ht.pojo.Module;
import cn.tarena.ht.pojo.Role;

public interface RoleService {

	List<Role> findRoleList();

	void saveRole(Role role);

	void deleteRoles(String[] roleIds);

	Role findRoleById(String roleId);

	void updateRole(Role role);

	Role findRoleOne(String roleId);

	void saveRoleModule(String roleId, String[] moduleIds);

	List<String> findModuleByRole(String roleId);

	List<Module> findModuleList();

}
