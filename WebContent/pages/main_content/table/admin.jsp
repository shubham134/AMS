<%@page import="model.entity.Admin"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="adao" class="model.dao.AdminDAO" />
<%
	List<Admin> admins = adao.getAllAdmins();
	session.setAttribute("admins", admins);
%>
<div ng-app="myApp" class="controller" ng-controller="myCtrl">
	<div class="container" style="width: 100%; padding-top: 20px;">
		<div class="panel panel-primary" style="border-radius: 0">
			<div class="panel-heading" style="border-radius: 0">
				<h4 align="center">ADMIN TABLE</h4>
			</div>
			<div ng-init="admins=${admins}">
				<table class="table table-striped table-bordered table-hover">
					<thead style="background-color: #222; color: white;">
						<tr>
							<th scope="col">#</th>
							<th scope="col" ng-click="orderBy('id')">ID</th>
							<th scope="col" ng-click="orderBy('name')">Name</th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="admin in admins | orderBy:col">
							<th scope="row">{{$index+1}}</th>
							<td>{{admin.id}}</td>
							<td>{{admin.name}}</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>