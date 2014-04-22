prodCatAdminApp.controller('menuCtrl', [
    '$scope',
    'stateService',
    function ($scope, stateService) {
        $scope.user = stateService.user;
    }
]);