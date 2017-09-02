package cn.tarena.ht.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

import cn.tarena.ht.tool.MD5Hash;
//专门用来加密
public class AuthCredential extends SimpleCredentialsMatcher{
	/**
	 * shiro中的加密规则
	 * 首先把用户传入的password经过加密之后与原来的用户密码进行比较
	 * 比较成功则能成功加密
	 */
	@Override
	public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
		//得到当前传入的用户名和密码
		UsernamePasswordToken loginToken = (UsernamePasswordToken) token;
		String username = loginToken.getUsername();
		//需要将密码字符数组转化为字符串
		String password = String.valueOf(loginToken.getPassword());
		//生成加密后的密文
		String md5Hash = MD5Hash.getMD5Hash(password, username);
		//将新的密文设置回登陆令牌中
		loginToken.setPassword(md5Hash.toCharArray());
		//将令牌传到shiro中		
		return super.doCredentialsMatch(token, info);
	}

}
