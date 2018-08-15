<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="sdao" class="model.dao.SubjectDAO" />
<div ng-app="myApp" class="controller" ng-controller="myCtrl">
	<div class="container" style="width: 100%; padding-top: 20px;">
		<div class="panel panel-primary" style="border-radius: 0">
			<div class="panel-heading" style="border-radius: 0">
				<h4 align="center">SUBJECT DETAILS</h4>
			</div>
			<div class="alert alert-{{t_alert}}" style="border-radius: 0"
				ng-model="t_alert" ng-model="t_msg" ng-model="t_reason">
				<strong>{{t_msg}}</strong> {{t_reason}}
			</div>
			<div class="panel-body">
				<form ng-submit="search()">
					<div class="form-group">
						<div class="control-label">
							<label>Subject Code</label>
						</div>
						<div>
							<select class="form-control" style="border-radius: 0"
								ng-model="code" name="code">
								<c:if test="${empty param.code}">
									<option value="" selected disabled>Select</option>
								</c:if>
								<%
									List<String> codes = sdao.getAllCodes();
									session.setAttribute("codes", codes);
								%>
								<c:forEach var="c" items="${codes}">
									<c:if test="${param.code eq c}">
										<option selected value="${c}">${c}</option>
									</c:if>
									<c:if test="${param.code ne c}">
										<option selected value="${c}">${c}</option>
									</c:if>
								</c:forEach>
							</select>
						</div>
						<button type="submit" class="btn btn-primary"
							style="border-radius: 0">Search</button>
					</div>
				</form>
				<c:if test="${not empty param.code}">
					<jsp:include page="show/subject.jsp" />
				</c:if>
			</div>
		</div>
	</div>
</div>