package project.ams.dao;
import java.util.List;

import project.ams.model.*;
public interface BatchDao {
  void register(Batch user);
  List<String> getBatch(Integer sem,String branch);
  String getBranch(String batch);
  List<String> getAllBatch();
}