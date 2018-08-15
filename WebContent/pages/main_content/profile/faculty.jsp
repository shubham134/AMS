<%@page import="model.dao.UserDAO"%>
<%@page import="model.entity.User"%>
<%@page import="model.entity.Faculty"%>
<%@page import="model.dao.FacultyDAO"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String uid = (String) session.getAttribute("userUid");
	if (uid != null) {
		FacultyDAO adao = new FacultyDAO();
		UserDAO udao = new UserDAO();
		Faculty faculty = adao.findFacultyByUid(uid);
		User facultyUser = udao.findUserByUid(uid);
		session.setAttribute("facultyUser", facultyUser);
		session.setAttribute("faculty", faculty);
	}
%>
<div ng-app="myApp" class="controller" ng-controller="myCtrl">
	<div class="container" style="width: 100%; padding-top: 20px;">
		<div class="panel panel-primary" style="border-radius: 0">
			<div class="panel-heading" style="border-radius: 0">
				<h4 align="center">MY PROFILE</h4>
			</div>
			<div class="alert alert-{{alert}}" style="border-radius: 0"
				ng-model="alert" ng-model="msg">
				<strong>{{msg}}</strong>
			</div>
			<div class="panel-body">
				<form ng-submit="save()">
					<table class="table table-striped table-bordered table-hover">
						<tr>
							<th scope="row">ID</th>
							<td>${faculty.id}</td>
						</tr>
						<tr>
							<th scope="row">Name</th>
							<td>${faculty.name}</td>
						</tr>
						<tr>
							<th scope="row">Subject code</th>
							<td>${faculty.code}</td>
						</tr>
						<tr>
							<th scope="row">User ID</th>
							<td><input style="background-color: transparent; border: 0"
								type="text" readonly="readonly" ng-model="data.uid"></td>
						</tr>
						<tr>
							<th scope="row">Username</th>
							<td><input ng-if="data.show==true"
								style="background-color: transparent; border: 0" type="text"
								readonly="readonly" value="${facultyUser.uname}"> <input
								required ng-if="data.show!=true"
								style="border: 1px solid gray; width: 100%" type="text"
								ng-model="data.uname"></td>
						</tr>
						<tr
							ng-init="data={show:true,uid:'${facultyUser.uid}',uname:'${facultyUser.uname}',pwd:'${facultyUser.pwd}'}">
							<th scope="row">Password</th>
							<td><input ng-if="data.show==true"
								style="background-color: transparent; border: 0" type="password"
								readonly="readonly" value="${facultyUser.pwd}"> <input
								required ng-if="data.show!=true"
								style="border: 1px solid gray; width: 100%" type="text"
								ng-model="data.pwd"></td>
						</tr>
					</table>
					<div>
						<button ng-if="data.show==true" class="btn btn-primary"
							ng-click="swap()" style="border-radius: 0;">Modify</button>
						<button ng-if="data.show!=true" class="btn btn-success"
							type="submit" style="border-radius: 0;">Update</button>
						<button ng-if="data.show!=true" class="btn btn-danger"
							ng-click="swap()" style="border-radius: 0;">Cancel</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>