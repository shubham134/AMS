<div class="controller" ng-app="myApp" ng-controller="myCtrl">
	<div class="container" style="width: 100%; padding-top: 20px;">
		<div class="panel panel-primary" style="border-radius: 0">
			<div class="panel-heading" style="border-radius: 0">
				<h4 align="center">ADD STUDENT</h4>
			</div>
			<div class="alert alert-{{alert}}" style="border-radius: 0"
				ng-model="alert" ng-model="msg">
				<strong>{{msg}}</strong>
			</div>
			<div class="panel-body">
				<form ng-submit="addStudent()">
					<div class="form-group">
						<div class="control-label">
							<label>Roll no.<font color="red"
								style="font-weight: lighter;">*</font></label>
						</div>
						<input required type="number" min="0" class="form-control" style="border-radius: 0"
							ng-model="id" name="id" />
					</div>
					<div class="form-group">
						<div class="control-label">
							<label>Name<font color="red"
								style="font-weight: lighter;">*</font></label>
						</div>
						<input required type="text" class="form-control" style="border-radius: 0"
							ng-model="name" name="code" />
					</div>
					<div class="form-group">
						<div class="control-label">
							<label>Branch<font color="red"
								style="font-weight: lighter;">*</font></label>
						</div>
						<select required class="form-control" style="border-radius: 0"
							ng-model="branch" name="branch">
							<option value="" selected disabled>Select</option>
							<option>CSE</option>
							<option>IT</option>
							<option>EC</option>
							<option>CE</option>
							<option>ME</option>
						</select>
					</div>
					<div class="form-group has-{{v_alert}}">
						<div class="control-label">
							<label>Section<font color="red"
								style="font-weight: lighter;">*</font></label>
						</div>
						<select required class="form-control" style="border-radius: 0"
							ng-model="section" name="section">
							<option value="" selected disabled>Select</option>
							<option>1</option>
							<option>2</option>
							<option>3</option>
							<option>4</option>
						</select>
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