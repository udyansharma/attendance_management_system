<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>Add Batch</title>

<!-- Bootstrap -->
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">


<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="<c:url value="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js" />"></script>
      <script src="<c:url value="https://oss.maxcdn.com/respond/1.4.2/respond.min.js" />"></script>
    <![endif]-->
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script
	src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js" />"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script src="<c:url value="/resources/js/functions.js" />"></script>
<nav class="navbar navbar-default navbar-static-top">
<div class="container-fluid">
	<!-- Brand and toggle get grouped for better mobile display -->
	<div class="navbar-header ">
		<div class="navbar-header" align="center">
			<h3>Add Batch</h3>
		</div>
		<div style="float: right; margin-left: 1000px">
			<span><a href="acp">Change Password</a></span> <br> <span>Welcome
				${adminsession.id},${adminsession.name}</span> <br> <span><a
				href="admlogout">Logout</a></span>
		</div>
	</div>
</div>
<!-- /.container-fluid --> </nav>
</head>
<body>
	<div class="col-sm-2">
		<nav class="nav-sidebar">
		<ul class="nav tabs">
			<li class="active"><a href="add_stud">Add Student</a></li>
			<li class=""><a href="add_fac">Add Faculty</a></li>
			<li class=""><a href="add_batch">Add Batch</a></li>
			<li class=""><a href="add_subj">Add Subject</a></li>
			<li class=""><a href="chosestd">Remove Student</a></li>
			<li class=""><a href="chosefac">Remove Faculty</a></li>
			<li class=""><a href="admhome">Back To Home</a></li>
		</ul>
		</nav>
	</div>
	<div class="panel col-sm-4" align="center" style="margin-left: 250px;">
		<div class="panel-heading ">
			<h3 class="panel-title "></h3>
		</div>
		<div class="panel-body">
			<form:form id="addbatchForm" modelAttribute="add_bat"
				action="registerbatchProcess" method="post" onsubmit="addbatch()">
				<div class="form-group">
					<form:label path="name">Batch Name</form:label>
					<form:input path="name" name="name" id="name" class="form-control" required="true" />
					<div id="namem" style="color: red;"></div>
				</div>
				<div class="form-group">
					<form:label path="semester">Semester</form:label>
					<form:select path="semester" name="semester" id="sem"
						class="form-control" required="true">
						<option value="" selected>SELECT</option>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
						<option value="8">8</option>
					</form:select>
				</div>
				<div class="form-group">
					<form:label path="branch">Branch</form:label>
					<form:select path="branch" name="branch" id="branch"
						class="form-control" required="true">
						<option value="" selected />SELECT
                            <option value="CSE">CSE</option>
						<option value="IT">IT</option>
						<option value="CVL">CIVIL</option>
						<option value="MCH">MECHANICAL</option>
						<option value="ECE">ELECTRONICS AND COMM.</option>
						<option value="ELE">ELECTRICAL</option>
						<option value="PLY">POLYMER</option>
						<option value="BT">BIOTECH</option>
						<option value="BI">BIOINFORMATICS</option>
					</form:select>
				</div>

				<button id="register" name="register" class="btn btn-default">Add</button>
			</form:form>
		</div>
	</div>
</body>
</html>