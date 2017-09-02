
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>用户更新</title>
<script type="text/javascript"
	src="${ctx }/staticfile/js/datepicker/WdatePicker.js"></script>
</head>

<body>
	<form name="icform" method="post">

		<div id="menubar">
			<div id="middleMenubar">
				<div id="innerMenubar">
					<div id="navMenubar">
						<ul>
							<li id="view"><a href="#"
								onclick="formSubmit('updateUser','_self');this.blur();">保存</a></li>
							<li id="new"><a href="#"
								onclick="window.history.go(-1);this.blur();">返回</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>

		<div class="textbox-title">
			<img src="../../staticfile/skin/default/images/icon/currency_yen.png" />
			用户更新
		</div>

		<div>


			<div class="eXtremeTable">
				<table id="ec_table" class="tableRegion" width="98%">
					<tbody class="tableBody">
						<!-- 添加用户id -->
						<tr hidden="hidden">
							<td><input  name="userId" value="${user.userId }" /></td>
						</tr>
						<tr class="odd">
							<td>用户名称</td>
							<td><input type="text" name="username"
								value="${user.username } " /></td>
							<td>用户密码</td>
							<td><input type="text" name="password"
								value="${user.password }" /></td>
						</tr>
						<tr class="odd">
							<td>真实姓名</td>
							<td><input type="text" name="userInfo.name"
								value="${user.userInfo.name } " /></td>
							<td>所在部门</td>
							<td>
								<select name="dept.deptId">
									<c:forEach items="${deptList }" var="d">
										<option value="${d.deptId }"
										<c:if test="${deptId==d.deptId }">
											selected = "selected"
										</c:if>
										>${d.deptName }</option>
									</c:forEach>
								</select>
							</td>
						</tr>
						<tr class="odd">
							<td>工资</td>
							<td><input type="text" name="userInfo.salary"
								value="${user.userInfo.salary } " /></td>
							<td>岗位</td>
							<td><input type="text" name="userInfo.station"
								value="${user.userInfo.station }" /></td>
						</tr>
						<tr class="odd">
							<td>电话</td>
							<td><input type="text" name="userInfo.telephone"
								value="${user.userInfo.telephone } " /></td>
							<td>用户级别</td>
							<td><select name="userInfo.userLevel">
										<option value="">---请选择---</option>
										<option value="1">总经理</option>
										<option value="2">副总</option>
										<option value="3">部门经理</option>
										<option value="4">普通用户</option>
									
							</select></td>
						</tr>
						<tr class="odd">
							<td>直属领导</td>
							<td><select name="userInfo.manager.userInfoId">
									<!-- 封装的是用户信息:user.userInfo -->
									<c:forEach items="${managerList }" var="m">
										<option value="${m.userInfoId }"
										<c:if test="${userInfoId==m.userInfoId }">
											selected = "selected"
										</c:if>
										>${m.name }</option>
									</c:forEach>
							</select></td>
							<td>用户状态</td>
							<td><input type="text" name="state" value="${user.state }" /></td>
						</tr>
						
						<tr class="odd">
							<td>备注信息</td>
							<td colspan="3">
							<textarea style="height: 150px;width: 100%"> 
							${user.userInfo.remark }
							</textarea>
							</td>
						</tr>

					</tbody>
				</table>
			</div>

		</div>


	</form>
</body>
</html>

