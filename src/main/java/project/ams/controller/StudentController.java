package project.ams.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import project.ams.model.*;
import project.ams.service.UserService;
@Controller
@SessionAttributes("studentsession")
public class StudentController {
  @Autowired
  UserService userService;
  @RequestMapping(value = "/studentlogin", method = RequestMethod.GET)
  public ModelAndView showstuLogin(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView("studentlogin");
    mav.addObject("student_login", new Login());
    return mav;
  }
  @RequestMapping(value = "/student_process", method = RequestMethod.POST)
  public ModelAndView studentProcess(HttpServletRequest request, HttpServletResponse response,
  @ModelAttribute("student_login") Login login) {
    ModelAndView mav = null;
    Student user = userService.validateStudent(login);
    if (null != user) {
    	if(user.getStatus().charAt(0)=='i'){
    		mav = new ModelAndView("studentlogin");
    	    mav.addObject("message", "Your account has been suspended.Please contact the administrator");
    	}
    	else{
	    mav = new ModelAndView("studenthome");
	    mav.addObject("studentsession",user);
	    }
    }
    else {
        mav = new ModelAndView("studentlogin");
        mav.addObject("message", "Invalid credentials");
    }
    return mav;
  }
  //Change Password
  @RequestMapping(value = "/scp", method = RequestMethod.GET)
  public ModelAndView getPass(HttpServletRequest request) {
    ModelAndView mav = new ModelAndView("schangepass");
    mav.addObject("schange", new Login());
    mav.addObject("studentsession",request.getSession().getAttribute("studentsession"));
    return mav;
  }
  @RequestMapping(value = "/schanged", method = RequestMethod.POST)
  public ModelAndView changePass(HttpServletRequest request, HttpServletResponse response,
  @ModelAttribute("schange") Login login) {
    ModelAndView mav = new ModelAndView("studenthome");
    userService.changePwd(login);
	mav.addObject("studentsession",request.getSession().getAttribute("studentsession"));
    mav.addObject("success_msg", "Password Succesfully Changed");
    return mav;
  }
  //View Attendance
  @RequestMapping(value = "/view_attenas", method = RequestMethod.GET)
  public ModelAndView choseSub(HttpServletRequest request) {
	  ModelAndView mav=new ModelAndView("attendance");
	  Student obj=(Student)request.getSession().getAttribute("studentsession");
	  Integer id=obj.getId();
	  String batch=obj.getBatch();
	  String branch=userService.getstudBranch(batch);
	  List<String> allsubs=userService.registrdSubs(branch,batch);
	  mav.addObject("allsubs",allsubs);
	  mav.addObject("attenperc",userService.getattenperc(id,allsubs));
	  mav.addObject("studentsession");
	  return mav;
  }
  //View Detailed Attendance
  @RequestMapping(value = "/viewdetailed/{subname}", method = RequestMethod.GET)
  public ModelAndView viewDetailed(@PathVariable("subname") String s,HttpServletRequest request) {
	  ModelAndView mav=new ModelAndView("detailedatten");
	  Student obj=(Student)request.getSession().getAttribute("studentsession");
	  Integer id=obj.getId();
	  List<Attendance> detailedatten=userService.detailedatten(id,s);
	  mav.addObject("adet",detailedatten);
	  mav.addObject("studentsession");
	  return mav;
  }

//Back to Home
@RequestMapping(value = "/stdhome", method = RequestMethod.GET)
public ModelAndView showstdhome() {
   ModelAndView mav=new ModelAndView("studenthome");
   mav.addObject("studentsession");
   return mav; 
}
//Logout
@RequestMapping(value = "/stdlogout", method = RequestMethod.GET)
public ModelAndView logout(SessionStatus session) {
	  session.setComplete();
	  return new ModelAndView("../home");
}
}