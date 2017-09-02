<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>部门新增</title>
</head>
<body>
	<form name="icform" method="post">

		<div id="menubar">
			<div id="middleMenubar">
				<div id="innerMenubar">
					<div id="navMenubar">
						<ul>
							<li id="save"><a href="#"
								onclick="formSubmit('saveDept','_self');this.blur();">保存</a></li>
							<li id="back"><a href="#"
								onclick="window.history.go(-1);this.blur();">返回</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		
		<div class="textbox-title">
			<img src="../../staticfile/skin/default/images/icon/currency_yen.png" />
			部门新增
		</div>
		
		<div class="eXtremeTable">
			<table id="ec_table" class="tableRegion" width="98%">
				<tbody class="tableBody">
					<tr class="odd">
						<td>部门ID</td>
						<td><input type="text" name="deptId"/></td>
					</tr>
					
					<tr class="odd">
						<td>父级部门</td>
						<!-- 获取当前已有部门，选择其中之一作为新增部门的父级部门 -->
						<td>
							<select name="parentDept.deptId" style="width:121px;text-align:center">
								<option value="">---请选择---</option>
								<!-- 根据controller传来的deptList遍历 -->
								<c:forEach items="${deptList }" var="d">
									<option value="${d.deptId }">${d.deptName }</option>
								</c:forEach>
							</select>	
						</td>
					</tr>
					
					<tr class="odd">
						<td>部门名称</td>
						<td><input type="text" name="deptName"/></td>
					</tr>
				</tbody>
			</table>
		</div>
</body>
</html>