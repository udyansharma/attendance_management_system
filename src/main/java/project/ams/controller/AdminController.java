package project.ams.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
@SessionAttributes("adminsession")
public class AdminController {
	@Autowired
	UserService userService;

	@RequestMapping(value = "/adminlogin", method = RequestMethod.GET)
	public ModelAndView showadmLogin() {
		ModelAndView mav = new ModelAndView("adminlogin");
		mav.addObject("admin_login", new Login());
		return mav;
	}

	@RequestMapping(value = "/admin_process", method = RequestMethod.POST)
	public ModelAndView adminProcess(@ModelAttribute("admin_login") Login login) {
		ModelAndView mav = null;
		Admin user = userService.validateAdmin(login);
		if (null != user) {
			if (user.getStatus().charAt(0) == 'i') {
				mav = new ModelAndView("adminlogin");
				mav.addObject("message", "Your account has been suspended.Please contact the administrator");

			} else {
				mav = new ModelAndView("adminhome");
				mav.addObject("adminsession", user);
			}
		} else {
			mav = new ModelAndView("adminlogin");
			mav.addObject("message", "Invalid credentials");
		}
		return mav;
	}

	// Change Password
	@RequestMapping(value = "/acp", method = RequestMethod.GET)
	public ModelAndView getPass() {
		ModelAndView mav = new ModelAndView("achangepass");
		mav.addObject("achange", new Login());
		mav.addObject("adminsession");
		return mav;
	}

	@RequestMapping(value = "/achanged", method = RequestMethod.POST)
	public ModelAndView changePass(@ModelAttribute("achange") Login login) {
		ModelAndView mav = new ModelAndView("adminhome");
		userService.changePwd(login);
		mav.addObject("adminsession");
		mav.addObject("success_msg", "Password Succesfully Changed");
		return mav;
	}

	// Student Handling
	@RequestMapping(value = "/add_stud", method = RequestMethod.GET)
	public ModelAndView dispSregister() {
		ModelAndView mav = new ModelAndView("addstudent");
		mav.addObject("add_student", new Student());
		mav.addObject("adminsession");
		mav.addObject("batches", userService.getAllBatches());
		mav.addObject("lastId", userService.getLastStd());
		return mav;
	}

	@RequestMapping(value = "/registerstudentProcess", method = RequestMethod.POST)
	public ModelAndView addStudent(HttpServletRequest request, @ModelAttribute("add_student") Student user) {
		userService.registerStudent(user, request.getParameter("password"));
		ModelAndView mav = new ModelAndView("addedstudent");
		mav.addObject("adminsession");
		mav.addObject("user", user);
		mav.addObject("success_msg", user.getId() + " has been successfully added as an Student");
		return mav;
	}

	@RequestMapping(value = "/editstud", method = RequestMethod.POST)
	public ModelAndView editstud(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("editstudent");
		mav.addObject("adminsession");
		mav.addObject("olduser", userService.editStudent(Integer.parseInt(request.getParameter("nayastud"))));
		mav.addObject("batches", userService.getAllBatches());
		return mav;
	}

	@RequestMapping(value = "/updatestud", method = RequestMethod.POST)
	public ModelAndView updatestud(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("addedstudent");
		mav.addObject("adminsession");
		mav.addObject("user",
				userService.updateStudent(Integer.parseInt(request.getParameter("id")), request.getParameter("name"),
						request.getParameter("email"), request.getParameter("batch"), request.getParameter("session"),
						request.getParameter("address"), request.getParameter("contact")));
		mav.addObject("success_msg", "Deatils of "+request.getParameter("id") + " have been successfully updated.");
		return mav;
	}

	@RequestMapping(value = "/chosestd", method = RequestMethod.GET)
	public ModelAndView choseStudent() {
		ModelAndView mav = new ModelAndView("deletestudent");
		mav.addObject("adminsession");
		return mav;
	}

	@RequestMapping(value = "/deletestd", method = RequestMethod.POST)
	public ModelAndView rmStudent(HttpServletRequest request) {
		userService.remStudent(Integer.parseInt(request.getParameter("id")), request.getParameter("batch"));
		ModelAndView mav = new ModelAndView("adminhome");
		mav.addObject("adminsession");
		mav.addObject("success_msg",
				Integer.parseInt(request.getParameter("id")) + " has been successfully removed as an Student");
		return mav;
	}

	// Faculty Handling
	@RequestMapping(value = "/add_fac", method = RequestMethod.GET)
	public ModelAndView dispFregister() {
		ModelAndView mav = new ModelAndView("addfaculty");
		mav.addObject("add_faculty", new Faculty());
		mav.addObject("adminsession");
		mav.addObject("lastId", userService.getLastFac());
		return mav;
	}

