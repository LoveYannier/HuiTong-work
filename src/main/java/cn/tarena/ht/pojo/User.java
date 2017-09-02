package cn.tarena.ht.pojo;

@SuppressWarnings("serial")
public class User extends BaseEntity{

	//映射关系
	private UserInfo userInfo;
	private Dept dept;
	//用户角色
	private Role role;
	
	private String userId;
	private String username;
	private String password;
	//将state 修改成enable 是否启用 spring security认enable字段
	private int enable;
	
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getEnable() {
		return enable;
	}
	public void setEnable(int enable) {
		this.enable = enable;
	}
	@Override
	public String toString() {
		return "User [userInfo=" + userInfo + ", dept=" + dept + ", userId=" + userId + ", username=" + username
				+ ", password=" + password + ", enable=" + enable + "]";
	}
	
	
	
}
