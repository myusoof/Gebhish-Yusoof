'use strict';

prodCatAdminApp.factory("stateService", function(){
   return {
       user: "Mighty Mouse",
       error: {
           httpCode: null,
           errorCode: null,
           message: null,
           stackTrace: null
       }
   };
});