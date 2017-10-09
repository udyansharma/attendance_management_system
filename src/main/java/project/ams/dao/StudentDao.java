package project.ams.dao;
import java.util.List;

import project.ams.model.*;
public interface StudentDao {
  void register(Student user,String pass);
  void rmStudent(Integer id, String batch);
  Student validateUser(Login login);
  List<Student> getStudents(Subbatch user);
  Student editStd(Integer parameter);
  Student updStd(int p1, String p2, String p3, String p4, String p5, String p6, String p7);
  int getLastStd();
}