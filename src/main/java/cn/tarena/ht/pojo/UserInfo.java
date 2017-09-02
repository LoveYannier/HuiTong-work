package cn.tarena.ht.pojo;

import java.util.Date;

@SuppressWarnings("serial")
public class UserInfo extends BaseEntity{

	//自关联关系
	private UserInfo manager;//领导信息
	
	private String userInfoId;
	private String name;
	private String cardNo;//身份证号
	private Date joinDate;//入职时间
	private double salary;
	private Date birthday;
	private String gender;//性别
	private String station;//岗位
	private String telephone;
	private String userLevel;//'4-普通用户 3-部门经理 2-副总 1-总经理 0-超级管理员';
	private String remark;//备注信息
	private int orderNo;
	public UserInfo getManager() {
		return manager;
	}
	public void setManager(UserInfo manager) {
		this.manager = manager;
	}
	public String getUserInfoId() {
		return userInfoId;
	}
	public void setUserInfoId(String userInfoId) {
		this.userInfoId = userInfoId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getStation() {
		return station;
	}
	public void setStation(String station) {
		this.station = station;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getUserLevel() {
		return userLevel;
	}
	public void setUserLevel(String userLevel) {
		this.userLevel = userLevel;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	@Override
	public String toString() {
		return "UserInfo [manager=" + manager + ", userInfoId=" + userInfoId + ", name=" + name + ", cardNo=" + cardNo
				+ ", joinDate=" + joinDate + ", salary=" + salary + ", birthday=" + birthday + ", gender=" + gender
				+ ", station=" + station + ", telephone=" + telephone + ", userLevel=" + userLevel + ", remark="
				+ remark + ", orderNo=" + orderNo + "]";
	}
	
}
