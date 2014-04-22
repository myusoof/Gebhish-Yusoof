'use strict';

/* App Module */

var prodCatAdminApp = angular.module('prodCatAdminApp', [
    'ngRoute'
]);

prodCatAdminApp.config(['$routeProvider',
    function ($routeProvider) {
        $routeProvider.
            when('/test', {
                templateUrl: 'templates/home.html',
                controller: 'homeCtrl'
            }).
            when('/error', {
                templateUrl: 'templates/error.html',
                controller: 'errorCtrl'
            }).
            otherwise({
                templateUrl: 'templates/home.html',
                controller: 'homeCtrl'
            });
    }]);


prodCatAdminApp.factory('errorInterceptor', ['$q', '$rootScope','$location', 'stateService',
    function ($q, $rootScope, $location, stateService) {
        return function (promise) {
            return promise.then(function (response) {
                return response;
            }, function (response) {
                stateService.error.httpCode = response.status;
                if (response.data) {
                    stateService.error.errorCode = response.data.code;
                    stateService.error.message = response.data.message;
                    stateService.error.stackTrace = response.data.stackTrace;
                }
                $location.path('/error');
                /*

                switch (errorType) {
                    case 'TransactionError':
                        $rootScope.$emit('transaction-error', 'An error occurred!');
                        break;
                    case 'CustomerError':
                        $rootScope.$emit('customer-error', 'An error occurred!');
                        break;

                }
*/
                return $q.reject(response);
            });
        }
    }]);

prodCatAdminApp.config(function ($httpProvider) {
    $httpProvider.responseInterceptors.push('errorInterceptor');
});