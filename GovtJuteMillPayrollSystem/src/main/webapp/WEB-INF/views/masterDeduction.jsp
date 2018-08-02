<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en-US">
    <head>
        <meta charset="UTF-8" /> 
        <title> MasterDeduction </title>
    </head>
    <body ng-app="myApp">
        <div ng-controller="MasterDeductionController as objCtrl">
            <h1> MasterDeduction Info </h1>
            <form name="objForm" method="POST">
                <table>
                    <tr><td colspan="2">
                            <div ng-if="objCtrl.flag != 'edit'">
                                <h3> Add New MasterDeduction </h3> 
                            </div>
                            <div ng-if="objCtrl.flag == 'edit'">
                                <h3> Update MasterDeduction for ID: {{ objCtrl.obj.masterDeductionId}} </h3> 
                            </div> </td>
                    </tr>
                    <tr>
                        <td>EmployeeId</td>
                        <td>
                            <select ng-model="objCtrl.obj.masterData" ng-options="x.employeeId for x in masterData"></select>
                        </td>
                    </tr>
                    <tr>
                        <td>EmployeeName</td>
                        <td>
                            <select ng-model="objCtrl.obj.masterData" ng-options="x.name for x in masterData"></select>
                        </td>
                    </tr>
                   
                    <tr>
                        <td>houseRent</td>
                        <td>
                            <select ng-model="objCtrl.obj.house" ng-options="x.houseRent for x in house"></select>
                        </td>
                    </tr>
                    <tr>
                        <td>telephoneBill : </td>
                        <td><input type="text" name="telephoneBill" ng-model="objCtrl.obj.telephoneBill" required/> 
                            <span ng-show="objForm.telephoneBill.$error.required" class="msg-val">*</span>
                        </td>
                    </tr>
                    <tr>
                        <td>pfContribution : </td>
                        <td><input type="text" name="pfContribution" ng-model="objCtrl.obj.pfContribution" required/> 
                            <span ng-show="objForm.pfContribution.$error.required" class="msg-val">*</span>
                        </td>
                    </tr>
                    <tr>
                        <td>pfLoan : </td>
                        <td><input type="text" name="pfLoan" ng-model="objCtrl.obj.pfLoan" required/> 
                            <span ng-show="objForm.pfLoan.$error.required" class="msg-val">*</span>
                        </td>
                    </tr>
                    <tr>
                        <td>advanceSalary : </td>
                        <td><input type="text" name="advanceSalary" ng-model="objCtrl.obj.advanceSalary" required/> 
                            <span ng-show="objForm.advanceSalary.$error.required" class="msg-val">*</span>
                        </td>
                    </tr>
                    <tr>
                        <td>revenueStamp : </td>
                        <td><input type="text" name="revenueStamp" ng-model="objCtrl.obj.revenueStamp" required/> 
                            <span ng-show="objForm.revenueStamp.$error.required" class="msg-val">*</span>
                        </td>
                    </tr>
                    <tr>
                        <td>incomeTax : </td>
                        <td><input type="text" name="incomeTax" ng-model="objCtrl.obj.incomeTax" required/> 
                            <span ng-show="objForm.incomeTax.$error.required" class="msg-val">*</span>
                        </td>
                    </tr>
                    <tr>
                        <td>electricBill : </td>
                        <td><input type="text" name="electricBill" ng-model="objCtrl.obj.electricBill" required/> 
                            <span ng-show="objForm.electricBill.$error.required" class="msg-val">*</span>
                        </td>
                    </tr>
                    <tr>
                        <td>Others : </td>
                        <td><input type="text" name="others" ng-model="objCtrl.obj.others" required/> 
                            <span ng-show="objForm.others.$error.required" class="msg-val">*</span>
                        </td>
                    </tr>

                    <tr>
                        <td colspan="2"> <span ng-if="objCtrl.flag == 'created'" class="msg-success">MasterDeduction successfully added.</span>
                            <span ng-if="objCtrl.flag == 'failed'" class="msg-val">MasterDeduction already exists.</span>
                        </td>
                    </tr>
                    <tr><td colspan="2">
                            <div ng-if="objCtrl.flag != 'edit'">
                                <input  type="submit" ng-click="objCtrl.addObject()" value="Add MasterDeduction"/> 
                                <input type="button" ng-click="objCtrl.reset()" value="Reset"/>
                            </div>
                            <div ng-if="objCtrl.flag == 'edit'">
                                <input  type="submit" ng-click="objCtrl.updateObjectDetail()" value="Update MasterDeduction"/> 	
                                <input type="button" ng-click="objCtrl.cancelUpdate()" value="Cancel"/>				   
                            </div> </td>
                    </tr>
                    <tr>
                        <td colspan="2"> <span ng-if="objCtrl.flag == 'deleted'" class="msg-success">Deleted.</span>
                    </tr>
                </table>     
            </form>
            <table border="1px #DDD">
                <tr> 
                    <th>EmployeeId</th> 
                    <th>houseRent</th>
                    <th>telephoneBill</th>
                    <th>pfContribution</th>
                    <th>pfLoan</th>
                    <th>advanceSalary</th>
                    <th>revenueStamp</th>
                    <th>incomeTax</th>
                    <th>electricBill</th>
                    <th>Others</th>
                </tr>
                <tr ng-repeat="row in objCtrl.objArray| orderBy: 'employeeId'">
                    <td><span ng-bind="row.masterData.employeeId"></span></td>
                    <td><span ng-bind="row.house.houseRent"></span></td>
                    <td><span ng-bind="row.telephoneBill"></span></td>
                    <td><span ng-bind="row.pfContribution"></span></td>
                    <td><span ng-bind="row.pfLoan"></span></td>
                    <td><span ng-bind="row.advanceSalary"></span></td>
                    <td><span ng-bind="row.revenueStamp"></span></td>
                    <td><span ng-bind="row.incomeTax"></span></td>
                    <td><span ng-bind="row.electricBill"></span></td>
                    <td><span ng-bind="row.others"></span></td>
                    <td>
                        <input type="button" ng-click="objCtrl.deleteObject(row.masterDeductionId)" value="Delete"/>
                        <input type="button" ng-click="objCtrl.editObject(row.masterDeductionId)" value="Edit"/>
                        <span ng-if="objCtrl.flag == 'updated' && row.masterDeductionId == objCtrl.updatedId" class="msg-success">Updated.</span>
                    </td> 
                </tr>	
            </table>
        </div>
        <script src="${pageContext.request.contextPath}/static/js/lib/angular.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/lib/angular-resource.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/app.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/controller/masterDeduction_controller.js"></script>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/style.css"/>
    </body>
</html> 