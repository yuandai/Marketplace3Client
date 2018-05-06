var app = angular.module('marketApp',['ui.router','ngStorage']);

app.constant('urls', {
    BASE: 'http://localhost:8080/MarketPlace',
});

app.config(['$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider) {

        $stateProvider
            .state('home', {
                url: '/',
                templateUrl: 'partials/list',
                controller:'UserController',
                controllerAs:'ctrl',
                resolve: {
                }
            });
        $urlRouterProvider.otherwise('/');
    }]);

