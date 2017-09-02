package cn.tarena.ht.service;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tarena.ht.mapper.ModuleMapper;
import cn.tarena.ht.mapper.RoleMapper;
import cn.tarena.ht.pojo.Module;
import cn.tarena.ht.pojo.Role;

@Service("roleService")
public class RoleServiceImpl implements RoleService{
	@Resource
	private RoleMapper roleMapper;
	@Resource
	private ModuleMapper moduleMapper;

	@Override
	public List<Role> findRoleList() {
		return roleMapper.findRoleList();
	}

	@Override
	public void saveRole(Role role) {
		//添加主键的值
		String uuid = UUID.randomUUID().toString();
		role.setRoleId(uuid);
		roleMapper.saveRole(role);
	}

	@Override
	public void deleteRoles(String[] roleIds) {
		
		roleMapper.deleteRoles(roleIds);
	}

	@Override
	public Role findRoleById(String roleId) {
		return roleMapper.findRoleById(roleId);
	}

	@Override
	public void updateRole(Role role) {
		roleMapper.updateRole(role);
	}

	@Override
	public Role findRoleOne(String roleId) {
		return roleMapper.findRoleOne(roleId);
	}

	@Override
	public void saveRoleModule(String roleId, String[] moduleIds) {
		//不管之前有没有数据都直接删除
		roleMapper.deleteRoleModule(roleId);
		for (String moduleId : moduleIds) {
			roleMapper.saveRoleModule(roleId,moduleId);
		}
	}

	@Override
	public List<String> findModuleByRole(String roleId) {
		return roleMapper.findModuleByRoleId(roleId);
	}

	/**
	 * 查找角色的权限列表
	 * 必须是已经启用的角色
	 */
	@Override
	public List<Module> findModuleList() {
		//去查找已启用的权限列表
		List<Module> moduleStartList =moduleMapper.findModuleStartList();
		//设置pId
		for (Module module : moduleStartList) {
			//判断module上的parent不为空
			if(module.getParent()!=null){
				//设置他的父id
				String moduleId = module.getParent().getModuleId();
				module.setpId(moduleId);
			}
		}
		System.out.println(moduleStartList);
		return moduleStartList;
	}

}
