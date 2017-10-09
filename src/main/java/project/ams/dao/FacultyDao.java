package project.ams.dao;
import project.ams.model.*;
public interface FacultyDao {
  void register(Faculty user,String pass);
  void rmfac(Integer id, String dept);
  Faculty validateUser(Login login);
  int getLastFid();
  Faculty editFac(Integer id);
  Faculty updateFac(int id, String p1, String p2, String p3, String p4, String p5);
}