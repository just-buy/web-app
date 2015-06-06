		// declare a module
		var justBuyModule = angular.module('justBuy', ['ngRoute','login','adModule']);
		justBuyModule.config(function($routeProvider) {
				$routeProvider.when('/', {
					templateUrl: 'assets/templates/login.html'
				}).when('/ads', {
					templateUrl: 'assets/templates/adList.html'
				}).otherwise({redirectTo: '/'});
			});

		justBuyModule.controller('headerController', function($scope) {
			$scope.test = "test";
            $scope.getItems = function(id){
                $scope.$root.$broadcast("categorychange",{"id":id});
            };
		});