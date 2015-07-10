var app = angular.module("personal-calendar", []);
app.controller("CalendarCtrl", function ($scope, $http) {
  $http
    .get("/currentWeek")
    .success(function (result) {
      $scope.days = result;
    });
});