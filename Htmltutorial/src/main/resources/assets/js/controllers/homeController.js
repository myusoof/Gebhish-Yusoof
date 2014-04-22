'use strict';

prodCatAdminApp.controller('homeCtrl', [
    '$scope',
    '$http',
    'stateService',
    function ($scope, $http, stateService) {



        $scope.user = stateService.user;

        $scope.onLearnMore = function(){
            $http.get('/service/error/500')
                .then(function (result) {
                    alert('this should never happen');
                });
        };

        $scope.onAbout = function(){
            $http.get('/service/error/400')
                .then(function (result) {
                    alert('this should never happen');
                });
        };



        $http.get('/service')
            .then(function (result) {

                $scope.test = result.data;

            }, function (error) {
                alert("some error");
            });
    }
]);


