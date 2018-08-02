'use strict';

app.factory('JobType', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/GovtJuteMillPayrollSystem/jobType/jobType/:jobTypeId', {jobTypeId: '@jobTypeId'},
                {
                    updateObject: {method: 'PUT'}
                }
        );
    }]);
app.controller('JobTypeController', ['$scope', 'JobType', function ($scope, JobType) {
        var ob = this;
        ob.objArray = [];
        ob.obj = new JobType();
        ob.fetchAllObject = function () {
            ob.objArray = JobType.query();
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
            ob.obj = JobType.get({jobTypeId: id}, function () {
                ob.flag = 'edit';
            });
        };
        ob.updateObjectDetail = function () {
            console.log('Inside update');
            if ($scope.objForm.$valid) {
                ob.obj.$updateObject(function (object) {
                    console.log(object);
                    ob.updatedId = object.jobTypeId;
                    ob.reset();
                    ob.flag = 'updated';
                    ob.fetchAllObject();
                });
            }
        };
        ob.deleteObject = function (id) {
            console.log('Inside delete');
            ob.obj = JobType.delete({jobTypeId: id}, function () {
                ob.reset();
                ob.flag = 'deleted';
                ob.fetchAllObject();
            });
        };
        ob.reset = function () {
            ob.obj = new JobType();
            $scope.objForm.$setPristine();
        };
        ob.cancelUpdate = function (id) {
            ob.obj = new JobType();
            ob.flag = '';
            ob.fetchAllObject();
        };
    }]);


