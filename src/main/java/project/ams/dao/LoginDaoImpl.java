package project.ams.dao;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import project.ams.model.*;

public class LoginDaoImpl implements LoginDao {
  @Autowired
  DataSource datasource;
  @Autowired
  JdbcTemplate jdbcTemplate;
    public void changePass(Login login) {
    String sql = "update login set password=? where id=?";
    jdbcTemplate.update(sql, login.getPassword(),login.getId());
    }
  }