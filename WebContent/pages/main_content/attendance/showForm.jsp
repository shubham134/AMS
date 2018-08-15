<%@page import="model.entity.Faculty"%>
<%@page import="model.dao.FacultyDAO"%>
<jsp:useBean id="fdao" class="model.dao.FacultyDAO" />
<%
	Faculty faculty = fdao.findFacultyByUid((String) session.getAttribute("userUid"));
	session.setAttribute("faculty", faculty);
%>
<div class="controller" ng-app="myApp" ng-controller="myCtrl">
	<div class="container" style="width: 100%; padding-top: 20px;">
		<div class="panel panel-primary" style="border-radius: 0">
			<div class="panel-heading" style="border-radius: 0">
				<h4 align="center">SHOW ATTENDANCE</h4>
			</div>
			<div class="alert alert-{{alert}}" style="border-radius: 0"
				ng-model="alert" ng-model="msg">
				<strong>{{msg}}</strong>
			</div>

			<div class="panel-body">
				<form action="ShowAttendanceForm" method="post">
					<div class="form-group">
						<div class="control-label">
							<label>Faculty ID</label>
						</div>
						<input type="text" class="form-control" style="border-radius: 0"
							name="fid" value="${faculty.id}" readonly="readonly" />
					</div>
					<div class="form-group">
						<div class="control-label">
							<label>Subject code</label>
						</div>
						<input type="text" class="form-control" style="border-radius: 0"
							name="code" value="${faculty.code}" readonly="readonly" />
					</div>
					<div class="form-group">
						<div class="control-label">
							<label>Branch<font color="red"
								style="font-weight: lighter;">*</font></label>
						</div>
						<select required class="form-control" style="border-radius: 0"
							name="branch">
							<option value="" selected disabled>Select</option>
							<option>CSE</option>
							<option>IT</option>
							<option>EC</option>
							<option>CE</option>
							<option>ME</option>
						</select>
					</div>
					<div class="form-group">
						<div class="control-label">
							<label>Section<font color="red"
								style="font-weight: lighter;">*</font></label>
						</div>
						<select required class="form-control" style="border-radius: 0"
							name="section">
							<option value="" selected disabled>Select</option>
							<option>1</option>
							<option>2</option>
							<option>3</option>
							<option>4</option>
						</select>
					</div>
					<button type="submit" class="btn btn-primary"
						style="border-radius: 0">Show</button>
					<div style="padding-top: 10px">
						<font color="red" style="font-weight: lighter; font-size: small;">*Required
							fields</font>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>