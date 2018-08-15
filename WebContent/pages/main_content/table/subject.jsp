<%@page import="model.entity.Subject"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="sdao" class="model.dao.SubjectDAO" />
<%
	List<Subject> subjects = sdao.getAllSubjects();
	session.setAttribute("subjects", subjects);
%>
<div ng-app="myApp" class="controller" ng-controller="myCtrl">
	<div class="container" style="width: 100%; padding-top: 20px;">
		<div class="panel panel-primary" style="border-radius: 0">
			<div class="panel-heading" style="border-radius: 0">
				<h4 align="center">SUBJECT TABLE</h4>
			</div>
			<div ng-init="subjects=${subjects}">
				<table class="table table-striped table-bordered table-hover">
					<thead style="background-color: #222; color: white;">
						<tr>
							<th scope="col">#</th>
							<th scope="col" ng-click="orderBy('code')">Subject code</th>
							<th scope="col" ng-click="orderBy('name')">Name</th>
						</tr>
					</thead>
					<tbody>
							<tr ng-repeat="subject in subjects | orderBy:col">
								<th scope="row">{{$index+1}}</th>
								<td>{{subject.code}}</td>
								<td>{{subject.name}}</td>
							</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>