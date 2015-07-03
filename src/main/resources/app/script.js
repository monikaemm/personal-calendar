var app = angular.module("personal-calendar", []);
app.controller("CalendarCtrl", function ($scope) {
  $scope.days = [
      {number:6,name:"pon"},
      {number:7,name:"wt"},
      {number:8,name:"sr"},
      {number:9,name:"czw"},
      {number:10,name:"pt"},
      {number:11,name:"sob",weekend:true},
      {number:12,name:"nd",weekend:true}
  ];
});