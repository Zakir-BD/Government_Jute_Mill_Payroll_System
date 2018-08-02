'use strict';

app.factory('MasterData', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/GovtJuteMillPayrollSystem/masterData/masterData/:employeeId', {employeeId: '@employeeId'},
                {
                    updateObject: {method: 'PUT'}
                }
        );
    }]);
app.factory('User', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/GovtJuteMillPayrollSystem/user/user/:userId', {userId: '@userId'},
                {
                    updateObject: {method: 'PUT'}
                }
        );
    }]);

app.controller('UserController', ['$scope', 'User', 'MasterData', function ($scope, User, MasterData) {
        var ob = this;
        ob.objArray = [];
        ob.objArray2 = [];
        ob.obj = new User();
        ob.obj2 = new MasterData();
        ob.fetchAllObject = function () {
            ob.objArray = User.query();
            $scope.masterData = ob.objArray2 = MasterData.query();
        };

        console.log($scope.names + "hello");
        ob.fetchAllObject();
        ob.addObject = function () {
            console.log('Inside save');
            if ($scope.objForm.$valid) {
                //ob.obj.tspInfo= ob.obj2;
                ob.obj.$save(function (object) {
                    console.log(object);
                    ob.flag = 'created';
                    ob.reset();
                    ob.fetchAllObject();
                },
                        function (err) {
                            console.log(err.status);
                            ob.flag = 'failed';
                        }
                );
            }
        };
        ob.editObject = function (id) {
            console.log('Inside edit');
            ob.obj = User.get({userId: id}, function () {
                ob.flag = 'edit';
            });
        };
        ob.updateObjectDetail = function () {
            console.log('Inside update');
            if ($scope.objForm.$valid) {
                ob.obj.$updateObject(function (object) {
                    console.log(object);
                    ob.updatedId = object.userId;
                    ob.reset();
                    ob.flag = 'updated';
                    ob.fetchAllObject();
                });
            }
        };
        ob.deleteObject = function (id) {
            console.log('Inside delete');
            ob.obj = User.delete({userId: id}, function () {
                ob.reset();
                ob.flag = 'deleted';
                ob.fetchAllObject();
            });
        };
        ob.reset = function () {
            ob.obj = new User();
            $scope.objForm.$setPristine();
        };
        ob.cancelUpdate = function (id) {
            ob.obj = new User();
            ob.flag = '';
            ob.fetchAllObject();
        };
    }]);


