<%@page import="model.dao.UserDAO"%>
<%@page import="model.entity.User"%>
<%@page import="model.entity.Admin"%>
<%@page import="model.dao.AdminDAO"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String id = (String) session.getAttribute("id");
	if (!id.equalsIgnoreCase("")) {
		AdminDAO adao = new AdminDAO();
		UserDAO udao = new UserDAO();
		Admin admin = adao.findAdminById(Integer.parseInt(id));
		User adminUser = udao.findUserByUid(admin.getUid());
		session.setAttribute("adminUser", adminUser);
		session.setAttribute("admin", admin);
	}
%>
<div class="form-group">
	<table class="table table-striped table-bordered table-hover">
		<tr>
			<th scope="row">ID</th>
			<td>${admin.id}</td>
		</tr>
		<tr>
			<th scope="row">Name</th>
			<td>${admin.name}</td>
		</tr>
		<tr>
			<th scope="row">UID</th>
			<td>${admin.uid}</td>
		</tr>
		<c:if test="${userUid eq admin.uid}">
			<tr>
				<th scope="row">Username</th>
				<td>${adminUser.uname}</td>
			</tr>
			<tr>
				<th scope="row">Password</th>
				<td>${adminUser.pwd}</td>
			</tr>
		</c:if>
	</table>
</div>
<%
	session.setAttribute("id", "");
%>
<div ng-model="uid" ng-change="t_alert='';t_msg='';uid='${admin.uid}'">
	<form ng-submit="del()">
		<button class="btn btn-danger" type="submit"
			style="border-radius: 0; align-self: center;">Delete</button>
	</form>
</div>
