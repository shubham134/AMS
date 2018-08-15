<%@page import="model.entity.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>AMS-Faculty table</title>
<link href="assets/css/bootstrap.css" rel="stylesheet" />
<link href="assets/css/font-awesome.css" rel="stylesheet" />
<link href="assets/css/basic.css" rel="stylesheet" />
<link href="assets/css/custom.css" rel="stylesheet" />
</head>
<body onLoad="noBack();" onpageshow="if (event.persisted) noBack();" onUnload="">
	<%
		String userType = (String) session.getAttribute("userType");
		if (userType == null || !userType.equalsIgnoreCase("admin")) {
			response.sendRedirect("expired.jsp");
		}
	%>
	<div id="wrapper">
		<nav class="navbar navbar-default navbar-cls-top" role="navigation"
			style="margin-bottom: 0">
			<jsp:include page="pages/header/admin.jsp"></jsp:include>
		</nav>
		<nav class="navbar-default navbar-side" role="navigation">
			<jsp:include page="pages/side_nav/admin.jsp"></jsp:include>
		</nav>
		<div id="page-wrapper">
			<div id="page-inner">
				<div class="row">
					<div class="col-md-12">
						<jsp:include page="pages/main_content/table/faculty.jsp"></jsp:include>
					</div>
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