// declare a module
var adModule = angular.module('adModule', []);
adModule.directive('adView', function() {
	return {
		restrict: 'E',
		scope: {
			adData: '='
			},
		templateUrl: 'assets/templates/adView.html'
	};
});

adModule.controller('adListController', function($scope,$http) {
	$http.get("/ads/1").success(function(data){
		$scope.ads=data;
        $scope.adFound=true;
        if(data.length <= 0) {
            $scope.adFound = false;
        }
	});

    $scope.$on("categorychange",function(even,arg){
        $http.get("/ads/"+arg.id).success(function(data){
            $scope.ads=data;
            $scope.adFound=true;
            if(data.length <= 0) {
                $scope.adFound = false;
            }
        });
    });
});