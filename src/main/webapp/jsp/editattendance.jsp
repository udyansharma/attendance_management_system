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
    <title>Edit Attendance</title>
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
    <div class="navbar-header ">
      <div class="navbar-header" align="center">
	 <h3>Edit Attendance</h3>
    </div>
      <div style="float:right;margin-left:880px">
      <br>
      <span>Welcome ${facultysession.id},${facultysession.name}</span>
      <br>
      <span><a href="faclogout">Logout</a></span>
      </div>
    </div>
  </div><!-- /.container-fluid -->
</nav>
    </head>
    <body>
    	<div class="col-sm-2">
	    	<nav class="nav-sidebar">
				<ul class="nav tabs">
		            			<li class=""><a href="fachome" >Back To Home</a></li>                               
				</ul>
			</nav>
		</div>
<div class="panel col-sm-4" align="center" style="margin-left:250px;">
  <div class="panel-heading ">
      <h3 class="panel-title ">  Edit Attendance
</h3>

			<table align="center">
                <tr>
                    <td style="font-style: italic; color: red;">${success_msg}</td>
                </tr>
            </table>
  </div>
		<div class="panel-body"> 
		    <form:form id="regForm" action="chose_sube" method="post">
                    <div class="form-group">
					<label for="id">Enrollment Number</label>
					<input name="id" id="id" class="form-control" required="true" />
				</div>
                   		<div class="form-group">
                        <label for="sem">Semester</label>
                        <select name="sem" id="sem" class="form-control" required="true">
                        <option value="" selected></option>
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                        <option value="6">6</option>
                        <option value="7">7</option>
                        <option value="8">8</option>
                        </select>
                        <input type="hidden" name="dept" value="${facultysession.dept}">
                      </div>
				     <button type="submit" id="register" name="register" class="btn btn-default">Submit</button>
            </form:form> 
 </div>
  </div>		
    </body>
    </html>