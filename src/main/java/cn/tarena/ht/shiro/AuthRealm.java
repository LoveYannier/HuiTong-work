package cn.tarena.ht.shiro;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

import cn.tarena.ht.pojo.User;
import cn.tarena.ht.service.UserService;

//安全管理需要继承的类
public class AuthRealm extends AuthorizingRealm{

	@Resource
	private UserService userService;
	//权限管理 可以实现不同的用户展现不同的界面
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		//权限列表 就是用户所拥有的权限信息
		/**
		 * 权限的实现思路
		 * 1、拿到当前请求用户的名称
		 * 2、根据username去数据库中查找 
		 * user_p --> role_user_p (role_id) -->module_role_p module_id --> module_p moduleName(权限名称)
		 */
		List<String> roleList = new ArrayList<String>();
		Subject subject = SecurityUtils.getSubject();
		String username = (String) subject.getSession().getAttribute("username");
		//手动添加
		roleList.add("货运管理");
		roleList.add("基础信息");
		roleList.add("系统管理");
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.addStringPermissions(roleList);
		//将信息交给shiro管理
		return info;
	}

	//认证管理 登陆认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//获取用户名 将token强制转换
		/**
		 * 验证思路：
		 * 通过用户传入的username去数据库中查找对应对象
		 * 把对象传给shiro
		 * shiro自动的根据对象中的密码做匹配
		 * 匹配成功正确执行
		 * 不成功抛出异常
		 */
		UsernamePasswordToken loginToken = (UsernamePasswordToken) token;
		//获取用户传入的username
		String username = loginToken.getUsername();
		//根据用户名去查找数据库中的用户
		User user = userService.findUserByUserName(username);
		/**
		 * shiro安全认证的参数
		 * 1、查询回来的对象 user
		 * 2、正确的密码 uesr.getPassword
		 * 3、当前对象的名称
		 */
		//获取当前查询到的用户，用户密码，以及当前对象的名字
		AuthenticationInfo info = new SimpleAuthenticationInfo(user,user.getPassword(),this.getName());
		//shiro开始工作：当info对象创建完成之后shiro会在内部作比较 如果传入的密码和数据库中密码相同则放行 否则抛出异常
		return info;//返回到加密算法类AuthCredential中
	}

}
