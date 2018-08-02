<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en-US">
    <head>
        <meta charset="UTF-8" /> 
        <title> Spring MVC 4 REST + AngularJS </title>
    </head>
    <body ng-app="myApp">
        <div ng-controller="HouseController as objCtrl">
            <h1> House Info </h1>
            <form name="objForm" method="POST">
                <table>
                    <tr><td colspan="2">
                            <div ng-if="objCtrl.flag != 'edit'">
                                <h3> Add New House </h3> 
                            </div>
                            <div ng-if="objCtrl.flag == 'edit'">
                                <h3> Update House for ID: {{ objCtrl.obj.houseId}} </h3> 
                            </div> </td>
                    </tr>
                    <tr>
                        <td>House Code: </td> <td><input type="text" name="houseCd" ng-model="objCtrl.obj.houseCd" required/> 
                            <span ng-show="objForm.houseCd.$error.required" class="msg-val">*</span> </td>
                    </tr>
                    <tr>
                        <td>House Name: </td> <td> <input type="text" name="houseName" ng-model="objCtrl.obj.houseName" required/> 
                            <span ng-show="objForm.houseName.$error.required" class="msg-val">*</span> </td>
                    </tr>
                    <tr>
                        <td>House Rent: </td> <td> <input type="text" name="houseRent" ng-model="objCtrl.obj.houseRent" required/> 
                            <span ng-show="objForm.houseRent.$error.required" class="msg-val">*</span> </td>
                    </tr>
                    
                    <tr>
                        <td colspan="2"> <span ng-if="objCtrl.flag == 'created'" class="msg-success">House successfully added.</span>
                            <span ng-if="objCtrl.flag == 'failed'" class="msg-val">House already exists.</span> </td>
                    </tr>
                    <tr><td colspan="2">
                            <div ng-if="objCtrl.flag != 'edit'">
                                <input  type="submit" ng-click="objCtrl.addObject()" value="Add House"/> 
                                <input type="button" ng-click="objCtrl.reset()" value="Reset"/>
                            </div>
                            <div ng-if="objCtrl.flag == 'edit'">
                                <input  type="submit" ng-click="objCtrl.updateObjectDetail()" value="Update House"/> 	
                                <input type="button" ng-click="objCtrl.cancelUpdate()" value="Cancel"/>				   
                            </div> </td>
                    </tr>
                    <tr>
                        <td colspan="2"> <span ng-if="objCtrl.flag == 'deleted'" class="msg-success">Deleted.</span>
                    </tr>
                </table>     
            </form>
            <table>
                <tr><th>House Code </th> <th> House Name</th><th> House Rent</th></tr>
                <tr ng-repeat="row in objCtrl.objArray | orderBy: 'houseCd'">
                    <td><span ng-bind="row.houseCd"></span></td>
                    <td><span ng-bind="row.houseName"></span></td>
                    <td><span ng-bind="row.houseRent"></span></td>
                    <td>
                        <input type="button" ng-click="objCtrl.deleteObject(row.houseId)" value="Delete"/>
                        <input type="button" ng-click="objCtrl.editObject(row.houseId)" value="Edit"/>
                        <span ng-if="objCtrl.flag == 'updated' && row.houseId == objCtrl.updatedId" class="msg-success">Updated.</span>
                    </td> 
                </tr>	
            </table>
        </div>
        <script src="${pageContext.request.contextPath}/static/js/lib/angular.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/lib/angular-resource.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/app.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/controller/house_controller.js"></script>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/style.css"/>
    </body>
</html> 