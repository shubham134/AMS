<div class="controller" ng-app="myApp" ng-controller="myCtrl">
	<div class="container" style="width: 100%; padding-top: 20px;">
		<div class="panel panel-primary" style="border-radius: 0">
			<div class="panel-heading" style="border-radius: 0">
				<h4 align="center">ADD SUBJECT</h4>
			</div>
			<div class="alert alert-{{alert}}" style="border-radius: 0"
				ng-model="alert" ng-model="msg">
				<strong>{{msg}}</strong>
			</div>
			<div class="panel-body">
				<form ng-submit="addSubject()">
					<div class="form-group has-{{v_alert}}">
						<div class="control-label">
							<label>Subject Code<font color="red" style="font-weight: lighter;">*</font></label>
						</div>
						<input type="text" required class="form-control" style="border-radius: 0"
							ng-model="code" name="code" />
					</div>
					<div class="form-group has-{{v_alert}}">
						<div class="control-label">
							<label>Name<font color="red" style="font-weight: lighter;">*</font></label>
						</div>
						<input type="text" required class="form-control" style="border-radius: 0"
							ng-model="name" name="code" />
					</div>
					<button type="submit" class="btn btn-primary"
						style="border-radius: 0">Add</button>
					<button type="reset" class="btn btn-primary"
						style="border-radius: 0" ng-click="reset()">Clear</button>
					<div style="padding-top: 10px">
						<font color="red" style="font-weight: lighter; font-size: small;">*Required
							fields</font>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>