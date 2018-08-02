<%-- 
    Document   : index
    Created on : Jul 23, 2018, 9:47:15 PM
    Author     : zakir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${pageContext.request.contextPath}</title>
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

                    <!--Content-area-->
                    <div class=" content-area col-md-12">
                        <div class="row">
                            <div class="sidebar col-md-2">
                                <ul> <!--class="nav navbar-nav"-->
                                        <li><h4>Reports</h4></li>
                                        <br/>
                                        <li><a href="#">MasterData</a></li>
                                        <li><a href="#">Mill</a></li>
                                        <li><a href="#">Designation</a></li>
                                        <li><a href="#">House</a></li>
                                        <li><a href="#">JobStatus</a></li>
                                        <li><a href="#">JobType</a></li>
                                        <li><a href="#">SalaryStatus</a></li>
                                        <li><a href="#">MasterAllowance</a></li>
                                    </ul>
                            </div>
                            <div class="content col-md-10">


                            </div>

                        </div>
                    </div>
                </div>

                <!--Footer-->
                <!--                <div class="footer col-md-12" align="center">
                                    footer
                                </div>-->
            </div>
        </div>
    </div>
</body>
</html>
