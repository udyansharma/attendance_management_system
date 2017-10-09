<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Login</title>

    <!-- Bootstrap -->
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
	

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="<c:url value="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js" />"></script>
      <script src="<c:url value="https://oss.maxcdn.com/respond/1.4.2/respond.min.js" />"></script>
    <![endif]-->
	    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
     <script src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js" />"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
   <script src="<c:url value="/resources/js/functions.js" />"></script>
   
  <nav class="navbar navbar-default navbar-static-top">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header" align="center">
	 <h1>Welcome to the Attendance System</h1>
    </div>
  </div><!-- /.container-fluid -->
</nav>
</head>
  <body>
<div id="bck-img">
<div class="login-panel col-md-4">
<div class="panel panel-yellow ">
  <div class="panel-heading ">
      <h3 class="panel-title ">
      <ul class="nav nav-tabs">
  <li role="presentation" class="active" style="color:black;font-weight:bold;">Admin Login</li>
</ul>
</h3>
  </div>
  <div class="panel-body">
  <form:form id="admlgForm" modelAttribute="admin_login" action="admin_process" method="post" onsubmit="return admlgn()">          
  <div class="form-group">
  <form:label path="id">Admin Id: </form:label>
  <form:input required="required" path="id" class="form-control" id="id" />
  <div id="idm" style="color: red;"></div>
  </div>
  <div class="form-group">
  	<form:label path="password">Password:</form:label>
    <form:input required="required" type="password" path="password" class="form-control" id="password" />
  <div id="pwm" style="color: red;"></div>
  </div>
  <div class="form-group" align="center">
  <button type="submit" id="login"  name="login" class="btn btn-default">Login</button>
</div>	
	</form:form>
  </div>
  </div>
  <div style="text-align:center;"><a href="home.jsp">Back to Home</a>	
  </div>
  <table align="center">
                <tr>
                    <td style="font-style: italic; color: red;">${message}</td>
                </tr>
                </table>
  </div>
  </div> 
  </body>
</html>