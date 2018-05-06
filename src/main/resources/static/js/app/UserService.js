'use strict';

angular.module('marketApp').factory('UserService',
    ['$localStorage', '$http', '$q', 'urls',
        function ($localStorage, $http, $q, urls) {

            var factory = {
            		
                findProjectByName: findProjectByName,
                getProjectByName: getProjectByName,
                findBidByEngineerName: findBidByEngineerName,
                getBidByEngineerName: getBidByEngineerName,
                initial: initial,
                assign: assign,

            };

            return factory;

            
            function findProjectByName(searchKey) {
            	console.log('Fetch projects of person');
            	var deferred = $q.defer();
            	$http.get(urls.BASE + '/rest/service/projects?name=' + searchKey)
            		.then(
            			function (response) {
            				console.log('Fetch successfully projects of person');
            				$localStorage.projectDTO = response.data;
            				deferred.resolve(response);
            			},
            			function(errResponse) {
            				console.error("Errors when fetch projects of person");
            				deferred.reject(errResponse);
            			}
            		);
            	return deferred.promise;
            }
            
            function getProjectByName(){
                return $localStorage.projectDTO;
            }
            
            function findBidByEngineerName(searchKey) {
            	console.log('Fetch bids of person');
            	var deferred = $q.defer();
            	$http.get(urls.BASE + '/rest/service/bidsByPerson?name=' + searchKey)
            		.then(
            			function (response) {
            				console.log('Fetch successfully bids of person');
            				$localStorage.bidDTO = response.data;
            				deferred.resolve(response);
            			},
            			function(errResponse) {
            				console.error("Errors when fetch bids of person");
            				deferred.reject(errResponse);
            			}
            		);
            	return deferred.promise;
            }
            
            function getBidByEngineerName(){
                return $localStorage.bidDTO;
            }
            
            
            function initial() {
            	console.log('Init test data');
            	var deferred = $q.defer();
            	$http.post(urls.BASE + '/rest/service/initial')
        		.then(
            			function (response) {
            				console.log('Init test data successfully');
            				deferred.resolve(response);
            			},
            			function(errResponse) {
            				console.error("Errors when Init test data");
            				deferred.reject(errResponse);
            			}
            		);
            	return deferred.promise;
            }
            
            function assign() {
            	console.log('Automatically assign');
            	var deferred = $q.defer();
            	$http.post(urls.BASE + '/rest/service/assign')
        		.then(
            			function (response) {
            				console.log('Automatically assign successfully');
            				deferred.resolve(response);
            			},
            			function(errResponse) {
            				console.error("Errors when Automatically assign");
            				deferred.reject(errResponse);
            			}
            		);
            	return deferred.promise;
            }

            
        }
    ]);