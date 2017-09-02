<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>权限新增</title>
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
								onclick="formSubmit('saveModule','_self');this.blur();">保存</a></li>
							<li id="new"><a href="#"
								onclick="window.history.go(-1);this.blur();">返回</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>

		<div class="textbox-title">
			<img src="../../staticfile/skin/default/images/icon/currency_yen.png" />
			权限新增
		</div>

		<div>


			<div class="eXtremeTable">
				<table id="ec_table" class="tableRegion" width="98%">
					<tbody class="tableBody">
						<tr class="odd">
							<td>编号</td>
							<td><input type="text" name="moduleId" /></td>
							<td>名称</td>
							<td><input type="text" name="name" /></td>
							
						</tr>

						<tr class="odd">
							<td>父级模块</td>
							<td>
							<select name="parent.moduleId" style="width:121px;text-align:center">
								<option value="">---请选择---</option>
								<!-- 根据controller传来的deptList遍历 -->
								<c:forEach items="${moduleList }" var="m">
									<option value="${m.parent.moduleId}">${m.parent.name }</option>
								</c:forEach>
							</select>	
							</td>
							<td>备注信息</td>
							<td>
							<textarea style="height: 150px; width: 100%"
									name="remark"></textarea>
									</td>

						</tr>
						<tr class="odd">
							<td>类型</td>
							<td>
								<select name="ctype">
									<option value="">---请选择---</option>
									<option value="1">主菜单</option>
									<option value="2">侧面菜单</option>
									<option value="3">按钮</option>
								</select>
							</td>
							<td>排序号</td>
							<td><input type="text" name="orderNo" /></td>
						</tr>
						<tr class="odd">
						<td>创建时间</td>
						<td colspan="2">
							<input name="createTime" type="text" style="width:127px"
								onclick="WdatePicker({el:this,isShowOthers:true,dateFormat:'yyyy-MM-dd'})"
								/>
						</td>
						</tr>
					</tbody>
				</table>
			</div>

		</div>


	</form>
</body>
</html>

