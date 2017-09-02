package cn.tarena.ht.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import cn.tarena.ht.pojo.User;
import cn.tarena.ht.pojo.UserInfo;

public interface UserMapper {
	public List<User> findUserList();

	public void updateState(@Param("userId")String userId, @Param("state")int i);

	public void deleteUsers(String[] userIds);

	public List<UserInfo> findManagerList();

	public void saveUser(User user);
	
	public void updateUser(User user);

	public User findUserOne(String userId);

	public void saveUserRole(@Param("userId")String userId,@Param("roleId")String roleId);

	
	public List<String> findRoleByUserId(String userId);

	public void deleteRoleByUserId(String userId);

	/**
	 * 用于登陆页面中查找用户是否存在
	 * @param username
	 * @return
	 */
	public User findUserByUserName(String username);

	
	
	

}
