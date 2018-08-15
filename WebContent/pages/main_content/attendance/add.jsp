<%@page import="model.entity.Attendance"%>
<%@page import="model.entity.Student"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div ng-app="myApp" class="controller" ng-controller="myCtrl">
	<div class="container" style="width: 100%; padding-top: 20px;">
		<div class="panel panel-primary" style="border-radius: 0">
			<div class="panel-heading" style="border-radius: 0">
				<h4 align="center">
					TAKE ATTENDANCE <span style="font-family: cursive;">(${branch}-
						${section})</span><a onclick="myPrint()" style="float: right; color: #fff;cursor: pointer;">Print</a>
				</h4>
			</div>
			<div class="alert alert-{{alert}}" style="border-radius: 0"
				ng-model="alert" ng-model="t_msg">
				<strong>{{msg}}</strong>
				<div ng-show="show" class="progress">
					<div ng-model="info"
						class="progress-bar progress-bar-{{info}} progress-bar-striped active"
						role="progressbar" aria-valuenow="45" aria-valuemin="0"
						aria-valuemax="100" style="width: 100%"></div>
				</div>
			</div>
			<div class="form-group">
				<form action="AddAttendance" method="post">
					<table class="table table-striped table-bordered table-hover"
						ng-init="studentsList=${studentsList}">
						<thead style="background-color: #222; color: white;">
							<tr>
								<th scope="col">#</th>
								<th scope="col" ng-click="orderBy('id')">Roll no.</th>
								<th scope="col" ng-click="orderBy('name')">Name</th>
								<th scope="col" ng-click="orderBy('status')">Status</th>
							</tr>
						</thead>
						<tbody>
							<tr ng-repeat="student in studentsList | orderBy:col"
								ng-init="status={letter:'P',color:'green'}" ng-click="mark()"
								style="cursor: pointer;">
								<th scope="row">{{$index+1}}</th>
								<td>{{student.id}}</td>
								<td>{{student.name}}</td>
								<td><input type="text"
									style="width: 20px; background-color: transparent; cursor: pointer; border-color: transparent; font-weight: bold; color: {{status.color}};"
									readonly="readonly" ng-model="status.letter"
									name="status{{student.id}}"></td>
							</tr>
						</tbody>
					</table>
					<div>
						<button type="submit" class="btn btn-success"
							style="border-radius: 0" ng-click="i()">Submit</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>