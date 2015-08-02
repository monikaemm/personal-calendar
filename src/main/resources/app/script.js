var app = angular.module("personal-calendar", []);
app.controller("CalendarCtrl", function ($scope, $http) {
  function fetchTasks(dayOfMonth) {
    $http
      .get("/task", {params: {day: dayOfMonth}})
      .success(function (result) {
        $scope.tasks = result;
      });
  }

  $scope.showTasks = function (day) {
    if ($scope.tasksDay != day.dayOfWeek) {
      $scope.tasksVisible = true;
      $scope.tasksDay = day.dayOfWeek;
      fetchTasks(day.dayOfMonth);
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