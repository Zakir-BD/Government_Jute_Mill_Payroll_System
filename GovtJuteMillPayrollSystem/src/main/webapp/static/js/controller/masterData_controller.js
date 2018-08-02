'use strict';


app.factory('MasterData', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/GovtJuteMillPayrollSystem/masterData/masterData/:employeeId', {employeeId: '@employeeId'},
                {
                    updateObject: {method: 'PUT'}
                }
        );
    }]);

app.factory('Designation', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/GovtJuteMillPayrollSystem/designation/designation/:designationId', {designationId: '@designationId'},
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


app.factory('Mill', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/GovtJuteMillPayrollSystem/mill/mill/:millId', {millId: '@millId'},
                {
                    updateObject: {method: 'PUT'}
                }
        );
    }]);

app.factory('Department', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/GovtJuteMillPayrollSystem/department/department/:departmentId', {departmentId: '@departmentId'},
                {
                    updateObject: {method: 'PUT'}
                }
        );
    }]);

app.factory('JobType', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/GovtJuteMillPayrollSystem/jobType/jobType/:jobTypeId', {jobTypeId: '@jobTypeId'},
                {
                    updateObject: {method: 'PUT'}
                }
        );
    }]);

app.factory('JobStatus', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/GovtJuteMillPayrollSystem/jobStatus/jobStatus/:jobStatusId', {jobStatusId: '@jobStatusId'},
                {
                    updateObject: {method: 'PUT'}
                }
        );
    }]);

app.factory('SalaryStatus', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/GovtJuteMillPayrollSystem/salaryStatus/salaryStatus/:salaryStatusId', {salaryStatusId: '@salaryStatusId'},
                {
                    updateObject: {method: 'PUT'}
                }
        );
    }]);
//MasterData, Designation, BasicMaster, Mill, Department, JobType, JobStatus, SalaryStatus
app.controller('MasterDataController', ['$scope', 'MasterData', 'Designation', 'BasicMaster', 'Mill', 'Department','JobType','JobStatus','SalaryStatus', function ($scope, MasterData, Designation, BasicMaster, Mill, Department, JobType, JobStatus, SalaryStatus) {
        var ob = this;
        ob.objArray = [];
        ob.objArray2 = [];
        ob.objArray3 = [];
        ob.objArray4 = [];
        ob.objArray5 = [];
        ob.objArray6 = [];
        ob.objArray7 = [];
        ob.objArray8 = [];
        
        ob.obj = new MasterData();
        ob.obj2 = new Designation();
        ob.obj3 = new BasicMaster();
        ob.obj4 = new Mill();
        ob.obj5 = new Department();
        ob.obj6 = new JobType();
        ob.obj7 = new JobStatus();
        ob.obj8 = new SalaryStatus();
        
        ob.fetchAllObject = function () {
            ob.objArray = MasterData.query();
            $scope.designation = ob.objArray2 = Designation.query();
            $scope.basicMaster = ob.objArray3 = BasicMaster.query();
            $scope.mill = ob.objArray4 = Mill.query();
            $scope.department = ob.objArray5 = Department.query();
            $scope.jobType = ob.objArray6 = JobType.query();
            $scope.jobStatus = ob.objArray7 = JobStatus.query();
            $scope.salaryStatus = ob.objArray8 = SalaryStatus.query();
            
        };
//        $scope.ddd = ob.objArray2;
//        console.log($scope.designation + "hello");
//        console.log($scope.basicMaster + "hello");
//        console.log($scope.mill + "hello");
//        console.log($scope.department + "hello");
//        console.log($scope.jobType + "hello");
//        console.log($scope.jobStatus + "hello");
//        console.log($scope.salaryStatus + "hello");
//        
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
            ob.obj = MasterData.get({employeeId: id}, function () {
                ob.flag = 'edit';
            });
        };
        ob.updateObjectDetail = function () {
            console.log('Inside update');
            if ($scope.objForm.$valid) {
                ob.obj.$updateObject(function (object) {
                    console.log(object);
                    ob.updatedId = object.employeeId;
                    ob.reset();
                    ob.flag = 'updated';
                    ob.fetchAllObject();
                });
            }
        };
        ob.deleteObject = function (id) {
            console.log('Inside delete');
            ob.obj = MasterData.delete({employeeId: id}, function () {
                ob.reset();
                ob.flag = 'deleted';
                ob.fetchAllObject();
            });
        };
        ob.reset = function () {
            ob.obj = new MasterData();
            $scope.objForm.$setPristine();
        };
        ob.cancelUpdate = function (id) {
            ob.obj = new MasterData();
            ob.flag = '';
            ob.fetchAllObject();
        };
    }]);


