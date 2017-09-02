<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>模块查看</title>
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
							<li id="new"><a href="#"
								onclick="window.history.go(-1);this.blur();">返回</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>

		<div class="textbox-title">
			<img src="../../staticfile/skin/default/images/icon/currency_yen.png" />
			模块查看
		</div>

		<div>


			<div class="eXtremeTable">
				<table id="ec_table" class="tableRegion" width="98%">
					<tbody class="tableBody">
						<tr class="odd">
							<td>模块名称</td>
							<td>${module.name }</td>
							<td>排序号</td>
							<td>${module.orderNo }</input>
							</td>
						</tr>

						<tr class="odd">
							<td>父级模块</td>
							<td>${module.parent.name}</td>
							<td>类型</td>
							<td>${module.ctype }</td>
						</tr>
						
						<tr class="odd">
							<td>备注信息</td>
							<td colspan="2">
								${module.remark }
							</td>
						</tr>
					</tbody>
				</table>
			</div>

		</div>


	</form>
</body>
</html>

