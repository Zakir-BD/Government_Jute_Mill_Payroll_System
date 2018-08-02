<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en-US">
    <head>
        <meta charset="UTF-8" /> 
        <title> SalaryTran </title>
    </head>
    <body ng-app="myApp">
        <div ng-controller="SalaryTranController as objCtrl">
            <h1> SalaryTran Info </h1>
            <form name="objForm" method="POST">
                <table>
                    <tr><td colspan="2">
                            <div ng-if="objCtrl.flag != 'edit'">
                                <h3> Add New SalaryTran </h3> 
                            </div>
                            <div ng-if="objCtrl.flag == 'edit'">
                                <h3> Update SalaryTran for ID: {{ objCtrl.obj.salaryTranId}} </h3> 
                            </div> </td>
                    </tr>
                    <tr>
                        <td>salaryTranMonth : </td>
                        <td><input type="text" date="yyyy-mm-dd" model="secondDate" name="salaryTranMonth" ng-model="objCtrl.obj.salaryTranMonth" required/> 
                            <span ng-show="objForm.salaryTranMonth.$error.required" class="msg-val">*</span>
                        </td>
                    </tr>
                    <tr>
                        <td>EmployeeID</td>
                        <td>
                            <select ng-model="objCtrl.obj.masterData" ng-options="x.employeeId for x in masterData"></select>
                        </td>
                    </tr>
                    <tr>
                        <td>EmployeeName</td>
                        <td>
                    <lablel for="name" ng-model="objCtrl.obj.masterData">{{objCtrl.obj.masterData.name}}</lablel>
                    </td>
                    </tr>
                    <tr>
                        <td>designationId</td>
                        <td>
                            <select ng-model="objCtrl.obj.masterData" ng-options="x.designation.designationId for x in masterData"></select>
                        </td>
                    </tr>
                    <tr>
                        <td>basicMain</td>
                        <td>
                            <select ng-model="objCtrl.obj.masterData" ng-options="x.basicMaster.basicMain for x in masterData"></select>
                        </td>
                    </tr>
                    <tr>
                        <td>millName</td>
                        <td>
                            <select ng-model="objCtrl.obj.masterData" ng-options="x.mill.millName for x in masterData"></select>
                        </td>
                    </tr>
                    <tr>
                        <td>departmentName</td>
                        <td>
                            <select ng-model="objCtrl.obj.masterData" ng-options="x.department.departmentName for x in masterData"></select>
                        </td>
                    </tr>
                    <tr>
                        <td>jobStatusName</td>
                        <td>
                            <select ng-model="objCtrl.obj.masterData" ng-options="x.jobStatus.jobStatusName for x in masterData"></select>
                        </td>
                    </tr>
                    <tr>
                        <td>salaryStatusName</td>
                        <td>
                            <select ng-model="objCtrl.obj.masterData" ng-options="x.salaryStatus.salaryStatusName for x in masterData"></select>
                        </td>
                    </tr>
                    <tr>
                        <td>jobTypeName</td>
                        <td>
                            <select ng-model="objCtrl.obj.masterData" ng-options="x.jobType.jobTypeName for x in masterData"></select>
                        </td>
                    </tr>
