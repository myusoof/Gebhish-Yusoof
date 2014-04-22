'use strict';

describe('HomeController tests', function(){
   beforeEach(module('prodCatAdminApp'));

    var stateService;

    var scope;

    beforeEach(inject(function($injector, $rootScope){
        stateService = $injector.get('stateService');
        scope = $rootScope.$new();

        stateService.user = "testuser"

    }));

    it('home to display user name', inject(function($controller, $q) {
        var controller =  $controller('homeCtrl',{'$scope': scope, $q: $q});

        expect(scope.user).toBe("testuser");
    }));
});