<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="sdao" class="model.dao.StudentDAO" />
<div ng-app="myApp" class="controller" ng-controller="myCtrl">
	<div class="container" style="width: 100%; padding-top: 20px;">
		<div class="panel panel-primary" style="border-radius: 0">
			<div class="panel-heading" style="border-radius: 0">
				<h4 align="center">STUDENT DETAILS</h4>
			</div>
			<div class="alert alert-{{t_alert}}" style="border-radius: 0"
				ng-model="t_alert" ng-model="t_msg" ng-model="t_reason">
				<strong>{{t_msg}}</strong> {{t_reason}}
			</div>
			<div class="panel-body">
				<form ng-submit="search()">
					<div class="form-group">
						<div class="control-label">
							<label>Student ID</label>
						</div>
						<div>
							<select class="form-control" style="border-radius: 0"
								ng-model="id" name="id">
								<c:if test="${empty id}">
									<option value="" selected disabled>Select</option>
								</c:if>
								<%
									List<Integer> ids = sdao.getAllIds();
									session.setAttribute("ids", ids);
								%>
								<c:forEach var="i" items="${ids}">
									<c:if test="${param.id eq i}">
										<option selected value="${i}">${i}</option>
									</c:if>
									<c:if test="${param.id ne i}">
										<option selected value="${i}">${i}</option>
									</c:if>
								</c:forEach>
							</select>
						</div>
						<button type="submit" class="btn btn-primary"
							style="border-radius: 0">Search</button>
					</div>
				</form>
				<c:if test="${not empty id}">
					<jsp:include page="show/student.jsp" />
				</c:if>
			</div>
		</div>
	</div>
</div>