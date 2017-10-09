package project.ams.dao;
import project.ams.model.*;
public interface AdminDao {
  Admin validateUser(Login login);
}