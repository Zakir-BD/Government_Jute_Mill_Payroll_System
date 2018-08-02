'use strict';

app.factory('BasicGrade', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/GovtJuteMillPayrollSystem/basicGrade/basicGrade/:gradeId', {gradeId: '@gradeId'},
                {
                    updateObject: {method: 'PUT'}
                }
        );
    }]);

app.controller('BasicGradeController', ['$scope', 'BasicGrade', function ($scope, BasicGrade) {
        var ob = this;
        ob.objArray = [];
        ob.obj = new BasicGrade();
        ob.fetchAllObject = function () {
            ob.objArray = BasicGrade.query();
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
            ob.obj = BasicGrade.get({gradeId: id}, function () {
                ob.flag = 'edit';
            });
        };
        ob.updateObjectDetail = function () {
            console.log('Inside update');
            if ($scope.objForm.$valid) {
                ob.obj.$updateObject(function (object) {
                    console.log(object);
                    ob.updatedId = object.gradeId;
                    ob.reset();
                    ob.flag = 'updated';
                    ob.fetchAllObject();
                });
            }
        };
        ob.deleteObject = function (id) {
            console.log('Inside delete');
            ob.obj = BasicGrade.delete({gradeId: id}, function () {
                ob.reset();
                ob.flag = 'deleted';
                ob.fetchAllObject();
            });
        };
        ob.reset = function () {
            ob.obj = new BasicGrade();
            $scope.objForm.$setPristine();
        };
        ob.cancelUpdate = function (id) {
            ob.obj = new BasicGrade();
            ob.flag = '';
            ob.fetchAllObject();
        };
    }]);


