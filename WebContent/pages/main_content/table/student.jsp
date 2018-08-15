<%@page import="model.entity.Student"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="sdao" class="model.dao.StudentDAO" />
<%
	List<Student> students = sdao.getAllStudents();
	session.setAttribute("students", students);
%>
<div ng-app="myApp" class="controller" ng-controller="myCtrl">
	<div class="container" style="width: 100%; padding-top: 20px;">
		<div class="panel panel-primary" style="border-radius: 0">
			<div class="panel-heading" style="border-radius: 0">
				<h4 align="center">STUDENT TABLE</h4>
			</div>
			<div ng-init="students=${students}">
				<table class="table table-striped table-bordered table-hover">
					<thead style="background-color: #222; color: white;">
						<tr>
							<th scope="col">#</th>
							<th scope="col" ng-click="orderBy('id')">Roll no.</th>
							<th scope="col" ng-click="orderBy('name')">Name</th>
							<th scope="col" ng-click="orderBy('branch')">Branch</th>
							<th scope="col" ng-click="orderBy('section')">Section</th>
						</tr>
					</thead>
					<tbody>
							<tr ng-repeat="student in students | orderBy:col">
								<th scope="row">{{$index+1}}</th>
								<td>{{student.id}}</td>
								<td>{{student.name}}</td>
								<td>{{student.branch}}</td>
								<td>{{student.section}}</td>
							</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>