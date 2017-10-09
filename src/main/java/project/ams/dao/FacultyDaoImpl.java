package project.ams.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import project.ams.model.*;

public class FacultyDaoImpl implements FacultyDao {
  @Autowired
  DataSource datasource;
  @Autowired
  JdbcTemplate jdbcTemplate;
  public void register(Faculty user,String pass) {
    String sql = "insert into faculty values(?,?,?,?,?,?,?)";
    jdbcTemplate.update(sql, new Object[] { user.getId(), user.getEmail(),
    user.getName(), user.getDept(), user.getAddress(), user.getContact(), user.getStatus() });
    String sqlq2="insert into login values(?,?)";
    jdbcTemplate.update(sqlq2,user.getId(),pass);
    }
    public Faculty validateUser(Login login) {
    	String sql = "select * from faculty,login where faculty.id=login.id and login.id='" + login.getId() + "' and password='" + login.getPassword()
        + "'";
        List<Faculty> users = jdbcTemplate.query(sql, new FacMapper());
        return users.size() > 0 ? users.get(0) : null;
        }
	@Override
	public void rmfac(Integer id, String dept) {
		String sql="update faculty set status='i' where id=? and dept=?";
	    jdbcTemplate.update(sql,id,dept);
	}
	@Override
	public int getLastFid() {
		String sql="select id from faculty order by id DESC limit 1";
		List<Integer> id=jdbcTemplate.query(sql,new LastIdGetter());
		return id.get(0);
	}
	@Override
	public Faculty editFac(Integer id) {
		List<Faculty> l=jdbcTemplate.query("select * from faculty where id='"+id+"'",new FacMapper());
		return l.isEmpty()?null:l.get(0);
	}
	@Override
	public Faculty updateFac(int id, String p1, String p2, String p3, String p4, String p5) {
		String sql = "update faculty set name=? , email=? , dept=? , address=? , phone=? where id='" + id + "'";
		jdbcTemplate.update(sql,p1,p2,p3,p4,p5);
		List<Faculty> l=jdbcTemplate.query("select * from faculty where id='"+id+"'",new FacMapper());
		return l.isEmpty()?null:l.get(0);
		}
  }
  class FacMapper implements RowMapper<Faculty> {
  public Faculty mapRow(ResultSet rs, int arg1) throws SQLException {
    Faculty user = new Faculty();
    user.setId(rs.getInt(1));
    user.setEmail(rs.getString(2));
    user.setName(rs.getString(3));
    user.setDept(rs.getString(4));
    user.setAddress(rs.getString(5));
    user.setContact(rs.getString(6));
    user.setStatus(rs.getString(7));

    return user;
  }
  }
  class LastIdGetter implements RowMapper<Integer> {
  public Integer mapRow(ResultSet rs, int arg1) throws SQLException {  
  return rs.getInt(1);
  }
}