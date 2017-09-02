           <%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>角色更新</title>
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
								onclick="formSubmit('updateRole','_self');this.blur();">保存</a></li>
							<li id="new"><a href="#"
								onclick="window.history.go(-1);this.blur();">返回</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>

		<div class="textbox-title">
			<img src="../../staticfile/skin/default/images/icon/currency_yen.png" />
			角色更新
		</div>

		<div>


			<div class="eXtremeTable">
				<table id="ec_table" class="tableRegion" width="98%">
					<tbody class="tableBody">
						<!-- 添加用户id -->
						<tr hidden="hidden">
							<td><input name="roleId" value="${role.roleId }"/></td>
						</tr>
						<tr class="odd">
							<td>角色名称</td>
							<td><input type="text" name="name" value="${role.name } "/></td>
							<td>排序号</td>
							<td><input type="text" name="orderNo" value="${role.orderNo }"/></td>
						</tr>

						<tr class="odd">
							<td>备注信息</td>
							<td colspan="2">
							<textarea style="height: 150px; width: 100%"
									name="remarks">${role.remarks }</textarea>
									</td>

						</tr>
					</tbody>
				</table>
			</div>

		</div>


	</form>
</body>
</html>

           