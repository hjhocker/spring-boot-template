var app = angular.module('bankApp', ['ngRoute']);

app.config(function($routeProvider) {
  $routeProvider
    .when('/', {
      templateUrl: 'partials/home.html',
      controller: 'HomeController'
    })
    .when('/accounts', {
      templateUrl: 'partials/accounts.html'
    })
    .otherwise({
      redirectTo: 'partials/error.html'
    })
});

app.controller('HomeController', function($scope, $http) {
  $scope.name = 'Harrison';

  $http.get("http://localhost:9999/api/getAccounts")
    .success(function(response) {$scope.accounts = response;});
});
