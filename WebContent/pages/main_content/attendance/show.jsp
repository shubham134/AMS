<%@page import="model.entity.Attendance"%>
<%@page import="model.entity.Student"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div ng-app="myApp" class="controller" ng-controller="myCtrl">
	<div class="container" style="width: 100%; padding-top: 20px;">
		<div class="panel panel-primary" style="border-radius: 0">
			<div class="panel-heading" style="border-radius: 0">
				<h4 align="center">
					SHOW ATTENDANCE <span style="font-style: italic;">(${branch}-
						${section})</span><a onclick="myPrint()" style="float: right; color: #fff;cursor: pointer;">Print</a>
				</h4>
			</div>
			<div class="form-group">
				<table class="table table-striped table-bordered table-hover"
					ng-init="attendanceList=${attendanceList}">
					<thead style="background-color: #222; color: white;">
						<tr>
							<th scope="col">#</th>
							<th scope="col" ng-click="orderBy('id')">Roll no.</th>
							<th scope="col" ng-click="orderBy('name')">Name</th>
							<th scope="col" ng-click="orderBy('total')">Total</th>
							<th scope="col" ng-click="orderBy('present')">Present</th>
							<th scope="col" ng-click="orderBy('percent')">%</th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="student in attendanceList | orderBy:col">
							<th scope="row">{{$index+1}}</th>
							<td>{{student.id}}</td>
							<td>{{student.name}}</td>
							<td>{{student.total}}</td>
							<td>{{student.present}}</td>
							<td ng-if="student.percent<75"
								style="color: red; font-weight: bold;">{{student.percent}}%</td>
							<td ng-if="student.percent>=75"
								style="color: green; font-weight: bold;">{{student.percent}}%</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>