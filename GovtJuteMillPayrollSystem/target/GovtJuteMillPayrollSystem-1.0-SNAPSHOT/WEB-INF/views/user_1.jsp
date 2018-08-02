<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en-US">
    <head>
        <meta charset="UTF-8" /> 
        <title> User </title>
    </head>
    <body ng-app="myApp">
        <div ng-controller="UserController as objCtrl">
            <h1> User Info </h1>
            <form name="objForm" method="POST">
                <table>
                    <tr><td colspan="2">
                            <div ng-if="objCtrl.flag != 'edit'">
                                <h3> Add New User </h3> 
                            </div>
                            <div ng-if="objCtrl.flag == 'edit'">
                                <h3> Update User for ID: {{ objCtrl.obj.userId}} </h3> 
                            </div> </td>
                    </tr>
                    <tr>
                        <td>Employee ID : </td>
                        <td><input type="text" name="employeeId" ng-model="objCtrl.obj.masterData.employeeId" required/> 
                            <span ng-show="objForm.employeeId.$error.required" class="msg-val">*</span>
                        </td>
                    </tr>
                    <tr>
                        <td>userName : </td>
                        <td><input type="text" name="userName" ng-model="objCtrl.obj.userName" required/> 
                            <span ng-show="objForm.userName.$error.required" class="msg-val">*</span>
                        </td>
                    </tr>
                    <tr>
                        <td>userEmail : </td>
                        <td><input type="text" name="userEmail" ng-model="objCtrl.obj.userEmail" required/> 
                            <span ng-show="objForm.userEmail.$error.required" class="msg-val">*</span>
                        </td>
                    </tr>
                    <tr>
                        <td>userPass : </td>
                        <td> <input type="text" name="userPass" ng-model="objCtrl.obj.userPass" required/> 
                            <span ng-show="objForm.userPass.$error.required" class="msg-val">*</span>
                        </td>
                    </tr>

                    <tr>
                        <td colspan="2"> <span ng-if="objCtrl.flag == 'created'" class="msg-success">User successfully added.</span>
                            <span ng-if="objCtrl.flag == 'failed'" class="msg-val">User already exists.</span>
                        </td>
                    </tr>
                    <tr><td colspan="2">
                            <div ng-if="objCtrl.flag != 'edit'">
                                <input  type="submit" ng-click="objCtrl.addObject()" value="Add User"/> 
                                <input type="button" ng-click="objCtrl.reset()" value="Reset"/>
                            </div>
                            <div ng-if="objCtrl.flag == 'edit'">
                                <input  type="submit" ng-click="objCtrl.updateObjectDetail()" value="Update User"/> 	
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
                    <th>Employee ID </th> 
                    <th>userName</th> 
                    <th>userEmail</th>
                    <th>userPass</th></tr>
                <tr ng-repeat="row in objCtrl.objArray| orderBy: 'masterData.employeeId'">
                    <td><span ng-bind="row.masterData.employeeId"></span></td>
                    <td><span ng-bind="row.userName"></span></td>
                    <td><span ng-bind="row.userEmail"></span></td>
                    <td><span ng-bind="row.userPass"></span></td>
                    <td>
                        <input type="button" ng-click="objCtrl.deleteObject(row.userId)" value="Delete"/>
                        <input type="button" ng-click="objCtrl.editObject(row.userId)" value="Edit"/>
                        <span ng-if="objCtrl.flag == 'updated' && row.userId == objCtrl.updatedId" class="msg-success">Updated.</span>
                    </td> 
                </tr>	
            </table>
        </div>
        <script src="${pageContext.request.contextPath}/static/js/lib/angular.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/lib/angular-resource.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/app.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/controller/user_controller.js"></script>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/style.css"/>
    </body>
</html> 