package cn.tarena.ht.service;

import java.util.List;

import cn.tarena.ht.pojo.Dept;
import cn.tarena.ht.pojo.Role;
import cn.tarena.ht.pojo.User;
import cn.tarena.ht.pojo.UserInfo;

public interface UserService {
	/**
	 * 查看用户页面
	 * @return 向页面返回数据库中已有的用户的信息
	 */
	public List<User> findUserList();

	/**
	 * 更新选中用户的状态
	 * @param userIds 用户的id 可以实现同时改变多个
	 * @param i 状态 1 0 
	 */
	public void updateState(String[] userIds, int i);

	/**
	 * 根据用户id删除选中的用户
	 * @param userIds
	 */
	public void deleteUsers(String[] userIds);

	/**
	 * 获取已有的部门的信息
	 * @return 返回部门列表
	 */
	public List<Dept> findDeptList();

	/**
	 * 获取用户拓展信息中上级领导的信息
	 * @return 获取领导列表 
	 */
	public List<UserInfo> findManagerList();

	/**
	 * 保存用户信息
	 * @param user 新增的用户
	 */
	public void saveUser(User user);

	/**
	 * 保存用户拓展信息
	 * @param userInfo
	 */
	public void saveUserInfo(UserInfo userInfo);

	/**
	 * 根据id查看选中的用户的信息
	 * @param userId
	 * @return
	 */
	public User findUserOne(String userId);
	/**
	 * 保存用户信息
	 * @param user
	 */
	public void updateUser(User user);
	
	/**
	 * 保存用户拓展信息
	 * @param userInfo
	 */
	public void updateUserInfo(UserInfo userInfo);
	

	/**
	 * 获取已有的角色信息
	 * @return 角色列表
	 */
	public List<Role> findRoleList();

	/**
	 * 保存用户的角色信息
	 * @param userId 用户id
 	 * @param roleIds 多个角色id
	 */
	public void saveUserRole(String userId, String[] roleIds);

	/**
	 * 根据用户id查看用户的角色信息
	 * @param userId 用户id
	 * @return 用户已有的角色信息
	 */
	public List<String> findRoleByUserId(String userId);

	/**
	 * 登陆页面：根据用户名去查找是否有此用户
	 * @param username 用户名
	 * @return 用户的信息
	 */
	public User findUserByUserName(String username);


}
