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
    <title>Welcome ${studentsession.name}</title>

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
    <div class="row">
      <div class="col-md-4" align="center">
	 <h1>STUDENT PORTAL</h1>
    </div>
    <div class="col-md-4"></div>
      <div class="col-md-4" style="text-align:right;">
      <span><a href="scp">Change Password</a></span>
      <br>	  
      <span>Welcome ${studentsession.id},${studentsession.name}</span>
      <br>
      <span><a href="stdlogout">Logout</a></span>
      </div>
    </div>
  </div><!-- /.container-fluid -->
</nav>
    </head>
    <body>
    	<div class="col-sm-2">
	    	<nav class="nav-sidebar">
				<ul class="nav tabs">
		          <li class="active"><a href="view_attenas">View Attendance</a></li>                            
				</ul>
			</nav>
		</div>
		<div class="col-sm-6">
			<table align="center">
                <tr>
                    <td style="font-style: italic; color: red;">${success_msg}</td>
                </tr>
            </table>
            <table class="table table-bordered table-condensed" align="center" >
                <tr><th colspan="2" style="text-align:center;">DETAILS</th></tr>
                <tr>
				<td><label>Name</label></td>
                    <td>${studentsession.name}</td>
                    </tr>
                    <tr>
                    <td><label>Email</label></td>
                    <td>${studentsession.email}</td>
                    </tr>
                    <tr>
                    <td><label>Batch</label></td>
                    <td>${studentsession.batch}</td>
                    </tr>
                    <tr>
                    <td><label>Session</label></td>
                    <td>${studentsession.session}</td>
                    </tr>
                    <tr>
                    <td><label>Address</label></td>
                    <td>${studentsession.address}</td>
                    </tr>
                    <tr>
                    <td><label>Phone Number:</label></td>
                    <td>${studentsession.contact}</td>
                    </tr>
            </table>

</div>

    </div>
    </body>
    </html>