'use strict';

app.factory('JobStatus', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/GovtJuteMillPayrollSystem/jobStatus/jobStatus/:jobStatusId', {jobStatusId: '@jobStatusId'},
                {
                    updateObject: {method: 'PUT'}
                }
        );
    }]);

app.controller('JobStatusController', ['$scope', 'JobStatus', function ($scope, JobStatus) {
        var ob = this;
        ob.objArray = [];
        ob.obj = new JobStatus();
        ob.fetchAllObject = function () {
            ob.objArray = JobStatus.query();
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
            ob.obj = JobStatus.get({jobStatusId: id}, function () {
                ob.flag = 'edit';
            });
        };
        ob.updateObjectDetail = function () {
            console.log('Inside update');
            if ($scope.objForm.$valid) {
                ob.obj.$updateObject(function (object) {
                    console.log(object);
                    ob.updatedId = object.jobStatusId;
                    ob.reset();
                    ob.flag = 'updated';
                    ob.fetchAllObject();
                });
            }
        };
        ob.deleteObject = function (id) {
            console.log('Inside delete');
            ob.obj = JobStatus.delete({jobStatusId: id}, function () {
                ob.reset();
                ob.flag = 'deleted';
                ob.fetchAllObject();
            });
        };
        ob.reset = function () {
            ob.obj = new JobStatus();
            $scope.objForm.$setPristine();
        };
        ob.cancelUpdate = function (id) {
            ob.obj = new JobStatus();
            ob.flag = '';
            ob.fetchAllObject();
        };
    }]);


