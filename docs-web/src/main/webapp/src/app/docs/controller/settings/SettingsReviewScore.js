'use strict';

/**
 * Settings monitoring controller.
 */
angular.module('docs').controller('SettingsReviewScore', function($scope, Restangular) {
  console.log('first scope', $scope)
  Restangular.one('user_rating').get().then(function(data) {
    $scope.user_rating = data;
    console.log('scope is', $scope);
  });

  let curr_chart = undefined;

  $scope.drawGraph = function() {
    let search_bar_text = `Displaying all users`;
    if ($scope.searchUser != undefined && $scope.searchUser != '') {
      search_bar_text = `Displaying "${$scope.searchUser}"`;
    }
    console.log('searchUser is', $scope.searchUser);

    //need to destroy previous instances to curr chart
    //so that charts can use unique IDs
    if (curr_chart != undefined){
      curr_chart.destroy();
    }

    document.getElementById("search-bar-text").innerHTML = search_bar_text;
    var data = $scope.user_rating.ratings;

    console.log('data is', data);
    //now we want to manipulate data to correspond with the search results
    var new_data = [];
    let curr_search = $scope.searchUser;
    if (curr_search != undefined) {
      let curr_search = $scope.searchUser.toLowerCase();
      for (let i = 0; i < data.length; i++) {
          let curr_username = data[i].username.toLowerCase();
          if (curr_username.includes(curr_search)) {
            new_data.push(data[i]);
          }
      }
      if (new_data.length != 0) {
        data = new_data;
      }else {
        document.getElementById("search-bar-text").innerHTML = `No users for "${curr_search}", displaying all users`;
      }

    }


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
    

    var user_data = document.getElementById('bar-chart').getContext('2d');
    curr_chart = new Chart(user_data, {
        type: "bar",
        data: barData, 
        options: {
          legend: { display: false },
          title: {
            display: true,
          },
          indexAxis: 'y',
        }
    });
  }
});