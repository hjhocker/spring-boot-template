var app = angular.module('bankApp', ['ngRoute']);

app.config(function($routeProvider) {
  $routeProvider
    .when('/', {
      templateUrl: 'partials/home.html',
      controller: 'HomeController'
    })
    .when('/accounts', {
      templateUrl: 'partials/accounts.html',
      controller: 'AccountsController'
    })
    .otherwise({
      redirectTo: 'partials/error.html'
    })
});

app.controller('HomeController', function($scope) {
  $scope.name = 'Harrison';
});

app.controller('AccountsController', function($scope, $http) {
  $http.get("http://localhost:9999/api/getAccounts")
    .success(function(response) {
      $scope.accounts = response;
  });
  $http.get("http://localhost:9999/api/getNames")
    .success(function(response) {
      $scope.names = response;
  });
});

app.filter('filterByWholeFoods', function() {
  return function(input) {
    console.log('testttttt');
    console.log('inputs is ' + input);
    return input;
  }
});
