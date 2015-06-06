		// declare a module
		var loginModule = angular.module('login', []);
		loginModule.controller('loginController', function($scope,$http,$location) {
			$scope.login = function(){
				$http.post('/login',{'username':$scope.username,'password':$scope.password}).success(function(data){
                    if(data=="true"){
                        $location.path('/ads');
                    }
				}).error(function(){
					$location.path('/');
				});
			};
		});