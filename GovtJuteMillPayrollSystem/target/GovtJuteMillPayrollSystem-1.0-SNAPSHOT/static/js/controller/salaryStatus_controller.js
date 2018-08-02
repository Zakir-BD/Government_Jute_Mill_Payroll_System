'use strict';

app.factory('SalaryStatus', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/GovtJuteMillPayrollSystem/salaryStatus/salaryStatus/:salaryStatusId', {salaryStatusId: '@salaryStatusId'},
                {
                    updateObject: {method: 'PUT'}
                }
        );
    }]);

app.controller('SalaryStatusController', ['$scope', 'SalaryStatus', function ($scope, SalaryStatus) {
        var ob = this;
        ob.objArray = [];
        ob.obj = new SalaryStatus();
        ob.fetchAllObject = function () {
            ob.objArray = SalaryStatus.query();
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
            ob.obj = SalaryStatus.get({salaryStatusId: id}, function () {
                ob.flag = 'edit';
            });
        };
        ob.updateObjectDetail = function () {
            console.log('Inside update');
            if ($scope.objForm.$valid) {
                ob.obj.$updateObject(function (object) {
                    console.log(object);
                    ob.updatedId = object.salaryStatusId;
                    ob.reset();
                    ob.flag = 'updated';
                    ob.fetchAllObject();
                });
            }
        };
        ob.deleteObject = function (id) {
            console.log('Inside delete');
            ob.obj = SalaryStatus.delete({salaryStatusId: id}, function () {
                ob.reset();
                ob.flag = 'deleted';
                ob.fetchAllObject();
            });
        };
        ob.reset = function () {
            ob.obj = new SalaryStatus();
            $scope.objForm.$setPristine();
        };
        ob.cancelUpdate = function (id) {
            ob.obj = new SalaryStatus();
            ob.flag = '';
            ob.fetchAllObject();
        };
    }]);


