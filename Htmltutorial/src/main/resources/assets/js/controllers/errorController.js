'use strict';

prodCatAdminApp.controller('errorCtrl', [
    '$scope',
    'stateService',
    '$location',
    function ($scope, stateService, $location) {

        if (stateService.error.httpCode == null){
            $location.path("/");
            return;
        }

        $scope.error = stateService.error;


    }
]);