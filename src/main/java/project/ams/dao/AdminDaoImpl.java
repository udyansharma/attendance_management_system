package project.ams.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import project.ams.model.*;

public class AdminDaoImpl implements AdminDao {
  @Autowired
  DataSource datasource;
  @Autowired
  JdbcTemplate jdbcTemplate;
    public Admin validateUser(Login login) {
    String sql = "select admin.id,admin.email,admin.name,admin.address,admin.phone,admin.status from admin,login where admin.id=login.id and login.id='" + login.getId() + "' and login.password='" + login.getPassword() +"'";
    List<Admin> users = jdbcTemplate.query(sql, new AdminMapper());
    return users.size() > 0 ? users.get(0) : null;
    }
  }
  class AdminMapper implements RowMapper<Admin> {
  public Admin mapRow(ResultSet rs, int arg1) throws SQLException {
    Admin user = new Admin();
    user.setId(rs.getInt(1));
    user.setEmail(rs.getString(2));
    user.setName(rs.getString(3));
    user.setAddress(rs.getString(4));
    user.setContact(rs.getString(5));
    user.setStatus(rs.getString(6));
    return user;
  }
}