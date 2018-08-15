function noBack() {
	window.history.forward();
}

function myPrint() {
	window.print();
}

var helloAjaxApp = angular.module("myApp", []);

helloAjaxApp
		.controller(
				"myCtrl",
				[
						'$scope',
						'$http',
						'$window',
						function($scope, $http, $window) {

							$http.defaults.headers.post["Content-Type"] = "application/x-www-form-urlencoded; charset=utf-8";

							$scope.reset = function() {
								$scope.alert = '';
								$scope.msg = '';
							}

							$scope.orderBy = function(x) {
								$scope.col = x;
							};

							$scope.i = function() {
								$scope.show = true;
								$scope.alert = 'warning';
								$scope.msg = 'Updating attendance...';
								$scope.info = 'warning';
							};

							$scope.mark = function() {
								if (this.status.letter === 'P') {
									this.status.letter = 'A';
									this.status.color = 'red';
								} else {
									this.status.letter = 'P';
									this.status.color = 'green';
								}
							}

							$scope.swap = function() {
								$scope.alert = '';
								$scope.msg = '';
								$scope.data.show = !$scope.data.show;
							};

							$scope.save = function() {
								$scope.alert = 'warning';
								$scope.msg = 'Updating...';
								$http({
									url : 'Save',
									method : "POST",
									data : {
										'uname' : $scope.data.uname,
										'pwd' : $scope.data.pwd,
										'uid' : $scope.data.uid
									}
								})
										.then(
												function(response) {
													console.log(response.data);
													$scope.alert = response.data.alert;
													$scope.msg = response.data.msg;
													if (response.data.alert === "success") {
														$window.location.href = response.data.page;
													}
												},
												function(response) {
													console.log(response);
													$scope.alert = "danger";
													$scope.msg = 'Failed! No response from server.';
												});
							};

							$scope.del = function() {
								$scope.alert = 'warning';
								$scope.msg = 'Deleting...';
								$http({
									url : 'Delete',
									method : "POST",
									data : {
										'id' : $scope.id
									}
								})
										.then(
												function(response) {
													console.log(response.data);
													$scope.alert = response.data.alert;
													$scope.msg = response.data.msg;
													$window.location.href = response.data.page;
												},
												function(response) {
													console.log(response);
													$scope.alert = "danger";
													$scope.msg = 'Failed! No response from server.';
												});
							};

							$scope.search = function() {
								$scope.alert = 'warning';
								$scope.msg = 'Please wait...';
								$http({
									url : 'Search',
									method : "POST",
									data : {
										'id' : $scope.id
									}
								})
										.then(
												function(response) {
													console.log(response.data);
													$scope.alert = response.data.alert;
													$scope.msg = response.data.msg;
													$window.location.href = response.data.page;
												},
												function(response) {
													console.log(response);
													$scope.alert = "danger";
													$scope.msg = 'Failed! No response from server.';
												});
							};

							$scope.login = function() {
								$scope.alert = 'warning';
								$scope.msg = 'Logging in...';
								$http({
									url : 'Login',
									method : "POST",
									data : {
										'uname' : $scope.uname,
										'pwd' : $scope.pwd
									}
								})
										.then(
												function(response) {
													console.log(response.data);
													$scope.alert = response.data.alert;
													$scope.msg = response.data.msg;
													if (response.data.alert === "success") {
														$window.location.href = response.data.page;
													}
												},
												function(response) {
													console.log(response);
													$scope.alert = "danger";
													$scope.msg = 'Failed! No response from server.';
												});
							};

							$scope.addAdmin = function() {
								$scope.alert = 'warning';
								$scope.msg = 'Please wait...';
								$http({
									url : 'AddAdmin',
									method : "POST",
									data : {
										'id' : $scope.id,
										'name' : $scope.name
									}
								}).then(function(response) {
									console.log(response.data);
									$scope.alert = response.data.alert;
									$scope.msg = response.data.msg;
								}, function(response) {
									console.log(response);
									$scope.alert = "danger";
									$scope.msg = 'User ID must be unique.';
								});
							};

							$scope.addFaculty = function() {
								$scope.alert = 'warning';
								$scope.msg = 'Please wait...';
								$http({
									url : 'AddFaculty',
									method : "POST",
									data : {
										'id' : $scope.id,
										'name' : $scope.name,
										'code' : $scope.code
									}
								}).then(function(response) {
									console.log(response.data);
									$scope.alert = response.data.alert;
									$scope.msg = response.data.msg;
								}, function(response) {
									console.log(response);
									$scope.alert = "danger";
									$scope.msg = 'User ID must be unique.';
								});
							};

							$scope.addStudent = function() {
								$scope.alert = 'warning';
								$scope.msg = 'Please wait...';
								$http({
									url : 'AddStudent',
									method : "POST",
									data : {
										'id' : $scope.id,
										'name' : $scope.name,
										'branch' : $scope.branch,
										'section' : $scope.section
									}
								}).then(function(response) {
									console.log(response.data);
									$scope.alert = response.data.alert;
									$scope.msg = response.data.msg;
								}, function(response) {
									console.log(response);
									$scope.alert = "danger";
									$scope.msg = 'User ID must be unique.';
								});
							};

							$scope.addSubject = function() {
								$scope.alert = 'warning';
								$scope.msg = 'Please wait...';
								$http({
									url : 'AddSubject',
									method : "POST",
									data : {
										'code' : $scope.code,
										'name' : $scope.name
									}
								})
										.then(
												function(response) {
													console.log(response.data);
													$scope.alert = response.data.alert;
													$scope.msg = response.data.msg;
												},
												function(response) {
													console.log(response);
													$scope.alert = "danger";
													$scope.msg = 'Subject code must be unique.';
												});
							};

						} ]);