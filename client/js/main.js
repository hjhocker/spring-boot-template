var app = angular.module('bankApp', ['ngRoute']);

app.config(function($routeProvider) {
  $routeProvider.when('/', {
    templateUrl: 'partials/home.html'
  })
});
