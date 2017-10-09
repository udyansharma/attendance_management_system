package project.ams.service;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.ams.dao.*;
import project.ams.model.*;
@Service
public class UserServiceImpl implements UserService {

  @Autowired
  public AdminDao adminDao;
  @Autowired
  public FacultyDao facultyDao;
  @Autowired
  public StudentDao studentDao;
  @Autowired
  public BatchDao batchDao;
  @Autowired
  public SubjectDao subjectDao;
  @Autowired
  public LoginDao loginDao;
  @Autowired
  public AttenDao attenDao;
  

@Override
public void registerStudent(Student user,String pass) {
	studentDao.register(user,pass);
	
}
@Override
public void remStudent(Integer id, String batch) {
	studentDao.rmStudent(id,batch);
}
@Override
public void registerFaculty(Faculty user,String pass) {
	facultyDao.register(user,pass);
}

@Override
public void registerBatch(Batch user) {
	batchDao.register(user);
	
}

@Override
public void registerSubject(Subject sub) {
	subjectDao.register(sub);
	
}

@Override
public Admin validateAdmin(Login login) {
	return adminDao.validateUser(login);
}

@Override
public Student validateStudent(Login login) {

	return studentDao.validateUser(login);
}

@Override
public Faculty validateFaculty(Login login) {

	return facultyDao.validateUser(login);
}

@Override
public void remFaculty(Integer id, String dept) {
	facultyDao.rmfac(id,dept);
}

@Override
public List<String> fetchsubs(Integer sem,String dept) {
	return subjectDao.getsub(sem,dept);	
}
@Override
public List<String> fetchbatches(Integer sem,String branch) {
	return batchDao.getBatch(sem,branch);
}

@Override
public List<Student> fetchStudentList(Subbatch user) {
	return studentDao.getStudents(user);
}

@Override
public void changePwd(Login login) {
	loginDao.changePass(login);
	
}

@Override
public void storeAtten(AttenList alist) {
	attenDao.updateAttentab(alist);
	
}
@Override
public List<String> registrdSubs(String branch,String batch) {
	// TODO Auto-generated method stub
	return subjectDao.rgisteredSubs(branch,batch);
}
@Override
public void comsubreg(String id, List<String> branches) {
	subjectDao.completesubreg(id,branches);
	
}
@Override
public List<Integer> getattenperc(Integer id,List<String> allsubs) {
	return attenDao.attenperc(id,allsubs);
}
@Override
public String getstudBranch(String batch) {
	return batchDao.getBranch(batch);
}
@Override
public int getLastFac() {
	// TODO Auto-generated method stub
	return facultyDao.getLastFid();
}
@Override
public List<String> getAllBatches() {
	// TODO Auto-generated method stub
	return batchDao.getAllBatch();
}
@Override
public Student editStudent(Integer parameter) {
	
	return studentDao.editStd(parameter);
}
@Override
public Student updateStudent(int p1, String p2, String p3, String p4, String p5, String p6, String p7) {
	// TODO Auto-generated method stub
	return studentDao.updStd(p1,p2,p3,p4,p5,p6,p7);
}
@Override
public Faculty editFaculty(Integer id) {
	// TODO Auto-generated method stub
	return facultyDao.editFac(id);
}
@Override
public Faculty updateFac(int id, String p1, String p2, String p3, String p4,
		String p5) {
	// TODO Auto-generated method stub
	return facultyDao.updateFac(id,p1,p2,p3,p4,p5);
}

@Override
public int getLastStd() {
	// TODO Auto-generated method stub
	return studentDao.getLastStd();
}
@Override
public List<Attendance> detailedatten(Integer id, String s) {
	// TODO Auto-generated method stub
	return attenDao.getDetailed(id,s);
}
@Override
public String editingatten(int id, String p1, Date p2, String p3) {
	// TODO Auto-generated method stub
	return attenDao.editAtten(id,p1,p2,p3);
}
}