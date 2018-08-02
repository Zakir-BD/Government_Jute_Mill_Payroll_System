<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en-US">
    <head>
        <meta charset="UTF-8" /> 
        <title> Spring MVC 4 REST + AngularJS </title>
    </head>
    <body ng-app="myApp">
        <div ng-controller="SalaryStatusController as objCtrl">
            <h1> SalaryStatus Info </h1>
            <form name="objForm" method="POST">
                <table>
                    <tr><td colspan="2">
                            <div ng-if="objCtrl.flag != 'edit'">
                                <h3> Add New SalaryStatus </h3> 
                            </div>
                            <div ng-if="objCtrl.flag == 'edit'">
                                <h3> Update SalaryStatus for ID: {{ objCtrl.obj.salaryStatusId}} </h3> 
                            </div> </td>
                    </tr>
                    <tr>
                        <td>SalaryStatus Code: </td> <td><input type="text" name="salaryStatusCd" ng-model="objCtrl.obj.salaryStatusCd" required/> 
                            <span ng-show="objForm.salaryStatusCd.$error.required" class="msg-val">*</span> </td>
                    </tr>
                    <tr>
                        <td>SalaryStatus Name: </td> <td> <input type="text" name="salaryStatusName" ng-model="objCtrl.obj.salaryStatusName" required/> 
                            <span ng-show="objForm.salaryStatusName.$error.required" class="msg-val">*</span> </td>
                    </tr>
                    
                    <tr>
                        <td colspan="2"> <span ng-if="objCtrl.flag == 'created'" class="msg-success">SalaryStatus successfully added.</span>
                            <span ng-if="objCtrl.flag == 'failed'" class="msg-val">SalaryStatus already exists.</span> </td>
                    </tr>
                    <tr><td colspan="2">
                            <div ng-if="objCtrl.flag != 'edit'">
                                <input  type="submit" ng-click="objCtrl.addObject()" value="Add SalaryStatus"/> 
                                <input type="button" ng-click="objCtrl.reset()" value="Reset"/>
                            </div>
                            <div ng-if="objCtrl.flag == 'edit'">
                                <input  type="submit" ng-click="objCtrl.updateObjectDetail()" value="Update SalaryStatus"/> 	
                                <input type="button" ng-click="objCtrl.cancelUpdate()" value="Cancel"/>				   
                            </div> </td>
                    </tr>
                    <tr>
                        <td colspan="2"> <span ng-if="objCtrl.flag == 'deleted'" class="msg-success">Deleted.</span>
                    </tr>
                </table>     
            </form>
            <table>
                <tr><th>SalaryStatus Code </th> <th> SalaryStatus Name</th></tr>
                <tr ng-repeat="row in objCtrl.objArray | orderBy: 'salaryStatusCd'">
                    <td><span ng-bind="row.salaryStatusCd"></span></td>
                    <td><span ng-bind="row.salaryStatusName"></span></td>
                    <td>
                        <input type="button" ng-click="objCtrl.deleteObject(row.salaryStatusId)" value="Delete"/>
                        <input type="button" ng-click="objCtrl.editObject(row.salaryStatusId)" value="Edit"/>
                        <span ng-if="objCtrl.flag == 'updated' && row.salaryStatusId == objCtrl.updatedId" class="msg-success">Updated.</span>
                    </td> 
                </tr>	
            </table>
        </div>
        <script src="${pageContext.request.contextPath}/static/js/lib/angular.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/lib/angular-resource.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/app.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/controller/salaryStatus_controller.js"></script>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/style.css"/>
    </body>
</html> 