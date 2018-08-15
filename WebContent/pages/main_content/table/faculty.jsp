<%@page import="model.entity.Faculty"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="fdao" class="model.dao.FacultyDAO" />
<%
	List<Faculty> faculties = fdao.getAllFaculties();
	session.setAttribute("faculties", faculties);
%>
<div ng-app="myApp" class="controller" ng-controller="myCtrl">
	<div class="container" style="width: 100%; padding-top: 20px;">
		<div class="panel panel-primary" style="border-radius: 0">
			<div class="panel-heading" style="border-radius: 0">
				<h4 align="center">FACULTY TABLE</h4>
			</div>
			<div ng-init="faculties=${faculties}">
				<table class="table table-striped table-bordered table-hover">
					<thead style="background-color: #222; color: white;">
						<tr>
							<th scope="col">#</th>
							<th scope="col" ng-click="orderBy('id')">ID</th>
							<th scope="col" ng-click="orderBy('name')">Name</th>
							<th scope="col" ng-click="orderBy('code')">Subject code</th>
						</tr>
					</thead>
					<tbody>
							<tr ng-repeat="faculty in faculties | orderBy:col">
								<th scope="row">{{$index+1}}</th>
								<td>{{faculty.id}}</td>
								<td>{{faculty.name}}</td>
								<td>{{faculty.code}}</td>
							</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>