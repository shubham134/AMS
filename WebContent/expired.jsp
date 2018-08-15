<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AMS-Session expired</title>
<link href="assets/css/bootstrap.css" rel="stylesheet" />
<link href="assets/css/font-awesome.css" rel="stylesheet" />
<link href="assets/css/basic.css" rel="stylesheet" />
<link href="assets/css/custom.css" rel="stylesheet" />
</head>
<body onLoad="noBack();" onpageshow="if (event.persisted) noBack();" onUnload="">
	<div style="width: 50%; margin-left: 350px; margin-top: 100px;">
		<div class="alert alert-danger" style="border-radius: 0">
			<strong>Session expired! Redirecting to login page...</strong>
			<div ng-show="show" class="progress">
				<div
					class="progress-bar progress-bar-danger progress-bar-striped active"
					role="progressbar" aria-valuenow="45" aria-valuemin="0"
					aria-valuemax="100" style="width: 100%"></div>
			</div>
		</div>
	</div>
	<%
		session.invalidate();
		response.setHeader("Refresh", "1;url=index.jsp");
	%>
	<script src="assets/js/angular.min.js"></script>
	<script src="assets/js/jquery.js"></script>
	<script src="assets/js/add.js"></script>
	<script src="assets/js/jquery.metisMenu.js"></script>
	<script src="assets/js/custom.js"></script>
</body>
</html>