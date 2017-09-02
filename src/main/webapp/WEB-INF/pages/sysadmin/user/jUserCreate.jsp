<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>用户新增</title>
<script type="text/javascript" src="${ctx }/staticfile/js/datepicker/WdatePicker.js"></script>
</head>

<body>
	<form name="icform" method="post">

		<div id="menubar">
			<div id="middleMenubar">
				<div id="innerMenubar">
					<div id="navMenubar">
						<ul>
							<li id="view"><a href="#"
								onclick="formSubmit('saveUser','_self');this.blur();">保存</a></li> 
							<li id="new"><a href="#"
								onclick="window.history.go(-1);this.blur();">返回</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>

		<div class="textbox-title">
			<img src="../../staticfile/skin/default/images/icon/currency_yen.png" />
			用户新增
		</div>

		<div>


			<div class="eXtremeTable">
				<table id="ec_table" class="tableRegion" width="98%">
					<tbody class="tableBody">
						<tr class="odd">
							<td>所在部门</td>
							<td>
								<select name="dept.deptId">
									<option value="">---请选择---</option>
									<c:forEach items="${deptList }" var="d">
										<option value="${d.deptId }">${d.deptName }</option>
									</c:forEach>
								</select>
							</td>
							<td>用户名:</td>
							<td><input type="text" name="username"/></td>
						</tr>
						
						<tr class="odd">
							<td>密码</td>
							<td>
								<input type="password" name="password"/>
							</td>
							<td>真实姓名:</td>
							<td><input type="text" name="userInfo.name"/></td>
						</tr>
						
						<tr class="odd">
							<td>身份证号</td>
							<td>
								<input type="text" name="userInfo.cardNo"/>
							</td>
							<!-- 日期插件 -->
							<td>入职时间:</td>
							<td>
								<input name="userInfo.joinDate" type="text" style="width:127px"
								onclick="WdatePicker({el:this,isShowOthers:true,dateFormat:'yyyy-MM-dd'})"
								/>
							</td>
						</tr>
						
						<tr class="odd">
							<td>工资</td>
							<td>
								<input type="text" name="userInfo.salary"/>
							</td>
							<!-- 日期插件 -->
							<td>出生年月:</td>
							<td>
								<input name="userInfo.birthday" type="text" style="width:127px"
								onclick="WdatePicker({el:this,isShowOthers:true,dateFormat:'yyyy-MM-dd'})"
								/>
							</td>
						</tr>
						
						<tr class="odd">
							<td>性别</td>
							<td>
								<input type="radio" name="userInfo.gender" value="0"/>女
								<input type="radio" name="userInfo.gender" value="1"/>男								
							</td>
							<td>岗位:</td>
							<td>
								<input type="text" name="userInfo.station"/>
							</td>
						</tr>
						<tr class="odd">
							<td>电话</td>
							<td>
								<input type="text" name="userInfo.telephone"/>
							</td>
							<td>用户级别:</td>
							<td>
								<select name="userInfo.userLevel">
									<option value="">---请选择---</option>
									<option value="1">总经理</option>
									<option value="2">副总</option>
									<option value="3">部门经理</option>
									<option value="4">普通用户</option>
								</select>
							</td>
						</tr>
						
						<!-- 领导信息的封装 -->
						<tr class="odd">
							<td>直属领导</td>
							<td>
								<select name="userInfo.manager.userInfoId">
									<option value="">---请选择---</option>
									<!-- 封装的是用户信息:userInfo -->
									<c:forEach items="${managerList }" var="m">
										<option value="${m.userInfoId }"> ${m.name }</option>
									</c:forEach>
								</select>
							</td>
						</tr>
						
						<tr class="odd">
							<td>备注</td>
							<td colspan="3">
								<textarea style="height:100px;width: 100%" name="userInfo.remark"></textarea>
							</td>
						</tr>
					</tbody>
				</table>
			</div>

		</div>


	</form>
</body>
</html>

