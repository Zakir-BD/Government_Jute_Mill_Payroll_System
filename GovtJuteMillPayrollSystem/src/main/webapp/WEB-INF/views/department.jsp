<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en-US">
    <head>
        <meta charset="UTF-8" /> 
        <title>${pageContext.request.contextPath}_Department </title>
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
        <script src="${pageContext.request.contextPath}/static/js/controller/department_controller.js"></script>


    </head>
    <body ng-app="myApp">
        <div ng-controller="DepartmentController as objCtrl">
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
                                                    <h1> Department Information</h1>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td colspan="2">
                                                <div ng-if="objCtrl.flag != 'edit'">
                                                    <h3> Add New Department </h3> 
                                                </div>
                                                <div ng-if="objCtrl.flag == 'edit'">
                                                    <h3> Update Department for ID: {{ objCtrl.obj.departmentId}} </h3> 
                                                </div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Department Code: </td>
                                            <td><input type="text" name="departmentCd" ng-model="objCtrl.obj.departmentCd" required/> 
                                                <span ng-show="objForm.departmentCd.$error.required" class="msg-val">*</span>
                                            </td>
                                        </tr>
                                        <tr>

                                            <td>Department Name: </td>
                                            <td> <input type="text" name="departmentName" ng-model="objCtrl.obj.departmentName" required/> 
                                                <span ng-show="objForm.departmentName.$error.required" class="msg-val">*</span>
                                            </td>
                                        </tr>

                                        <tr>
                                            <td colspan="2"> <span ng-if="objCtrl.flag == 'created'" class="msg-success">Department successfully added.</span>
                                                <span ng-if="objCtrl.flag == 'failed'" class="msg-val">Department already exists.</span> </td>
                                        </tr>
                                        <tr>
                                            <td></td>
                                            <td colspan="2">
                                                <div ng-if="objCtrl.flag != 'edit'">
                                                    <input  type="submit" ng-click="objCtrl.addObject()" value="Add Department"/> 
                                                    <input type="button" ng-click="objCtrl.reset()" value="Reset"/>
                                                </div>

                                                <div ng-if="objCtrl.flag == 'edit'">
                                                    <input  type="submit" ng-click="objCtrl.updateObjectDetail()" value="Update Department"/> 	
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
                                    <tr><th>Department Code </th> <th> Department Name</th></tr>
                                    <tr ng-repeat="row in objCtrl.objArray| orderBy: 'departmentCd'">
                                        <td><span ng-bind="row.departmentCd"></span></td>
                                        <td><span ng-bind="row.departmentName"></span></td>
                                        <td>
                                            <input type="button" ng-click="objCtrl.deleteObject(row.departmentId)" value="Delete"/>
                                            <input type="button" ng-click="objCtrl.editObject(row.departmentId)" value="Edit"/>
                                            <span ng-if="objCtrl.flag == 'updated' && row.departmentId == objCtrl.updatedId" class="msg-success">Updated.</span>
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