<!--                    <tr>
                        <td>houseName</td>
                        <td>
                            <select ng-model="objCtrl.obj.masterData" ng-options="x.masterDeduction.house.houseName for x in masterData"></select>
                        </td>
                    </tr>-->
                    <tr>
                        <td>houseName : </td>
                        <td><input type="text" name="houseName" ng-model="objCtrl.obj.houseName" required/> 
                            <span ng-show="objForm.houseName.$error.required" class="msg-val">*</span>
                        </td>
                    </tr>
                    <tr>
                        <td>workingDay : </td>
                        <td><input type="text" name="workingDay" ng-model="objCtrl.obj.workingDay" required/> 
                            <span ng-show="objForm.workingDay.$error.required" class="msg-val">*</span>
                        </td>
                    </tr>
                    <tr>
                        <td>leaveDay : </td>
                        <td> <input type="text" name="leaveDay" ng-model="objCtrl.obj.leaveDay" required/> 
                            <span ng-show="objForm.leaveDay.$error.required" class="msg-val">*</span>
                        </td>
                    </tr>
                    <tr>
                        <td>otHour : </td>
                        <td> <input type="text" name="otHour" ng-model="objCtrl.obj.otHour" required/> 
                            <span ng-show="objForm.otHour.$error.required" class="msg-val">*</span>
                        </td>
                    </tr>
                    <tr>
                        <td>encashDay : </td>
                        <td> <input type="text" name="encashDay" ng-model="objCtrl.obj.encashDay" required/> 
                            <span ng-show="objForm.encashDay.$error.required" class="msg-val">*</span>
                        </td>
                    </tr>

                    <tr>
                        <td colspan="2"> <span ng-if="objCtrl.flag == 'created'" class="msg-success">SalaryTran successfully added.</span>
                            <span ng-if="objCtrl.flag == 'failed'" class="msg-val">SalaryTran already exists.</span>
                        </td>
                    </tr>
                    <tr><td colspan="2">
                            <div ng-if="objCtrl.flag != 'edit'">
                                <input  type="submit" ng-click="objCtrl.addObject()" value="Add SalaryTran"/> 
                                <input type="button" ng-click="objCtrl.reset()" value="Reset"/>
                            </div>
                            <div ng-if="objCtrl.flag == 'edit'">
                                <input  type="submit" ng-click="objCtrl.updateObjectDetail()" value="Update SalaryTran"/> 	
                                <input type="button" ng-click="objCtrl.cancelUpdate()" value="Cancel"/>				   
                            </div> </td>
                    </tr>
                    <tr>
                        <td colspan="2"> <span ng-if="objCtrl.flag == 'deleted'" class="msg-success">Deleted.</span>
                    </tr>
                </table>     
            </form>
            <table>
                <tr> 
                    <th>EmployeeID </th> 
                    <th>salaryTranMonth</th> 
                    <th>name</th>
                    <th>designationName</th>
                    <th>basicMain</th>
                    <th>millName</th>
                    <th>departmentName</th>
                    <th>jobStatusName</th>
                    <th>salaryStatusName</th>
                    <th>jobTypeName</th>
                    <th>houseName</th>
                    <th>workingDay</th>
                    <th>leaveDay</th>
                    <th>otHour</th>
                    <th>encashDay</th>

                </tr>
                <tr ng-repeat="row in objCtrl.objArray| orderBy: 'masterData.employeeId'">
                    <td><span ng-bind="row.masterData.employeeId"></span></td>
                    <td><span ng-bind="row.salaryTranMonth"></span></td>
                    <td><span ng-bind="row.masterData.name"></span></td>
                    <td><span ng-bind="row.designationName"></span></td>
                    <td><span ng-bind="row.basicMain"></span></td>
                    <td><span ng-bind="row.millName"></span></td>
                    <td><span ng-bind="row.departmentName"></span></td>
                    <td><span ng-bind="row.jobStatusName"></span></td>
                    <td><span ng-bind="row.salaryStatusName"></span></td>
                    <td><span ng-bind="row.jobTypeName"></span></td>
                    <td><span ng-bind="row.houseName"></span></td>
                    <td><span ng-bind="row.workingDay"></span></td>
                    <td><span ng-bind="row.leaveDay"></span></td>
                    <td><span ng-bind="row.otHour"></span></td>
                    <td><span ng-bind="row.encashDay"></span></td>

                    <td>
                        <input type="button" ng-click="objCtrl.deleteObject(row.salaryTranId)" value="Delete"/>
                        <input type="button" ng-click="objCtrl.editObject(row.salaryTranId)" value="Edit"/>
                        <span ng-if="objCtrl.flag == 'updated' && row.salaryTranId == objCtrl.updatedId" class="msg-success">Updated.</span>
                    </td> 
                </tr>
            </table>
        </div>
        <script src="${pageContext.request.contextPath}/static/js/lib/angular.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/lib/angular-resource.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/app.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/controller/salaryTran_controller.js"></script>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/style.css"/>
    </body>
</html> 