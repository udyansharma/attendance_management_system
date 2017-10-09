package project.ams.dao;
import java.sql.Date;
import java.util.List;

import project.ams.model.*;
public interface AttenDao {
  void updateAttentab(AttenList alist);
  List<String> registrdSubs(Integer id);
  List<Integer> attenperc(Integer id,List<String> allsubs);
  List<Attendance> getDetailed(Integer id, String s);
  String editAtten(int id, String p1, Date p2, String p3);
}