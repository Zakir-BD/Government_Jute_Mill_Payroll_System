'use strict';

app.factory('Department', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/GovtJuteMillPayrollSystem/department/department/:departmentId', {departmentId: '@departmentId'},
                {
                    updateObject: {method: 'PUT'}
                }
        );
    }]);

app.controller('DepartmentController', ['$scope', 'Department', function ($scope, Department) {
        var ob = this;
        ob.objArray = [];
        ob.obj = new Department();
        ob.fetchAllObject = function () {
            ob.objArray = Department.query();
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
            ob.obj = Department.get({departmentId: id}, function () {
                ob.flag = 'edit';
            });
        };
        ob.updateObjectDetail = function () {
            console.log('Inside update');
            if ($scope.objForm.$valid) {
                ob.obj.$updateObject(function (object) {
                    console.log(object);
                    ob.updatedId = object.departmentId;
                    ob.reset();
                    ob.flag = 'updated';
                    ob.fetchAllObject();
                });
            }
        };
        ob.deleteObject = function (id) {
            console.log('Inside delete');
            ob.obj = Department.delete({departmentId: id}, function () {
                ob.reset();
                ob.flag = 'deleted';
                ob.fetchAllObject();
            });
        };
        ob.reset = function () {
            ob.obj = new Department();
            $scope.objForm.$setPristine();
        };
        ob.cancelUpdate = function (id) {
            ob.obj = new Department();
            ob.flag = '';
            ob.fetchAllObject();
        };
    }]);


