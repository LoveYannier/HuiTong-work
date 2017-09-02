<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>查看部门信息</title>
</head>

<body>
<form name="icform" method="post">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
	<li id="save"><a href="#" onclick="formSubmit('updateDept','_self');this.blur();">保存</a></li>
	<li id="back"><a href="#" onclick="window.history.go(-1);this.blur();">返回</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="../../staticfile/skin/default/images/icon/currency_yen.png"/>
    部门查看
  </div> 
  
<div>
<div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="98%" >
	<tbody class="tableBody" >
		<tr class="odd">
			<td>部门ID</td>
			<td><input type="text" name="deptId" value="${dept.deptId}" readonly="readonly"/></td>
		</tr>
		<tr class="odd">
			<td>父级部门</td>
			<td>
				<select name="parentDept.deptId" style="width:121px;text-align:center">
					<c:forEach items="${deptList}" var="d">
						<option value="${d.deptId}"
							<c:if test="${dept.parentDept.deptId== d.deptId}">
								selected="selected"
							</c:if>	
						 >${d.deptName}</option>
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr class="odd">
			<td>部门名称</td>
			<td><input type="text" name="deptName" value="${dept.deptName}"/></td>
		</tr>
		<tr class="odd">
			<td>状态</td>
			<td>
				<input type="radio" name="state" value="1" <c:if test="${dept.state==1}"> checked="checked"</c:if>/>启用
				<input type="radio" name="state" value="0" <c:if test="${dept.state==0}"> checked="checked"</c:if> />停用
			</td>
		</tr>
	</tbody>
</table>
</div>
 
</div>
 
 
</form>
</body>
</html>

