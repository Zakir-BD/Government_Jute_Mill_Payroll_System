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
        <title>JSP Page</title>
        <link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="${pageContext.request.contextPath}/static/js/jquery.min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/static/js/angular.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/static/js/app.js" type="text/javascript"></script>
        <link href="${pageContext.request.contextPath}/static/css/custom.css" rel="stylesheet" type="text/css"/>

    </head>

    <body>

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
                                    <li><a href="#">Home</a></li>
                                    <li><a href="#">File</a></li>
                                    <li><a href="#">Maintain</a></li>
                                    <li><a href="#">Salary Transaction</a></li>
                                    <li><a href="#">Reports</a></li>
                                    
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
                            <ul class="nav navbar-nav">
                                <li><a href="#">Home</a></li><br/>
                                <li><a href="#">Home</a></li><br/>
                                <li><a href="#">Home</a></li><br/>
                            </ul>
                        </div>

                        <div class="content col-md-10">
                            content
                        </div>
                    </div>
                </div>
                
                <!--Footer-->
<!--                <div class="footer col-md-12" align="center">
                    footer
                </div>-->


            </div>
        </div>
    </body>
</html>
