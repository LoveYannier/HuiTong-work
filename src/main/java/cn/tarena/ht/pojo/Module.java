package cn.tarena.ht.pojo;

@SuppressWarnings("serial")
public class Module extends BaseEntity{

	private String moduleId;	//模块id
	private Module parent;	//父模块
	private String name;	//模块名称 权限标识
	private Integer ctype;	//type在oracle中是敏感字
	private Integer state;	//状态
	private Integer orderNo;	//排序号
	private String remark;	//备注信息
	
	/*
	 * 用于角色权限模块部分的属性
	 */
	private String pId;//zTree树中的父id
	private String checked;//在角色页面回显权限已有的角色时需要的属性
	
	
	public String getChecked() {
		return checked;
	}
	public void setChecked(String checked) {
		this.checked = checked;
	}
	
	public String getpId() {
		return pId;
	}
	public void setpId(String pId) {
		this.pId = pId;
	}
	public String getId(){
		return moduleId;
	}
	public String getModuleId() {
		return moduleId;
	}
	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}
	
	public Module getParent() {
		return parent;
	}
	public void setParent(Module parent) {
		this.parent = parent;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCtype() {
		return ctype;
	}
	public void setCtype(Integer ctype) {
		this.ctype = ctype;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Integer getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Module [moduleId=" + moduleId + ", parent=" + parent + ", name=" + name + ", ctype=" + ctype
				+ ", state=" + state + ", orderNo=" + orderNo + ", remark=" + remark + "]";
	}
	
	
}
