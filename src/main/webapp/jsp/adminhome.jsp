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
    <title>Welcome ${adminsession.name}</title>
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
    <script src="<c:url value="js/bootstrap.min.js" />"></script>
   <script src="<c:url value="js/functions.js" />"></script>
     <nav class="navbar navbar-default navbar-static-top">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header ">
      <div class="navbar-header" align="center">
	 <h1>ADMIN PORTAL</h1>
    </div>
      <div style="float:right;margin-left:880px">
      <span><a href="acp">Change Password</a></span>
      <br>
      <span>Welcome ${adminsession.id},${adminsession.name}</span>
      <br>
      <span><a href="admlogout">Logout</a></span>
      </div>
    </div>
  </div><!-- /.container-fluid -->
</nav>
    </head>
    <body>
    	<div class="col-sm-2">
	    	<nav class="nav-sidebar">
				<ul class="nav tabs">
		          <li class="active"><a href="add_stud" data-toggle="tab">Add Student</a></li>
		          <li class=""><a href="add_fac" data-toggle="tab">Add Faculty</a></li>
		          <li class=""><a href="add_batch" data-toggle="tab">Add Batch</a></li>                               
					<li class=""><a href="add_subj" data-toggle="tab">Add Subject</a></li>
					<li class=""><a href="chosestd" data-toggle="tab">Remove Student</a></li>                               
					<li class=""><a href="chosefac" data-toggle="tab">Remove Faculty</a></li>                               
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
                <tr><th colspan="2" style="text-align:center;">DETAILS</th><tr>
                <tr>
                    <td><label>Name</label></td>
                    <td>${adminsession.name}</td>
                    </tr>
                    <tr>
                    <td><label>Email</label></td>
                    <td>${adminsession.email}</td>
                    </tr>
                    <tr>
                    <td><label>Address</label></td>
                    <td>${adminsession.address}</td>
                    </tr>
                    <tr>
                    <td><label>Phone Number:</label></td>
                    <td>${adminsession.contact}</td>
                    </tr>
            </table>

</div>

    </div>
    </body>
    </html>