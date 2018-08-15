<%@page import="model.dao.L2"%>
<%@page import="model.dao.AttendanceDAO"%>
<%@page import="model.dao.StudentDAO"%>
<%@page import="model.entity.Attendance"%>
<%@page import="model.entity.Student"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String uid = (String) session.getAttribute("userUid");
	StudentDAO sdao = new StudentDAO();
	Student student = sdao.findStudentByUid(uid);
	AttendanceDAO adao = new AttendanceDAO();
	List<L2> attendanceList = adao.showAttendanceOfStudent(student.getId());
	session.setAttribute("attendanceList", attendanceList);
%>
<div ng-app="myApp" class="controller" ng-controller="myCtrl">
	<div class="container" style="width: 100%; padding-top: 20px;">
		<div class="panel panel-primary" style="border-radius: 0">
			<div class="panel-heading" style="border-radius: 0">
				<h4 align="center">
					MY ATTENDANCE <a onclick="myPrint()"
						style="float: right; color: #fff; cursor: pointer;">Print</a>
				</h4>
			</div>
			<div class="form-group">
				<table class="table table-striped table-bordered table-hover"
					ng-init="attendanceList=${attendanceList}">
					<thead style="background-color: #222; color: white;">
						<tr>
							<th scope="col">#</th>
							<th scope="col" ng-click="orderBy('code')">Subject code</th>
							<th scope="col" ng-click="orderBy('name')">Subject name</th>
							<th scope="col" ng-click="orderBy('total')">Total</th>
							<th scope="col" ng-click="orderBy('present')">Present</th>
							<th scope="col" ng-click="orderBy('percent')">%</th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="subject in attendanceList | orderBy:col">
							<th scope="row">{{$index+1}}</th>
							<td>{{subject.code}}</td>
							<td>{{subject.name}}</td>
							<td>{{subject.total}}</td>
							<td>{{subject.present}}</td>
							<td ng-if="subject.percent<75"
								style="color: red; font-weight: bold;">{{subject.percent}}%</td>
							<td ng-if="subject.percent>=75"
								style="color: green; font-weight: bold;">{{subject.percent}}%</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>