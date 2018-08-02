'use strict';


app.factory('MasterData', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/GovtJuteMillPayrollSystem/masterData/masterData/:employeeId', {employeeId: '@employeeId'},
                {
                    updateObject: {method: 'PUT'}
                }
        );
    }]);


app.factory('SalaryTran', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/GovtJuteMillPayrollSystem/salaryTran/salaryTran/:salaryTranId', {salaryTranId: '@salaryTranId'},
                {
                    updateObject: {method: 'PUT'}
                }
        );
    }]);

app.controller('SalaryTranController', ['$scope', 'SalaryTran', 'MasterData', function ($scope, SalaryTran, MasterData) {
        var ob = this;
        ob.objArray = [];
        ob.objArray2 = [];
        ob.obj = new SalaryTran();
        ob.obj2 = new MasterData();
        ob.fetchAllObject = function () {
            ob.objArray = SalaryTran.query();
            $scope.masterData = ob.objArray2 = MasterData.query();

        };
        //$scope.names = ob.objArray2;
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
            ob.obj = SalaryTran.get({salaryTranId: id}, function () {
                ob.flag = 'edit';
            });
        };
        ob.updateObjectDetail = function () {
            console.log('Inside update');
            if ($scope.objForm.$valid) {
                ob.obj.$updateObject(function (object) {
                    console.log(object);
                    ob.updatedId = object.salaryTranId;
                    ob.reset();
                    ob.flag = 'updated';
                    ob.fetchAllObject();
                });
            }
        };
        ob.deleteObject = function (id) {
            console.log('Inside delete');
            ob.obj = SalaryTran.delete({salaryTranId: id}, function () {
                ob.reset();
                ob.flag = 'deleted';
                ob.fetchAllObject();
            });
        };
        ob.reset = function () {
            ob.obj = new SalaryTran();
            $scope.objForm.$setPristine();
        };
        ob.cancelUpdate = function (id) {
            ob.obj = new SalaryTran();
            ob.flag = '';
            ob.fetchAllObject();
        };
    }]);