	@RequestMapping(value = "/registerfacultyProcess", method = RequestMethod.POST)
	public ModelAndView addFaculty(HttpServletRequest request, @ModelAttribute("add_faculty") Faculty user) {
		userService.registerFaculty(user, request.getParameter("password"));
		ModelAndView mav = new ModelAndView("addedfac");
		mav.addObject("adminsession");
		mav.addObject("user", user);
		mav.addObject("success_msg", user.getName() + " has been successfully added as an Faculty");
		return mav;
	}

	@RequestMapping(value = "/editfac", method = RequestMethod.POST)
	public ModelAndView editFac(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("editfaculty");
		mav.addObject("adminsession");
		mav.addObject("olduser", userService.editFaculty(Integer.parseInt(request.getParameter("newfac"))));
		return mav;
	}

	@RequestMapping(value = "/updatefac", method = RequestMethod.POST)
	public ModelAndView updateFac(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("addedfac");
		mav.addObject("adminsession");
		mav.addObject("user",
				userService.updateFac(Integer.parseInt(request.getParameter("id")), request.getParameter("name"),
						request.getParameter("email"), request.getParameter("dept"),
						request.getParameter("address"), request.getParameter("contact")));
		mav.addObject("success_msg", "Deatails of "+request.getParameter("id")+","+ request.getParameter("name") + " have been successfully updated.");
		return mav;
	}
	// Deleting Faculty
	@RequestMapping(value = "/chosefac", method = RequestMethod.GET)
	public ModelAndView choseFaculty() {
		ModelAndView mav = new ModelAndView("deletefaculty");
		mav.addObject("adminsession");
		return mav;
	}

	@RequestMapping(value = "/deletefac", method = RequestMethod.POST)
	public ModelAndView rmFaculty(HttpServletRequest request) {
		userService.remFaculty(Integer.parseInt(request.getParameter("id")), request.getParameter("dept"));
		ModelAndView mav = new ModelAndView("adminhome");
		mav.addObject("adminsession");
		mav.addObject("success_msg",
				Integer.parseInt(request.getParameter("id")) + " has been successfully removed as an Faculty");
		return mav;
	}

	// Batch Handling
	@RequestMapping(value = "/add_batch", method = RequestMethod.GET)
	public ModelAndView dispBatchform() {
		ModelAndView mav = new ModelAndView("addbatch");
		mav.addObject("adminsession");
		mav.addObject("add_bat", new Batch());
		return mav;
	}

	@RequestMapping(value = "/registerbatchProcess", method = RequestMethod.POST)
	public ModelAndView addBatch(@ModelAttribute("add_batch") Batch user) {
		userService.registerBatch(user);
		ModelAndView mav = new ModelAndView("adminhome");
		mav.addObject("adminsession");
		mav.addObject("success_msg", "Batch " + user.getName() + " has been successfully added");
		return mav;
	}

	// Subject Handling
	@RequestMapping(value = "/add_subj", method = RequestMethod.GET)
	public ModelAndView dispSubjform() {
		ModelAndView mav = new ModelAndView("addsubject");
		mav.addObject("adminsession");
		mav.addObject("add_sub", new Subject());
		return mav;
	}

	@RequestMapping(value = "/addsubjectProcess", method = RequestMethod.POST)
	public ModelAndView addSubj(HttpServletRequest request, @ModelAttribute("add_sub") Subject user) {
		userService.registerSubject(user);
		List<String> branches = Arrays.asList(request.getParameterValues("branch"));
		userService.comsubreg(user.getId(), branches);
		ModelAndView mav = new ModelAndView("adminhome");
		mav.addObject("adminsession");
		mav.addObject("success_msg", "Subject " + user.getName() + " has been successfully added");
		return mav;
	}

	// Back to Home
	@RequestMapping(value = "/admhome", method = RequestMethod.GET)
	public ModelAndView showadmhome() {
		ModelAndView mav = new ModelAndView("adminhome");
		mav.addObject("adminsession");
		return mav;
	}

	// Logout
	@RequestMapping(value = "/admlogout", method = RequestMethod.GET)
	public ModelAndView logout(SessionStatus session) {
		session.setComplete();
		return new ModelAndView("../home");
	}

	// Duplicate Entry Exception Handling
	@ExceptionHandler(org.springframework.dao.DuplicateKeyException.class)
	public ModelAndView handleError() {
		ModelAndView mav = new ModelAndView("adminhome");
		mav.addObject("success_msg", "Already Registered.");
		return mav;
	}

}