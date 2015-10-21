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
  return function(transaction) {
    console.log('testttttt');
    console.log('inputs is ' + input);
    if (transaction === 'Whole Foods') {
      return transaction;
    }
    return 'Not Whole Foods';
  }
});

app.filter('filterList', function() {
  return function(transacitons) {
    console.log('filter list' + transacitons);
    var out = [];
    for (i = 0; i < transacitons.length; i++) {
      if (transacitons[i].location === 'Arcade') {
        out.push(transacitons[i]);
      }
    }
    return transacitons;
  }
});

app.filter('filterByKeyWord', function() {
  return function(input) {
    var response = [];
    angular.forEach(input, function(thing){
      if (thing == 'search') {
        response.push(thing);
      }
    })
    return response;
  }
});
