'use strict';

/**
 * Settings monitoring controller.
 */
angular.module('docs').controller('SettingsReviewScore', function($scope, Restangular) {
  Restangular.one('app').get().then(function(data) {
    $scope.app = data;
    console.log('scope is', $scope);
  });
});