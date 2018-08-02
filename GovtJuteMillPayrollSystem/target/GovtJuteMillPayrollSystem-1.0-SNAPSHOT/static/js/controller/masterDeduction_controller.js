'use strict';


app.factory('MasterData', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/GovtJuteMillPayrollSystem/masterData/masterData/:employeeId', {employeeId: '@employeeId'},
                {
                    updateObject: {method: 'PUT'}
                }
        );
    }]);

app.factory('House', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/GovtJuteMillPayrollSystem/house/house/:houseId', {houseId: '@houseId'},
                {
                    updateObject: {method: 'PUT'}
                }
        );
    }]);
app.factory('MasterDeduction', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/GovtJuteMillPayrollSystem/masterDeduction/masterDeduction/:masterDeductionId', {masterDeductionId: '@masterDeductionId'},
                {
                    updateObject: {method: 'PUT'}
                }
        );
    }]);
app.controller('MasterDeductionController', ['$scope', 'MasterDeduction', 'MasterData', 'House', function ($scope, MasterDeduction, MasterData, House) {
        var ob = this;
        ob.objArray = [];
        ob.objArray2 = [];
        ob.objArray3 = [];
        ob.obj = new MasterDeduction();
        ob.obj2 = new MasterData();
        ob.obj3 = new House();

        ob.fetchAllObject = function () {
            ob.objArray = MasterDeduction.query();
            $scope.masterData = ob.objArray2 = MasterData.query();
            $scope.house = ob.objArray3 = House.query();
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
            ob.obj = MasterDeduction.get({masterDeductionId: id}, function () {
                ob.flag = 'edit';
            });
        };
        ob.updateObjectDetail = function () {
            console.log('Inside update');
            if ($scope.objForm.$valid) {
                ob.obj.$updateObject(function (object) {
                    console.log(object);
                    ob.updatedId = object.masterDeductionId;
                    ob.reset();
                    ob.flag = 'updated';
                    ob.fetchAllObject();
                });
            }
        };
        ob.deleteObject = function (id) {
            console.log('Inside delete');
            ob.obj = MasterDeduction.delete({masterDeductionId: id}, function () {
                ob.reset();
                ob.flag = 'deleted';
                ob.fetchAllObject();
            });
        };
        ob.reset = function () {
            ob.obj = new MasterDeduction();
            $scope.objForm.$setPristine();
        };
        ob.cancelUpdate = function (id) {
            ob.obj = new MasterDeduction();
            ob.flag = '';
            ob.fetchAllObject();
        };
    }]);


