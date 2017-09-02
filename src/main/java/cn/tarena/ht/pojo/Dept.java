package cn.tarena.ht.pojo;
//部门表：自关联！！
@SuppressWarnings("serial")
public class Dept extends BaseEntity{
	
	private Dept parentDept; //关联关系：
	
	private String deptId;
	private String deptName;
	private Integer state;
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public Dept getParentDept() {
		return parentDept;
	}
	public void setParentDept(Dept parentDept) {
		this.parentDept = parentDept;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Dept [deptId=" + deptId + ", parentDept=" + parentDept + ", deptName=" + deptName + ", state=" + state
				+ "]";
	}
	
	 
}
