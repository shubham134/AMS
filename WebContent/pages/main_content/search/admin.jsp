<%@page import="model.entity.User"%>
<%@page import="model.entity.Admin"%>
<%@page import="model.dao.UserDAO"%>
<%@page import="model.dao.AdminDAO"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="adao" class="model.dao.AdminDAO" />
<div ng-app="myApp" class="controller" ng-controller="myCtrl">
	<div class="container" style="width: 100%; padding-top: 20px;">
		<div class="panel panel-primary" style="border-radius: 0">
			<div class="panel-heading" style="border-radius: 0">
				<h4 align="center">ADMIN DETAILS</h4>
			</div>
			<div class="alert alert-{{alert}}" style="border-radius: 0"
				ng-model="alert" ng-model="msg">
				<strong>{{msg}}</strong>
			</div>
			<div class="panel-body">
				<form ng-submit="search()">
					<div class="form-group">
						<div class="control-label">
							<label>Admin ID</label>
						</div>
						<div>
							<select class="form-control" style="border-radius: 0"
								ng-model="id" name="id">
								<option value="" ng-if="id==''" selected disabled>Select</option>
								<%
									List<Integer> ids = adao.getAllIds();
									session.setAttribute("ids", ids);
								%>
								<c:forEach var="i" items="${ids}">
									<option ng-if="id=='${i}'" selected value="${i}">${i}</option>
									<option ng-if="id!='${i}'" value="${i}">${i}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<button type="submit" class="btn btn-primary"
						style="border-radius: 0">Search</button>
				</form>
				<c:if test="{{id!=''}}">
					<jsp:include page="show/admin.jsp" />
				</c:if>
			</div>
		</div>
	</div>
</div>