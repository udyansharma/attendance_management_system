package project.ams.dao;
import java.util.List;

import project.ams.model.*;
public interface SubjectDao {
  void register(Subject user);
  List<String> getsub(Integer sem,String dept);
  List<String> rgisteredSubs(String branch,String batch);
  void completesubreg(String id, List<String> branches);
}