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

  $scope.loginData = {};

  $scope.loginUser = function(){
    $http
        .get("/login", {params: {login: $scope.loginData.login, password: $scope.loginData.password}})
        .success(function (user){
            if(user!="null"){
                $scope.userLogged = true;
                $scope.loginError = "";
                $scope.loginData = {};
            }
            else{
                $scope.userLogged = false;
                $scope.loginError = "Zly login lub haslo";
            }
        });

  };
  $scope.logoutUser = function(){
   $scope.userLogged = false;
  }

  $http
    .get("/currentWeek")
    .success(function (result) {
      $scope.days = result;
    });
});