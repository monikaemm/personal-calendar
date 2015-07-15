var app = angular.module("personal-calendar", []);
app.controller("CalendarCtrl", function ($scope, $http) {
  $scope.showTasks = function (day) {
    if ($scope.tasksDay != day.dayOfWeek) {
      $scope.tasksVisible = true;
      $scope.tasksDay = day.dayOfWeek;
      $scope.tasks = ["jedno zadanie", "drugie zadanie"];
    }
    else {
      $scope.tasksVisible = false;
      $scope.tasksDay = undefined;
    }
  };

  $http
    .get("/currentWeek")
    .success(function (result) {
      $scope.days = result;
    });
});