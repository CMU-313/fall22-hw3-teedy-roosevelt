'use strict';

/**
 * Settings monitoring controller.
 */
angular.module('docs').controller('SettingsReviewScore', function($scope, Restangular) {
  Restangular.one('user_rating').get().then(function(data) {
    $scope.user_rating = data;
    console.log('scope is', $scope);
  });

  $scope.drawGraph = function() {

    var data = $scope.user_rating.ratings;
    console.log($scope.user_rating.ratings);

    var labels = [];
    var sets = [];
    angular.forEach(data, function(data){
      labels.push(data.username + "/" + data.docId);
      sets.push(data.avgRating);
    });
    console.log(labels);
    console.log(sets);
    
    var barData = {
      labels: labels,
      datasets: [
        {
          label: "Average rating for user/docId",
          backgroundColor: ["#3e95cd", "#8e5ea2","#3cba9f","#e8c3b9","#c45850"],
          data: sets
        }
      ]
    };
    
    var countries = document.getElementById('bar-chart').getContext('2d');
    new Chart(countries, {
        type: "bar",
        data: barData, 
        options: {
          legend: { display: false },
          title: {
            display: true,
            text: 'Predicted world population (millions) in 2050'
          },
          indexAxis: 'y',
        }
    });
  }
});