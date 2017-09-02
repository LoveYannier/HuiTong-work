package cn.tarena.ht.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tarena.ht.mapper.DeptMapper;
import cn.tarena.ht.mapper.RoleMapper;
import cn.tarena.ht.mapper.UserInfoMapper;
import cn.tarena.ht.mapper.UserMapper;
import cn.tarena.ht.pojo.Dept;
import cn.tarena.ht.pojo.Role;
import cn.tarena.ht.pojo.User;
import cn.tarena.ht.pojo.UserInfo;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Resource
	private UserMapper userMapper;
	
	@Resource
	private UserInfoMapper userInfoMapper;
	
	@Resource
	private DeptMapper deptMapper;
	
	@Resource
	private RoleMapper roleMapper;

	//查询用户列表
	@Override
	public List<User> findUserList() {
		return userMapper.findUserList();
	}

	//修改用户状态
	@Override
	public void updateState(String[] userIds, int i) {

		for (String userId : userIds) {
			
			userMapper.updateState(userId,i); 
		}
	}

	//删除用户
	@Override
	public void deleteUsers(String[] userIds) {

		userMapper.deleteUsers(userIds);
	}

	//获取已有的部门信息
	@Override
	public List<Dept> findDeptList() {
		
		return deptMapper.findDeptList();
	}

	//查找已有的上级领导
	@Override
	public List<UserInfo> findManagerList() {
		return userMapper.findManagerList();
	}

	//保存用户信息
	@Override
	public void saveUser(User user) {
		userMapper.saveUser(user);
	}

	//保存用户拓展信息
	@Override
	public void saveUserInfo(UserInfo userInfo) {
		userInfoMapper.saveUserInfo(userInfo);
	}

	//根据用户id查找用户（查看用户 和 修改用户时调用）
	@Override
	public User findUserOne(String userId) {
		return userMapper.findUserOne(userId);
	}
	
	//更新用户信息
	@Override
	public void updateUser(User user) {
		userMapper.updateUser(user);
	}
	
	//更新用户的拓展信息
	@Override
	public void updateUserInfo(UserInfo userInfo) {
		userInfoMapper.updateUserInfo(userInfo);
	}

	@Override
	public List<Role> findRoleList() {
		return roleMapper.findRoleList();
	}

	@Override
	public void saveUserRole(String userId, String[] roleIds) {
		//插入数据时 中间表没有刷新一说，所以：
		//用户分配的角色应该是最终的角色 应该把之前的角色信息删除
		/**
		 * 步骤：
		 * 根据用户的id查询角色信息 
		 * 如果角色信息存在则删除
		 * 如果该用户没有 分配角色则之间添加
		 */
		List<String> roleList = userMapper.findRoleByUserId(userId);
		if(!roleList.isEmpty()){
			userMapper.deleteRoleByUserId(userId);
		}
		
		for (String roleId : roleIds) {
			userMapper.saveUserRole(userId,roleId);
		}
		
	}

	@Override
	public List<String> findRoleByUserId(String userId) {
		return userMapper.findRoleByUserId(userId);
	}

	@Override
	public User findUserByUserName(String username) {
		return userMapper.findUserByUserName(username);
	}


	
	
}
