package cn.tarena.ht.tool;

import org.apache.shiro.crypto.hash.Md5Hash;

public class MD5Hash {
	/**
	 * 向外提供加密算法
	 * @param password 密码
	 * @param username 用户名（盐）
	 * @return
	 */
	public static String getMD5Hash(String password , String username){
		Md5Hash md5Hash = new Md5Hash(password,username,3);
		return md5Hash.toString();
	}
}
