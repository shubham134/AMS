<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>AMS</title>
<link rel="icon" type="image/png" href="images/icons/favicon.ico" />
<link rel="stylesheet" type="text/css"
	href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css"
	href="fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<link rel="stylesheet" type="text/css"
	href="vendor/css-hamburgers/hamburgers.min.css">
<link rel="stylesheet" type="text/css"
	href="vendor/animsition/css/animsition.min.css">
<link rel="stylesheet" type="text/css"
	href="vendor/select2/select2.min.css">
<link rel="stylesheet" type="text/css"
	href="vendor/daterangepicker/daterangepicker.css">
<link rel="stylesheet" type="text/css" href="css/util.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<!-- BOOTSTRAP STYLES-->
<link href="assets/css/bootstrap.css" rel="stylesheet" />
<!-- FONTAWESOME STYLES-->
<link href="assets/css/font-awesome.css" rel="stylesheet" />
<!--CUSTOM BASIC STYLES-->
<link href="assets/css/basic.css" rel="stylesheet" />
<!--CUSTOM MAIN STYLES-->
<link href="assets/css/custom.css" rel="stylesheet" />
<!-- GOOGLE FONTS-->
</head>
<body>
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
					height="35px" src="images/icons/logo.png"> AMS</a>
			</div>

			<div class="header-right">
				<a href="login.jsp" title="Logout"><font color="white"><b>Logout</b></font></a>
			</div>
		</nav>
		<!-- /. NAV TOP  -->
		<nav class="navbar-default navbar-side" role="navigation">
			<div class="sidebar-collapse">
				<ul class="nav" id="main-menu">
					<li><a href="profile.jsp"><i class="fa fa-toggle-on"></i>Profile</a>
					</li>


					<li><a class="active-menu" href="index.jsp"><i
							class="fa fa-dashboard "></i>Home</a></li>
					<li><a href="#"><i class="fa fa-desktop "></i>Administrator<span
							class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a href="searchAdmin.jsp"><i class="fa fa-toggle-on"></i>Search</a>
							</li>
							<li><a href="addAdmin.jsp"><i class="fa fa-bell "></i>Add</a>
							</li>
							<li><a href="tableAdmin.jsp"><i class="fa fa-circle-o "></i>Table</a>
							</li>
						</ul></li>
					<li><a href="#"><i class="fa fa-desktop "></i>Faculty<span
							class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a href="searchFaculty.jsp"><i
									class="fa fa-toggle-on"></i>Search</a></li>
							<li><a href="addFaculty.jsp"><i class="fa fa-bell "></i>Add</a>
							</li>
							<li><a href="tableFaculty.jsp"><i
									class="fa fa-circle-o "></i>Table</a></li>
						</ul></li>
					<li><a href="#"><i class="fa fa-desktop "></i>Student<span
							class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a href="searchStudent.jsp"><i
									class="fa fa-toggle-on"></i>Search</a></li>
							<li><a href="addStudent.jsp" target="#page"><i
									class="fa fa-bell "></i>Add</a></li>
							<li><a href="vendor/tableStudent.jsp" target="#page"><i
									class="fa fa-circle-o "></i>Table</a></li>
						</ul></li>
					<li><a href="#"><i class="fa fa-desktop "></i>Subject<span
							class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a href="searchSubject.jsp"><i
									class="fa fa-toggle-on"></i>Search</a></li>
							<li><a href="addSubject.jsp"><i class="fa fa-bell "></i>Add</a>
							</li>
							<li><a href="tableSubject.jsp"><i
									class="fa fa-circle-o "></i>Table</a></li>
						</ul></li>
				</ul>

			</div>

		</nav>
		<!-- /. NAV SIDE  -->
		<div id="page-wrapper">
			<div id="page-inner">
				<div class="row">
					<div style="width: 100%" class="col-md-6 col-sm-6 col-xs-12" ng-app="" ng-model="alert;message" ng-init="alert='error';message='Invalid'">
						<div class="panel panel-primary">
							<div class="panel-heading">OTHER ELEMENTS FOR FORM</div>
							<div class="panel-body">

								<form role="form">
									Some Message Examples <br />
									<label class="control-label">SUCCESS
											EXAMPLE</label>
									<div class="form-group has-{{alert}}">
										 <input type="text" class="form-control" id="success" />
										 <div class="control-label">{{message}}</div>
									</div>
									<div class="form-group has-warning">
										<label>WARNING
											EXAMPLE</label> <input type="text" class="form-control" id="warning" />
									</div>
									<div class="form-group has-error">
										<label class="control-label" for="error">ERROR EXAMPLE</label>
										<input type="text" class="form-control" id="error" />
									</div>
									<button type="submit" class="btn btn-info">Send Message </button>
								</form>
							</div>
						</div>
					</div>

					<!-- /. ROW  -->
				</div>
			</div>



		</div>

	</div>
	<!-- /. PAGE INNER  -->
	<!-- /. PAGE WRAPPER  -->

	<!-- /. WRAPPER  -->

	<div id="footer-sec">
		<b>Copyright &copy; </b>All rights reserved.
	</div>
	<!-- /. FOOTER  -->
	<!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
	<script src="vendor/animsition/js/animsition.min.js"></script>
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="vendor/select2/select2.min.js"></script>
	<script src="vendor/daterangepicker/moment.min.js"></script>
	<script src="vendor/daterangepicker/daterangepicker.js"></script>
	<script src="vendor/countdowntime/countdowntime.js"></script>
	<!-- JQUERY SCRIPTS -->
	<script src="assets/js/jquery-1.10.2.js"></script>
	<!-- BOOTSTRAP SCRIPTS -->
	<script src="assets/js/bootstrap.js"></script>
	<!-- METISMENU SCRIPTS -->
	<script src="assets/js/jquery.metisMenu.js"></script>
	<!-- CUSTOM SCRIPTS -->
	<script src="assets/js/custom.js"></script>

	<script src="js/redirect.js"></script>
	<script src="js/angular.min.js"></script>
	<script src="js/jquery.js"></script>
</body>
</html>
