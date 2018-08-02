'use strict';

app.factory('BasicGrade', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/GovtJuteMillPayrollSystem/basicGrade/basicGrade/:gradeId', {gradeId: '@gradeId'},
                {
                    updateObject: {method: 'PUT'}
                }
        );
    }]);

app.factory('BasicIncrement', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/GovtJuteMillPayrollSystem/basicIncrement/basicIncrement/:incrementId', {incrementId: '@incrementId'},
                {
                    updateObject: {method: 'PUT'}
                }
        );
    }]);

app.factory('BasicMaster', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/GovtJuteMillPayrollSystem/basicMaster/basicMaster/:basicId', {basicId: '@basicId'},
                {
                    updateObject: {method: 'PUT'}
                }
        );
    }]);

app.controller('BasicMasterController', ['$scope', 'BasicMaster', 'BasicGrade', 'BasicIncrement', function ($scope, BasicMaster, BasicGrade, BasicIncrement) {
        var ob = this;
        ob.objArray = [];
        ob.objArray2 = [];
        ob.objArray3 = [];
        ob.obj = new BasicMaster();
        ob.obj2 = new BasicGrade();
        ob.obj3 = new BasicIncrement();
        ob.fetchAllObject = function () {
            ob.objArray = BasicMaster.query();
            $scope.basicGrade = ob.objArray2 = BasicGrade.query();
            $scope.basicIncrement = ob.objArray3 = BasicIncrement.query();

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
            ob.obj = BasicMaster.get({basicId: id}, function () {
                ob.flag = 'edit';
            });
        };
        ob.updateObjectDetail = function () {
            console.log('Inside update');
            if ($scope.objForm.$valid) {
                ob.obj.$updateObject(function (object) {
                    console.log(object);
                    ob.updatedId = object.basicId;
                    ob.reset();
                    ob.flag = 'updated';
                    ob.fetchAllObject();
                });
            }
        };
        ob.deleteObject = function (id) {
            console.log('Inside delete');
            ob.obj = BasicMaster.delete({basicId: id}, function () {
                ob.reset();
                ob.flag = 'deleted';
                ob.fetchAllObject();
            });
        };
        ob.reset = function () {
            ob.obj = new BasicMaster();
            $scope.objForm.$setPristine();
        };
        ob.cancelUpdate = function (id) {
            ob.obj = new BasicMaster();
            ob.flag = '';
            ob.fetchAllObject();
        };
    }]);


