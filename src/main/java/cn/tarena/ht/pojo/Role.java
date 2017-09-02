package cn.tarena.ht.pojo;

@SuppressWarnings("serial")
public class Role extends BaseEntity{
	private String roleId;
	private String name;
	private String remarks;
	private Integer orderNo;//排序号
	
	/*
	 * 在用户角色模块所需的属性及方法
	 */
	private String checked;//选中已有的用户已有的角色
	
	//在json串中传入id的属性 json中必须的属性
	public String getId() {
		return roleId;
	}	
	public String getChecked() {
		return checked;
	}
	public void setChecked(String checked) {
		this.checked = checked;
	}
	
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Integer orderNo) {           
		this.orderNo = orderNo;
	}
	
	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", name=" + name + ", remarks=" + remarks + ", orderNo=" + orderNo + "]";
	}
	
	

}
