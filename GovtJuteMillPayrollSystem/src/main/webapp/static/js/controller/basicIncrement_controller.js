'use strict';

app.factory('BasicIncrement', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/GovtJuteMillPayrollSystem/basicIncrement/basicIncrement/:incrementId', {incrementId: '@incrementId'},
                {
                    updateObject: {method: 'PUT'}
                }
        );
    }]);

app.controller('BasicIncrementController', ['$scope', 'BasicIncrement', function ($scope, BasicIncrement) {
        var ob = this;
        ob.objArray = [];
        ob.obj = new BasicIncrement();
        ob.fetchAllObject = function () {
            ob.objArray = BasicIncrement.query();
        };
        ob.fetchAllObject();
        ob.addObject = function () {
            console.log('Inside save');
            if ($scope.objForm.$valid) {
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
            ob.obj = BasicIncrement.get({incrementId: id}, function () {
                ob.flag = 'edit';
            });
        };
        ob.updateObjectDetail = function () {
            console.log('Inside update');
            if ($scope.objForm.$valid) {
                ob.obj.$updateObject(function (object) {
                    console.log(object);
                    ob.updatedId = object.incrementId;
                    ob.reset();
                    ob.flag = 'updated';
                    ob.fetchAllObject();
                });
            }
        };
        ob.deleteObject = function (id) {
            console.log('Inside delete');
            ob.obj = BasicIncrement.delete({incrementId: id}, function () {
                ob.reset();
                ob.flag = 'deleted';
                ob.fetchAllObject();
            });
        };
        ob.reset = function () {
            ob.obj = new BasicIncrement();
            $scope.objForm.$setPristine();
        };
        ob.cancelUpdate = function (id) {
            ob.obj = new BasicIncrement();
            ob.flag = '';
            ob.fetchAllObject();
        };
    }]);


