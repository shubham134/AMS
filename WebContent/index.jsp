<%@page import="model.dao.AttendanceDAO"%>
<%@page import="model.entity.User"%>
<%@page import="model.dao.UserDAO"%>
<%@page import="model.entity.Admin"%>
<%@page import="model.dao.AdminDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>AMS-Login</title>
<link href="assets/css/bootstrap.css" rel="stylesheet" />
<link href="assets/css/font-awesome.css" rel="stylesheet" />
<link href="assets/css/basic.css" rel="stylesheet" />
<link href="assets/css/custom.css" rel="stylesheet" />
</head>
<body ng-app="myApp" class="controller" ng-controller="myCtrl" onLoad="noBack();" onpageshow="if (event.persisted) noBack();" onUnload="">
	<%
	int status=new AdminDAO().createFirstAdmin();
	if(status==1)
		session.setAttribute("disp", "(First login : Username = admin111, Password = 111)");
	else if(status==3)
		session.setAttribute("disp", "Database connection failure!");
	%>
	<div id="wrapper">
		<nav class="navbar navbar-default navbar-cls-top" role="navigation"
			style="margin-bottom: 0">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".sidebar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="index.jsp"><img width="30px"
					height="35px" src="assets/img/logo.png"> AMS</a>
			</div>
		</nav>
	</div>
	<div>
		<div class="container" style="width: 50%; padding-top: 20px;">
			<div class="panel panel-primary" style="border-radius: 0">
				<div class="panel-heading" style="border-radius: 0">
					<h4 align="center">LOGIN</h4>
					<h4 align="center">${disp}</h4>
				</div>
				<div class="alert alert-{{alert}}" style="border-radius: 0"
					ng-model="alert" ng-model="msg">
					<strong>{{msg}}</strong>
				</div>
				<div class="panel-body">
					<form ng-submit="login()">
						<div class="form-group">
							<div class="control-label">
								<label>Username<font color="red"
									style="font-weight: lighter;">*</font></label>
							</div>
							<input type="text" required class="form-control" style="border-radius: 0"
								ng-model="uname" name="uname" />
						</div>
						<div class="form-group">
							<div class="control-label">
								<label>Password<font color="red">*</font></label>
							</div>
							<input type="password" required class="form-control"
								style="border-radius: 0" ng-model="pwd" name="pwd" />
						</div>
						<div>
							<button type="submit" class="btn btn-primary"
								style="border-radius: 0">Login</button>
						</div>
						<div style="padding-top: 10px">
							<font color="red" style="font-weight: lighter; font-size: small;">*Required
								fields</font>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<div id="footer-sec">
		<b>Copyright &copy; </b>All rights reserved.
	</div>
	<jsp:include page="script.jsp"></jsp:include>
</body>
</html>