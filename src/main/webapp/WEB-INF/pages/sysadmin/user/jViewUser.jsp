<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>用户查看</title>
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
			用户查看
		</div>

		<div>


			<div class="eXtremeTable">
				<table id="ec_table" class="tableRegion" width="98%">
					<tbody class="tableBody">
						<tr class="odd">
							<td>所在部门</td>
							<td>
								${user.dept.deptName }
							</td>
							<td>用户名:</td>
							<td>${user.username }</td>
						</tr>
						
						<tr class="odd">
							<td>真实姓名:</td>
							<td>${user.userInfo.name }</td>
							<td>身份证号</td>
							<td>
								${user.userInfo.cardNo }
							</td>
						</tr>
						
						<tr class="odd">
							<!-- 日期插件 -->
							<td>入职时间:</td>
							<td>
								${user.userInfo.joinDate }
							</td>
							<td>工资</td>
							<td>
								${user.userInfo.salary }
							</td>
						</tr>
						
						<tr class="odd">
							<!-- 日期插件 -->
							<td>出生年月:</td>
							<td>
								${user.userInfo.birthday }
							</td>
							<td>性别</td>
							<td>
								${user.userInfo.gender }
							</td>
						</tr>
						
						<tr class="odd">
							<td>岗位:</td>
							<td>
								${user.userInfo.station }
							</td>
							<td>电话</td>
							<td>
								${ user.userInfo.telephone}
							</td>
						</tr>
						<tr class="odd">
							<td>用户级别:</td>
							<td>
								${user.userInfo.userLevel }
							</td>
							<!-- 领导信息的封装 -->
							<td>直属领导</td>
							<td>
								${user.userInfo.manager.name }
							</td>
						</tr>
						
						<tr class="odd">
							<td>备注</td>
								${user.userInfo.remark }
						</tr>
					</tbody>
				</table>
			</div>

		</div>


	</form>
</body>
</html>

