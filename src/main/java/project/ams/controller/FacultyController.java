package project.ams.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import project.ams.model.*;
import project.ams.service.UserService;

@Controller
@SessionAttributes("facultysession")
public class FacultyController {
	@Autowired
	UserService userService;

	@RequestMapping(value = "/facultylogin", method = RequestMethod.GET)
	public ModelAndView showfacLogin() {
		ModelAndView mav = new ModelAndView("facultylogin");
		mav.addObject("faculty_login", new Login());
		return mav;
	}

	@RequestMapping(value = "/faculty_process", method = RequestMethod.POST)
	public ModelAndView facultyProcess(@ModelAttribute("faculty_login") Login login) {
		ModelAndView mav = null;
		Faculty user = userService.validateFaculty(login);
		if (null != user) {
			if (user.getStatus().charAt(0) == 'i') {
				mav = new ModelAndView("facultylogin");
				mav.addObject("message", "Your account has been suspended.Please contact the administrator");
			} else {
				mav = new ModelAndView("facultyhome");
				mav.addObject("facultysession", user);
			}
		} else {
			mav = new ModelAndView("facultylogin");
			mav.addObject("message", "Invalid credentials");
		}
		return mav;
	}

	// Change Password
	@RequestMapping(value = "/fcp", method = RequestMethod.GET)
	public ModelAndView getPass() {
		ModelAndView mav = new ModelAndView("fchangepass");
		mav.addObject("fchange", new Login());
		mav.addObject("facultysession");
		return mav;
	}

	@RequestMapping(value = "/fchanged", method = RequestMethod.POST)
	public ModelAndView changePass(@ModelAttribute("fchange") Login login) {
		ModelAndView mav = new ModelAndView("facultyhome");
		userService.changePwd(login);
		mav.addObject("facultysession");
		mav.addObject("success_msg", "Password Succesfully Changed");
		return mav;
	}

	// Editing Attendance
	@RequestMapping(value = "/edit_atten", method = RequestMethod.GET)
	public ModelAndView getDeatils() {
		ModelAndView mav = new ModelAndView("editattendance");
		mav.addObject("facultysession");
		return mav;
	}
	@RequestMapping(value = "/chose_sube", method = RequestMethod.POST)
	public ModelAndView choseSube(HttpServletRequest request) {
		ModelAndView mav ;
		List<String> s=userService.fetchsubs(Integer.parseInt(request.getParameter("sem")), request.getParameter("dept"));
		if(s==null){
			mav= new ModelAndView("editattendance");
			mav.addObject("success_msg", "You don't take classes of Sem:"+request.getParameter("sem"));
		}
		else{
			mav=new ModelAndView("subjectselectione");
			mav.addObject("subs",s);
			mav.addObject("sid",Integer.parseInt(request.getParameter("id")));
		}
		mav.addObject("facultysession");
		return mav;
	}
	
	@RequestMapping(value = "/edit_attendance", method = RequestMethod.GET)
	public ModelAndView editStudent(HttpServletRequest request) {
		String msg=userService.editingatten(Integer.parseInt(request.getParameter("id")),request.getParameter("sub"),java.sql.Date.valueOf(request.getParameter("date")),request.getParameter("st"));
		ModelAndView mav= new ModelAndView("editattendance");;
		if(msg==null){
			mav.addObject("success_msg", "No such class was taken");
		}
		else{
			mav.addObject("success_msg", request.getParameter("id")+" has been marked present");
		}
		mav.addObject("facultysession");
		return mav;
	}
	
	// ChosingSem
	@RequestMapping(value = "/update_atten", method = RequestMethod.GET)
	public ModelAndView choseSem() {
		ModelAndView mav = new ModelAndView("semselection");
		mav.addObject("facultysession");
		return mav;
	}

	// Displaying Subjects
	@RequestMapping(value = "/chose_sub", method = RequestMethod.POST)
	public ModelAndView choseSub(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("batchselection");
		mav.addObject("subs",
				userService.fetchsubs(Integer.parseInt(request.getParameter("sem")), request.getParameter("dept")));
		mav.addObject("btches", userService.fetchbatches(Integer.parseInt(request.getParameter("sem")),
				request.getParameter("branch")));
		mav.addObject("facultysession");
		mav.addObject("subbatch", new Subbatch());
		return mav;
	}

	@RequestMapping(value = "/disp_students", method = RequestMethod.GET)
	public ModelAndView addStudent(HttpServletRequest request, @ModelAttribute("subbatch") Subbatch user) {
		ModelAndView mav = new ModelAndView("update");
		ArrayList<String> attstatus = new ArrayList<String>();
		attstatus.add("a");
		attstatus.add("p");
		mav.addObject("facultysession");
		mav.addObject("students", userService.fetchStudentList(user));
		mav.addObject("sub", user.getSubjct());
		mav.addObject("starttime", Integer.parseInt(request.getParameter("st")));
		long millis = System.currentTimeMillis();
		mav.addObject("currdate", new java.sql.Date(millis));
		mav.addObject("attentab", new AttenList());
		mav.addObject("atst", attstatus);
		return mav;
	}

	// Displaying Entries
	/*
	 * @RequestMapping(value = "/diatt", method = RequestMethod.POST) public
	 * ModelAndView dispAtten(HttpServletRequest
	 * request, @ModelAttribute("attentab") AttenList alist) { ModelAndView
	 * mav=new ModelAndView("displaypage"); mav.addObject("facutysession");
	 * mav.addObject("ids",alist.getId()); mav.addObject("alist",alist); return
	 * mav; }
	 */
	// Adding Entries to Attendance Table
	@RequestMapping(value = "/feedatten", method = RequestMethod.POST)
	public ModelAndView feedAtten(HttpServletRequest request, @ModelAttribute("attentab") AttenList alist) {
		ModelAndView mav = new ModelAndView("facultyhome");
		userService.storeAtten(alist);
		mav.addObject("success_msg", "Attendance Succesfully Updated");
		return mav;
	}

	// Back to Home
	@RequestMapping(value = "/fachome", method = RequestMethod.GET)
	public ModelAndView showfachome() {
		ModelAndView mav = new ModelAndView("facultyhome");
		mav.addObject("facultysession");
		return mav;
	}

	// Logout
	@RequestMapping(value = "/faclogout", method = RequestMethod.GET)
	public ModelAndView logout(SessionStatus session) {
		session.setComplete();
		return new ModelAndView("../home");
	}

	// Illegal State Exception
	@ExceptionHandler(org.springframework.dao.EmptyResultDataAccessException.class)
	public ModelAndView handleError2() {
		ModelAndView mav = new ModelAndView("update_atten");
		mav.addObject("msg", "No match found with such specifications");
		return mav;
	}
}