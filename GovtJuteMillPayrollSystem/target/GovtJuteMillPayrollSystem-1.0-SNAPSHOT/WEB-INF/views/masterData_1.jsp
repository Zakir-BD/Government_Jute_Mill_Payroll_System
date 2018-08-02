<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en-US">
    <head>
        <meta charset="UTF-8" /> 
        <title> MasterData </title>
    </head>
    <body ng-app="myApp">
        <div ng-controller="MasterDataController as objCtrl">
            <h1> MasterData </h1>
            <form name="objForm" method="POST">
                <table>
                    <tr><td colspan="2">
                            <div ng-if="objCtrl.flag != 'edit'">
                                <h3> Add New MasterData </h3> 
                            </div>
                            <div ng-if="objCtrl.flag == 'edit'">
                                <h3> Update MasterData for ID: {{ objCtrl.obj.employeeId}} </h3> 
                            </div> </td>
                    </tr>
                    <tr>
                        <td>name : </td>
                        <td><input type="text" name="name" ng-model="objCtrl.obj.name" required/> 
                            <span ng-show="objForm.name.$error.required" class="msg-val">*</span>
                        </td>
                    </tr>
                    <tr>
                        <td>dateBirth : </td>
                        <td><input type="date" name="dateBirth" ng-model="objCtrl.obj.dateBirth" required/>
                            <span ng-show="objForm.dateBirth.$error.required" class="msg-val">*</span>
                        </td>
                    </tr>

                    <tr>
                        <td>designationName</td>
                        <td>
                            <select ng-model="objCtrl.obj.designation" ng-options="x.designationName for x in designation"></select>
                        </td>
                    </tr>
                    <tr>
                        <td>basicMain</td>
                        <td>
                            <select ng-model="objCtrl.obj.basicMaster" ng-options="x.basicMain for x in basicMaster"></select>
                        </td>
                    </tr>
                    <tr>
                        <td>millName</td>
                        <td>
                            <select ng-model="objCtrl.obj.mill" ng-options="x.millName for x in mill"></select>
                        </td>
                    </tr>
                    <tr>
                        <td>departmentName</td>
                        <td>
                            <select ng-model="objCtrl.obj.department" ng-options="x.departmentName for x in department"></select>
                        </td>
                    </tr>
                    <tr>
                        <td>jobTypeName</td>
                        <td>
                            <select ng-model="objCtrl.obj.jobType" ng-options="x.jobTypeName for x in jobType"></select>
                        </td>
                    </tr>
                    <tr>
                        <td>jobStatusName</td>
                        <td>
                            <select ng-model="objCtrl.obj.jobStatus" ng-options="x.jobStatusName for x in jobStatus"></select>
                        </td>
                    </tr>
                    <tr>
                        <td>fatherName : </td>
                        <td><input type="text" name="fatherName" ng-model="objCtrl.obj.fatherName" required/> 
                            <span ng-show="objForm.fatherName.$error.required" class="msg-val">*</span>
                        </td>
                    </tr>
                    <tr>
                        <td>motherName : </td>
                        <td><input type="text" name="motherName" ng-model="objCtrl.obj.motherName" required/> 
                            <span ng-show="objForm.motherName.$error.required" class="msg-val">*</span>
                        </td>
                    </tr>
                    <tr>
                        <td>homeDistrict : </td>
                        <td><input type="text" name="homeDistrict" ng-model="objCtrl.obj.homeDistrict" required/> 
                            <span ng-show="objForm.homeDistrict.$error.required" class="msg-val">*</span>
                        </td>
                    </tr>
                    <tr>
                        <td>permanentAddress : </td>
                        <td><input type="text" name="permanentAddress" ng-model="objCtrl.obj.permanentAddress" required/> 
                            <span ng-show="objForm.permanentAddress.$error.required" class="msg-val">*</span>
                        </td>
                    </tr>
                    <tr>
                        <td>dateJoinJob : </td>
                        <td><input type="date" name="dateJoinJob" ng-model="objCtrl.obj.dateJoinJob" required/> 
                            <span ng-show="objForm.dateJoinJob.$error.required" class="msg-val">*</span>
                        </td>
                    </tr>
                    <tr>
                        <td>dateJoinMill : </td>
                        <td><input type="date" name="dateJoinMill" ng-model="objCtrl.obj.dateJoinMill" required/> 
                            <span ng-show="objForm.dateJoinMill.$error.required" class="msg-val">*</span>
                        </td>
                    </tr>
                    <tr>
                        <td>dateRetired : </td>
                        <td><input type="date" name="dateRetired" ng-model="objCtrl.obj.dateRetired" required/> 
                            <span ng-show="objForm.dateRetired.$error.required" class="msg-val">*</span>
                        </td>
                    </tr>
                    <tr>
                        <td>pfAcNo : </td>
                        <td><input type="text" name="pfAcNo" ng-model="objCtrl.obj.pfAcNo" required/> 
                            <span ng-show="objForm.pfAcNo.$error.required" class="msg-val">*</span>
                        </td>
                    </tr>
                    <tr>
                        <td>bankAc : </td>
                        <td><input type="text" name="bankAc" ng-model="objCtrl.obj.bankAc" required/> 
                            <span ng-show="objForm.bankAc.$error.required" class="msg-val">*</span>
                        </td>
                    </tr>

                    <tr>
                        <td>bankName : </td>
                        <td><input type="text" name="bankName" ng-model="objCtrl.obj.bankName" required/> 
                            <span ng-show="objForm.bankName.$error.required" class="msg-val">*</span>
                        </td>
                    </tr>
                    <tr>
                        <td>bankBranch : </td>
                        <td><input type="text" name="bankBranch" ng-model="objCtrl.obj.bankBranch" required/> 
                            <span ng-show="objForm.bankBranch.$error.required" class="msg-val">*</span>
                        </td>
                    </tr>

                    <tr>
                        <td>salaryStatusName</td>
                        <td>
                            <select ng-model="objCtrl.obj.salaryStatus" ng-options="x.salaryStatusName for x in salaryStatus"></select>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2"> <span ng-if="objCtrl.flag == 'created'" class="msg-success">MasterData successfully added.</span>
                            <span ng-if="objCtrl.flag == 'failed'" class="msg-val">MasterData already exists.</span>
                        </td>
                    </tr>
                    <tr><td colspan="2">
                            <div ng-if="objCtrl.flag != 'edit'">
                                <input  type="submit" ng-click="objCtrl.addObject()" value="Add MasterData"/> 
                                <input type="button" ng-click="objCtrl.reset()" value="Reset"/>
                            </div>
                            <div ng-if="objCtrl.flag == 'edit'">
                                <input  type="submit" ng-click="objCtrl.updateObjectDetail()" value="Update MasterData"/> 	
                                <input type="button" ng-click="objCtrl.cancelUpdate()" value="Cancel"/>				   
                            </div> </td>
                    </tr>
                    <tr>
                        <td colspan="2"> <span ng-if="objCtrl.flag == 'deleted'" class="msg-success">MasterData successfully deleted.</span>
                    </tr>
                </table>     
            </form>


            <table border="1px solid gray" >
                <tr> 
                    <th>Action</th>
                    <th>EmployeeId</th>
                    <th>name</th>
                    <th>dateBirth</th>
                    <th>designationName</th>
                    <th>basicMain</th>
                    <th>millName</th>
                    <th>departmentName</th>
                    <th>jobTypeName</th>
                    <th>jobStatusName</th>
                    <th>fatherName</th>
                    <th>motherName</th>
                    <th>homeDistrict</th>
                    <th>permanentAddress</th>
                    <th>dateJoinJob</th>
                    <th>dateJoinMill</th>
                    <th>dateRetired</th>
                    <th>pfAcNo</th>
                    <th>bankAc</th>
                    <th>bankName</th>
                    <th>bankBranch</th>
                    <th>salaryStatusName</th>

                </tr>
                <tr ng-repeat="row in objCtrl.objArray">
                    <td>
                        <input type="button" ng-click="objCtrl.deleteObject(row.employeeId)" value="Delete"/>
                        <input type="button" ng-click="objCtrl.editObject(row.employeeId)" value="Edit"/>
                        <span ng-if="objCtrl.flag == 'updated' && row.employeeId == objCtrl.updatedId" class="msg-success">Updated.</span>
                    </td>
                    <td><span ng-bind="row.employeeId"></span></td>
                    <td><span ng-bind="row.name"></span></td>
                    <td><span ng-bind="row.dateBirth"></span></td>
                    <td><span ng-bind="row.designation.designationName"></span></td>
                    <td><span ng-bind="row.basicMaster.basicMain"></span></td>
                    <td><span ng-bind="row.mill.millName"></span></td>
                    <td><span ng-bind="row.department.departmentName"></span></td>
                    <td><span ng-bind="row.jobType.jobTypeName"></span></td>
                    <td><span ng-bind="row.jobStatus.jobStatusName"></span></td>
                    <td><span ng-bind="row.fatherName"></span></td>
                    <td><span ng-bind="row.motherName"></span></td>
                    <td><span ng-bind="row.homeDistrict"></span></td>
                    <td><span ng-bind="row.permanentAddress"></span></td>
                    <td><span ng-bind="row.dateJoinJob"></span></td>
                    <td><span ng-bind="row.dateJoinMill"></span></td>
                    <td><span ng-bind="row.dateRetired"></span></td>
                    <td><span ng-bind="row.pfAcNo"></span></td>
                    <td><span ng-bind="row.bankAc"></span></td>
                    <td><span ng-bind="row.bankName"></span></td>
                    <td><span ng-bind="row.bankBranch"></span></td>
                    <td><span ng-bind="row.salaryStatus.salaryStatusName"></span></td>


                </tr>	
            </table>
        </div>
        <script src="${pageContext.request.contextPath}/static/js/lib/angular.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/lib/angular-resource.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/app.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/controller/masterData_controller.js"></script>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/style.css"/>
    </body>
</html> 