'use strict';

angular.module('marketApp').controller('UserController',
    ['UserService', '$scope',  function( UserService, $scope) {

        var self = this;
        self.user = {};
        self.projectDTO={};
        self.bidDTO={};

        self.submit = submit;
        self.getProjectByName = getProjectByName;
        self.getBidByEngineerName = getBidByEngineerName;
        self.reset = reset;
        self.initial = initial;
        self.assign = assign;

        self.successMessage = '';
        self.errorMessage = '';
        self.done = false;

        self.onlyIntegers = /^\d+$/;
        self.onlyNumbers = /^\d+([,.]\d+)?$/;

        function submit() {
            console.log('Submitting');
            
            console.log("load projects and bids of user");
            UserService.findProjectByName(self.user.name)
                .then(
                    function (response) {
                        console.log('Project displayed successfully');
                        self.successMessage = 'Project displayed successfully';
                        self.errorMessage='';
                        self.done = true;
                        self.user={};
                        self.projectDTO={};
                        $scope.myForm.$setPristine();
                    },
                    function (errResponse) {
                        console.error('Error while displaying Project');
                        self.errorMessage = 'Error while displaying Project: ' + errResponse.data.errorMessage;
                        self.successMessage='';
                    }
                );
            
            UserService.findBidByEngineerName(self.user.name)
            .then(
                function (response) {
                    console.log('Bid displayed successfully');
                    self.successMessage = 'Bid displayed successfully';
                    self.errorMessage='';
                    self.done = true;
                    self.user={};
                    self.bidDTO={};
                    $scope.myForm.$setPristine();
                },
                function (errResponse) {
                    console.error('Error while displaying Bid');
                    self.errorMessage = 'Error while displaying Bid: ' + errResponse.data.errorMessage;
                    self.successMessage='';
                }
            );
                        
        }

        function getProjectByName(){
            return UserService.getProjectByName();
        }

        function getBidByEngineerName(){
            return UserService.getBidByEngineerName();
        }
        
        function reset(){
            self.successMessage='';
            self.errorMessage='';
            self.user={};
            self.projectDTO={};
            self.bidDTO={}
            $scope.myForm.$setPristine(); //reset Form
        }
        
        
        function initial(){
            console.log("load person, project, bid data for test");
            UserService.initial()
            .then(
                    function (response) {
                        console.log('Load person, project, bid data successfully');
                        self.successMessage = 'Load person, project, bid data successfully';
                        self.errorMessage='';
                        self.done = true;
                        $scope.myForm.$setPristine();
                    },
                    function (errResponse) {
                        console.error('Error while load person, project, bid data');
                        self.errorMessage = 'Error while load person, project, bid data: ' + errResponse.data.errorMessage;
                        self.successMessage='';
                    }
                );
        }

        function assign(){
            console.log("auto assign");
            UserService.assign()
            .then(
                    function (response) {
                        console.log('Auto assign successfully');
                        self.successMessage = 'Auto assign successfully';
                        self.errorMessage='';
                        self.done = true;
                        $scope.myForm.$setPristine();
                    },
                    function (errResponse) {
                        console.error('Error while auto assign');
                        self.errorMessage = 'Error while auto assign: ' + errResponse.data.errorMessage;
                        self.successMessage='';
                    }
                );
        }
    }


    ]);