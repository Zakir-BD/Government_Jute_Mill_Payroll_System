<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en-US">
    <head>
        <meta charset="UTF-8" /> 
        <title>${pageContext.request.contextPath}_Designation </title>
        <link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="${pageContext.request.contextPath}/static/js/jquery.min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/static/js/angular.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/static/js/app.js" type="text/javascript"></script>
        <link href="${pageContext.request.contextPath}/static/css/custom.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/style.css"/>
                <!--<script src="${pageContext.request.contextPath}/static/js/lib/angular.min.js"></script>-->
        <script src="${pageContext.request.contextPath}/static/js/lib/angular-resource.min.js"></script>
                <!--<script src="${pageContext.request.contextPath}/static/js/app.js"></script>-->
        <script src="${pageContext.request.contextPath}/static/js/controller/designation_controller.js"></script>


    </head>
    <body ng-app="myApp">
        <div ng-controller="DesignationController as objCtrl">
            <div class="container">
                <div class="row">
                    <!--Header-->
                    <div class="header col-md-12" align="center">
                        <h1 ><a href="">Govertnment Jute Mills Payroll System</a></h1>
                    </div>
                    <%--Menu Bar--%>
                    <div class="menu col-md-12" align="center">
                        <div class="row">
                            <nav class="navbar navbar-inverse" >
                                <div class="container-fluid">

                                    <ul class="nav navbar-nav">
                                        <li><a href="${pageContext.request.contextPath}/">Home</a></li>
                                        <li><a href="${pageContext.request.contextPath}/mFile">File</a></li>
                                        <li><a href="${pageContext.request.contextPath}/mMaintain">Maintain</a></li>
                                        <li><a href="${pageContext.request.contextPath}/mSalaryTransaction">SalaryTransaction</a></li>
                                        <li><a href="${pageContext.request.contextPath}/mReports">Reports</a></li>
                                    </ul>
                                    <form class="navbar-form navbar-right" action="/action_page.php" align="center">
                                        <div class="form-group">
                                            <input type="text" class="form-control" placeholder="Search">
                                        </div>
                                        <button type="submit" class="btn btn-default">Submit</button>
                                    </form>
                                    <ul class="nav navbar-nav navbar-right">
                                        <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
                                        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                                    </ul>

                                </div>
                            </nav> 
                        </div>
                    </div>

                    <!--Content-->
                    <div class="content-area col-md-12">
                        <div class="row">
                            <div class="sidebar col-md-2">
                                <ul>
                                    <li><h4> Maintain</h4></li>
                                    <br/>
                                    <li><a href="${pageContext.request.contextPath}/masterData/home/">MasterData</a></li>
                                    <li><a href="${pageContext.request.contextPath}/mill/home/">Mill</a></li>
                                    <li><a href="${pageContext.request.contextPath}/department/home/">Department</a></li>
                                    <li><a href="${pageContext.request.contextPath}/designation/home/">Designation</a></li>
                                    <li><a href="${pageContext.request.contextPath}/jobType/home/">JobType</a></li>
                                    <li><a href="${pageContext.request.contextPath}/jobStatus/home/">JobStatus</a></li>
                                    <li><a href="${pageContext.request.contextPath}/basicMaster/home/">BasicMaster</a></li>
                                    <li><a href="${pageContext.request.contextPath}/basicGrade/home/">BasicGrade</a></li>
                                    <li><a href="${pageContext.request.contextPath}/basicIncrement/home/">BasicIncrement</a></li>
                                    <li><a href="${pageContext.request.contextPath}/house/home/">House</a></li>
                                    <li><a href="${pageContext.request.contextPath}/salaryStatus/home/">SalaryStatus</a></li>
                                    <li><a href="${pageContext.request.contextPath}/masterAllowance/home/">MasterAllowance</a></li>
                                    <li><a href="${pageContext.request.contextPath}/masterDeduction/home/">MasterDeduction</a></li>
                                    
                                </ul>
                            </div>

                            <div class="content col-md-10">

                                <form name="objForm" method="POST">
                                    <table>
                                        <tr>
                                            <td colspan="2">
                                                <h1> Designation Information</h1>
                                            </td>
                                        </tr>
                                        <tr><td colspan="2">
                                                <div ng-if="objCtrl.flag != 'edit'">
                                                    <h3> Add New Designation </h3> 
                                                </div>
                                                <div ng-if="objCtrl.flag == 'edit'">
                                                    <h3> Update Designation for ID: {{ objCtrl.obj.designationId}} </h3> 
                                                </div> </td>
                                        </tr>
                                        <tr>
                                            <td>Designation Code: </td> <td><input type="text" name="designationCd" ng-model="objCtrl.obj.designationCd" required/> 
                                                <span ng-show="objForm.designationCd.$error.required" class="msg-val">*</span> </td>
                                        </tr>
                                        <tr>
                                            <td>Designation Name: </td> <td> <input type="text" name="designationName" ng-model="objCtrl.obj.designationName" required/> 
                                                <span ng-show="objForm.designationName.$error.required" class="msg-val">*</span> </td>
                                        </tr>

                                        <tr>
                                            <td colspan="2"> <span ng-if="objCtrl.flag == 'created'" class="msg-success">Designation successfully added.</span>
                                                <span ng-if="objCtrl.flag == 'failed'" class="msg-val">Designation already exists.</span> </td>
                                        </tr>
                                        <tr>
                                            <td></td>
                                            <td colspan="2">
                                                <div ng-if="objCtrl.flag != 'edit'">
                                                    <input  type="submit" ng-click="objCtrl.addObject()" value="Add Designation"/> 
                                                    <input type="button" ng-click="objCtrl.reset()" value="Reset"/>
                                                </div>
                                                <div ng-if="objCtrl.flag == 'edit'">
                                                    <input  type="submit" ng-click="objCtrl.updateObjectDetail()" value="Update Designation"/> 	
                                                    <input type="button" ng-click="objCtrl.cancelUpdate()" value="Cancel"/>				   
                                                </div> 
                                            </td>
                                        </tr>
                                        <tr>
                                            <td colspan="2"> <span ng-if="objCtrl.flag == 'deleted'" class="msg-success">Deleted.</span>
                                        </tr>
                                    </table>     
                                </form>
                                <table>
                                    <tr><th>Designation Code </th> <th> Designation Name</th></tr>
                                    <tr ng-repeat="row in objCtrl.objArray| orderBy: 'designationCd'">
                                        <td><span ng-bind="row.designationCd"></span></td>
                                        <td><span ng-bind="row.designationName"></span></td>
                                        <td>
                                            <input type="button" ng-click="objCtrl.deleteObject(row.designationId)" value="Delete"/>
                                            <input type="button" ng-click="objCtrl.editObject(row.designationId)" value="Edit"/>
                                            <span ng-if="objCtrl.flag == 'updated' && row.designationId == objCtrl.updatedId" class="msg-success">Updated.</span>
                                        </td> 
                                    </tr>	
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </body>
</html> 