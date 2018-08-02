'use strict';

app.factory('Mill', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/GovtJuteMillPayrollSystem/mill/mill/:millId', {millId: '@millId'},
                {
                    updateObject: {method: 'PUT'}
                }
        );
    }]);

app.controller('MillController', ['$scope', 'Mill', function ($scope, Mill) {
        var ob = this;
        ob.objArray = [];
        ob.obj = new Mill();
        ob.fetchAllObject = function () {
            ob.objArray = Mill.query();
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
            ob.obj = Mill.get({millId: id}, function () {
                ob.flag = 'edit';
            });
        };
        ob.updateObjectDetail = function () {
            console.log('Inside update');
            if ($scope.objForm.$valid) {
                ob.obj.$updateObject(function (object) {
                    console.log(object);
                    ob.updatedId = object.millId;
                    ob.reset();
                    ob.flag = 'updated';
                    ob.fetchAllObject();
                });
            }
        };
        ob.deleteObject = function (id) {
            console.log('Inside delete');
            ob.obj = Mill.delete({millId: id}, function () {
                ob.reset();
                ob.flag = 'deleted';
                ob.fetchAllObject();
            });
        };
        ob.reset = function () {
            ob.obj = new Mill();
            $scope.objForm.$setPristine();
        };
        ob.cancelUpdate = function (id) {
            ob.obj = new Mill();
            ob.flag = '';
            ob.fetchAllObject();
        };
    }]);


