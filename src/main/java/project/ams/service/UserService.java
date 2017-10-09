package project.ams.service;

import java.sql.Date;
import java.util.List;

import project.ams.model.*;

public interface UserService {
	void registerStudent(Student user, String pass);

	void registerFaculty(Faculty user, String pass);

	void registerBatch(Batch user);

	void registerSubject(Subject sub);

	void changePwd(Login login);

	void storeAtten(AttenList alist);

	void remStudent(Integer id, String batch);

	void remFaculty(Integer id, String dept);

	Admin validateAdmin(Login login);

	Student validateStudent(Login login);

	Student editStudent(Integer parameter);

	Student updateStudent(int p1, String p2, String p3, String p4, String p5,
			String p6, String p7);

	Faculty validateFaculty(Login login);

	Faculty editFaculty(Integer id);

	Faculty updateFac(int parseInt, String parameter, String parameter2, String parameter3, String parameter4,
			String parameter5);
	List<String> fetchsubs(Integer sem, String dept);

	List<String> fetchbatches(Integer sem, String branch);

	List<Student> fetchStudentList(Subbatch user);

	List<String> registrdSubs(String branch, String batch);

	List<Integer> getattenperc(Integer id, List<String> allsubs);

	String getstudBranch(String batch);

	void comsubreg(String id, List<String> branches);

	int getLastFac();

	List<String> getAllBatches();

	int getLastStd();

	List<Attendance> detailedatten(Integer id, String s);


	String editingatten(int parseInt, String parameter, Date valueOf, String parameter2);


}