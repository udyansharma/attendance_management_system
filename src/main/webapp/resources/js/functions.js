function admlgn(){
	document.getElementById("idm").innerHTML="";
	document.getElementById("pwm").innerHTML="";
	var ids=document.forms["admlgForm"]["id"].value;
	if(isNaN(ids)){
		document.getElementById("id").focus();
		document.getElementById("idm").innerHTML="Numeric Input Only";
		return false;
	}
}
function faclgn(){
	document.getElementById("fidm").innerHTML="";
	var ids=document.forms["faclgForm"]["fid"].value;
	if(isNaN(ids)){
		document.getElementById("fid").focus();
		document.getElementById("fidm").innerHTML="Numeric Input Only";
		return false;
	}
}
function stdlgn(){
	document.getElementById("sidm").innerHTML="";
	var ids=document.forms["stdlgForm"]["sid"].value;
	if(isNaN(ids)){
		document.getElementById("sid").focus();
		document.getElementById("sidm").innerHTML="Numeric Input Only";
		return false;
	}
}
function admcp(){
	document.getElementById("pass").innerHTML="";
	document.getElementById("cnfpass").innerHTML="";
	var pass=document.forms["acpForm"]["pass"].value;
	var cnf=document.forms["acpForm"]["cnfpass"].value;
	
    if(pass != "" && pass == cnf) {
      if(pass.length < 6) {
        document.getElementById("pass").focus();
        document.getElementById("passm").innerHTML="Password must contain at least six characters!";
        return false;
      }
    } 
    else {
      document.getElementById("cnfpass").focus();
      document.getElementById("cnfpassm").innerHTML="Please check that you've entered and confirmed your password!";
      return false;
    }
     return true;
}
function faccp(){
	document.getElementById("pass").innerHTML="";
	document.getElementById("cnfpass").innerHTML="";
	var pass=document.forms["facForm"]["pass"].value;
	var cnf=document.forms["facForm"]["cnfpass"].value;
	
    if(pass != "" && pass == cnf) {
      if(pass.length < 6) {
        document.getElementById("pass").focus();
        document.getElementById("passm").innerHTML="Password must contain at least six characters!";
        return false;
      }
    } 
    else {
      document.getElementById("cnfpass").focus();
      document.getElementById("cnfpassm").innerHTML="Please check that you've entered and confirmed your password!";
      return false;
    }
     return true;
  }

function stdcp(){
	document.getElementById("pass").innerHTML="";
	document.getElementById("cnfpass").innerHTML="";
	var pass=document.forms["stdForm"]["pass"].value;
	var cnf=document.forms["stdForm"]["cnfpass"].value;
	
    if(pass != "" && pass == cnf) {
      if(pass.length < 6) {
        document.getElementById("pass").focus();
        document.getElementById("passm").innerHTML="Password must contain at least six characters!";
        return false;
      }
    } 
    else {
      document.getElementById("cnfpass").focus();
      document.getElementById("cnfpassm").innerHTML="Please check that you've entered and confirmed your password!";
      return false;
    }
     return true;
  }
function addbatch(){
	document.getElementById("namem").innerHTML="";
	var name=document.forms["addbatchForm"]["name"].value;
	if(name.length!=2){
		document.getElementById("name").focus();
        document.getElementById("namem").innerHTML="Batch Name must be of length 2";
        return false;
	}
	if(!isNaN(name)){
		document.getElementById("name").focus();
        document.getElementById("namem").innerHTML="Alphanumeric Input Only";
        return false;
	
	}
	return true;
	
}
function addFac(){

	document.getElementById("namem").innerHTML="";
	document.getElementById("contactm").innerHTML="";
	var num=document.forms["addFacForm"]["contact"].value;
	var name=document.forms["addFacForm"]["name"].value;
	if(!isNaN(name)){
		document.getElementById("name").focus();
		document.getElementById("namem").innerHTML='Alphabetic Input Only';
		return false;
		
	}
	if(isNaN(num) || num.length!=10){
		document.getElementById("contact").focus();
		document.getElementById("contactm").innerHTML='Please Enter A valid Phone number';
		return false;
	}
	return true;
}
function editFac(){

	document.getElementById("namem").innerHTML="";
	document.getElementById("contactm").innerHTML="";
	var num=document.forms["editFacForm"]["contact"].value;
	var name=document.forms["editFacForm"]["name"].value;
	if(!isNaN(name)){
		document.getElementById("name").focus();
		document.getElementById("namem").innerHTML='Alphabetic Input Only';
		return false;
		
	}
	if(isNaN(num) || num.length!=10){
		document.getElementById("contact").focus();
		document.getElementById("contactm").innerHTML='Please Enter A valid Phone number';
		return false;
	}
	return true;
}
function addStd(){
	document.getElementById("namem").innerHTML="";
	document.getElementById("sessionm").innerHTML="";
	document.getElementById("contactm").innerHTML="";
	var num=document.forms["addStdForm"]["contact"].value;
	var name=document.forms["addStdForm"]["name"].value;
	var ses=document.forms["addStdForm"]["session"].value;
	if(!isNaN(name)){
		document.getElementById("name").focus();
		document.getElementById("namem").innerHTML='Alphabetic Input Only';
		return false;
		
	}
	if(!isNaN(ses) || ses.length!=5){
		document.getElementById("session").focus();
		document.getElementById("sessionm").innerHTML='Please Enter A valid Session(yy-yy)';
		return false;
	}
	if(isNaN(num) || num.length!=10){
		document.getElementById("contact").focus();
		document.getElementById("contactm").innerHTML='Please Enter A valid Phone number';
		return false;
		}	
	return true;
}
function validation(){
document.getElementById("fn").innerHTML="";
document.getElementById("ln").innerHTML="";
document.getElementById("cp").innerHTML="";
document.getElementById("nm").innerHTML="";
var fname=document.forms["lform"]["fname"].value;
var lname=document.forms["lform"]["lname"].value;
var email=document.forms["lform"]["email"].value;
var pwd=document.forms["lform"]["pwd"].value;
var cpwd=document.forms["lform"]["cpwd"].value;
var num=document.forms["lform"]["mnum"].value;
if(!isNaN(fname)){
document.getElementById("fname").focus();
document.getElementById("fn").innerHTML='Alphabetic Input Only';
return false;
}
if(!isNaN(lname)){
document.getElementById("lname").focus();
document.getElementById("ln").innerHTML='Alphabetic Input Only';
return false;
}
if(pwd!=cpwd){
document.getElementById("cpwd").focus();
document.getElementById("cp").innerHTML='The passwords do not match!';
return false;
}
if(isNaN(num) || num.length!=10){
document.getElementById("mnum").focus();
document.getElementById("nm").innerHTML='Please Enter A valid Phone number';
return false;
}
}