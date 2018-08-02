<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en-US">
    <head>
        <meta charset="UTF-8" /> 
        <title>${pageContext.request.contextPath}_MasterAllowance </title>
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
        <script src="${pageContext.request.contextPath}/static/js/controller/masterAllowance_controller.js"></script>


    </head>
    <body ng-app="myApp">
        <div ng-controller="MasterAllowanceController as objCtrl">
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
                                        <tr><td colspan="2">
                                                <div ng-if="objCtrl.flag != 'edit'">
                                                    <h3> Add New MasterAllowance </h3> 
                                                </div>
                                                <div ng-if="objCtrl.flag == 'edit'">
                                                    <h3> Update MasterAllowance for ID: {{ objCtrl.obj.masterAllowanceId}} </h3> 
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
                                                <select ng-model="objCtrl.obj.masterData" ng-options="x.name for x in masterData" ></select>
                                            </td>
                                        </tr>

                                        <tr>
                                            <td>HouseRentAllow : </td>
                                            <td><input type="text" name="houseRentAllow" ng-model="objCtrl.obj.houseRentAllow" required/> 
                                                <span ng-show="objForm.houseRentAllow.$error.required" class="msg-val">*</span>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>MedicalAllow : </td>
                                            <td><input type="text" name="medicalAllow" ng-model="objCtrl.obj.medicalAllow" required/> 
                                                <span ng-show="objForm.medicalAllow.$error.required" class="msg-val">*</span>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>MohargoAllow : </td>
                                            <td><input type="text" name="mohargoAllow" ng-model="objCtrl.obj.mohargoAllow" required/> 
                                                <span ng-show="objForm.mohargoAllow.$error.required" class="msg-val">*</span>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>ChildEducation : </td>
                                            <td><input type="text" name="childEducation" ng-model="objCtrl.obj.childEducation" required/> 
                                                <span ng-show="objForm.childEducation.$error.required" class="msg-val">*</span>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>ConvenceAllow : </td>
                                            <td><input type="text" name="convenceAllow" ng-model="objCtrl.obj.convenceAllow" required/> 
                                                <span ng-show="objForm.convenceAllow.$error.required" class="msg-val">*</span>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>TiffinAllow : </td>
                                            <td><input type="text" name="tiffinAllow" ng-model="objCtrl.obj.tiffinAllow" required/> 
                                                <span ng-show="objForm.tiffinAllow.$error.required" class="msg-val">*</span>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>TelephoneAllow : </td>
                                            <td><input type="text" name="telephoneAllow" ng-model="objCtrl.obj.telephoneAllow" required/> 
                                                <span ng-show="objForm.telephoneAllow.$error.required" class="msg-val">*</span>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Others : </td>
                                            <td><input type="text" name="others" ng-model="objCtrl.obj.others" required/> 
                                                <span ng-show="objForm.others.$error.required" class="msg-val">*</span>
                                            </td>
                                        </tr>

                                        <tr>
                                            <td colspan="2"> <span ng-if="objCtrl.flag == 'created'" class="msg-success">MasterAllowance successfully added.</span>
                                                <span ng-if="objCtrl.flag == 'failed'" class="msg-val">MasterAllowance already exists.</span>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td></td>
                                            <td colspan="2">
                                                <div ng-if="objCtrl.flag != 'edit'">
                                                    <input  type="submit" ng-click="objCtrl.addObject()" value="Add MasterAllowance"/> 
                                                    <input type="button" ng-click="objCtrl.reset()" value="Reset"/>
                                                </div>
                                                <div ng-if="objCtrl.flag == 'edit'">
                                                    <input  type="submit" ng-click="objCtrl.updateObjectDetail()" value="Update MasterAllowance"/> 	
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
                                    <tr> 
                                        <th>EmployeeId</th> 
                                        <th>HouseRentAllow</th>
                                        <th>MedicalAllow</th>
                                        <th>MohargoAllow</th>
                                        <th>ChildEducation</th>
                                        <th>ConvenceAllow</th>
                                        <th>TiffinAllow</th>
                                        <th>TelephoneAllow</th>
                                        <th>Others</th>
                                    </tr>
                                    <tr ng-repeat="row in objCtrl.objArray| orderBy: 'employeeId'">
                                        <td><span ng-bind="row.masterData.employeeId"></span></td>
                                        <td><span ng-bind="row.houseRentAllow"></span></td>
                                        <td><span ng-bind="row.medicalAllow"></span></td>
                                        <td><span ng-bind="row.mohargoAllow"></span></td>
                                        <td><span ng-bind="row.childEducation"></span></td>
                                        <td><span ng-bind="row.convenceAllow"></span></td>
                                        <td><span ng-bind="row.tiffinAllow"></span></td>
                                        <td><span ng-bind="row.telephoneAllow"></span></td>
                                        <td><span ng-bind="row.others"></span></td>
                                        <td>
                                            <input type="button" ng-click="objCtrl.deleteObject(row.masterAllowanceId)" value="Delete"/>
                                            <input type="button" ng-click="objCtrl.editObject(row.masterAllowanceId)" value="Edit"/>
                                            <span ng-if="objCtrl.flag == 'updated' && row.masterAllowanceId == objCtrl.updatedId" class="msg-success">Updated.</span>
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