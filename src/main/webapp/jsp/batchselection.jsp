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
    <title>Upload Attendance</title>

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
	 <h3>Upload Attendance</h3>
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
					<li class=""><a href="update_atten">Back to Sem Selection</a>
					<li class=""><a href="fachome" >Back To Home</a></li>
					                               
				</ul>
			</nav>
		</div>
<div class="panel col-sm-4" align="center" style="margin-left:250px;">
  <div class="panel-heading ">
      <h3 class="panel-title ">  
</h3>
  </div>
		<div class="panel-body"> 
		<form:form id="regForm" modelAttribute="subbatch" action="disp_students" method="get">
                <div class="form-group">
					         <form:label path="subjct">Subject</form:label>
                        	 <form:select path="subjct" name="sub" id="sub" class="form-control">
                        		<option value="" selected>Choose Subject</option>
			                        <c:forEach var="subject" items="${subs}">
			                        <form:option path="subjct" value="${subject}">${subject}</form:option>
			                        
			                        </c:forEach>
			                 </form:select>
                      </div>
						<div class="form-group">
						 <form:label path="batches">Batch</form:label>
						 <br>   
	                    <form:checkboxes path="batches" items="${btches}" class="checkbox-inline"/>
	                    
	                    </div>
						<div class="form-group">
					    <label>Starting Hour</label>
                    		<div class="input-group">
		                    <input name="st" placeholder="hour" class="form-control"/>
		                    <div class="input-group-addon">00</div>
		   					 </div>
		                </div>
					<button id="register" name="register" class="btn btn-default">Submit</button>
            </form:form> 
 </div>
  </div>		
    </body>
    </html>