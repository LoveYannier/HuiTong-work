           <%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>模块更新</title>
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
								onclick="formSubmit('updateModule','_self');this.blur();">保存</a></li>
							<li id="new"><a href="#"
								onclick="window.history.go(-1);this.blur();">返回</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>

		<div class="textbox-title">
			<img src="../../staticfile/skin/default/images/icon/currency_yen.png" />
			模块更新
		</div>

		<div>


			<div class="eXtremeTable">
				<table id="ec_table" class="tableRegion" width="98%">
					<tbody class="tableBody">
						<!-- 添加用户id -->
						<tr hidden="hidden">
							<td><input name="moduleId" value="${module.moduleId }"/></td>
						</tr>
						<tr class="odd">
							<td>模块名称</td>
							<td><input type="text" name="name" value="${module.name } "/></td>
							<td>模块类型</td>
							<td>
								<select name="ctype">
									<option value="${module.ctype }" selected="selected">${module.ctype }</option>
									<option value="1">主菜单</option>
									<option value="2">侧面菜单</option>
									<option value="3">按钮</option>
								</select>
							</td>
						</tr>

						<tr class="odd">
							
							<td>排序号</td>
							<td><input type="text" name="orderNo" value="${module.orderNo }"/></td>
							<td>备注信息</td>
							<td>
							<textarea style="height: 150px; width: 100%"
									name="remark">${module.remark }</textarea>
							</td>
						</tr>
						<tr class="odd">
							
							<td>更新人</td>
							<td><input type="text" name="updateBy" value="${module.updateBy }"/></td>
							<td>更新时间</td>
							<td>
							<input name="updateTime" type="text" style="width:127px"
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

           