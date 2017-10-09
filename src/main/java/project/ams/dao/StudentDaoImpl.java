package project.ams.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import project.ams.model.Login;
import project.ams.model.Student;
import project.ams.model.Subbatch;

public class StudentDaoImpl implements StudentDao {
	@Autowired
	DataSource datasource;
	@Autowired
	JdbcTemplate jdbcTemplate;

	public void register(Student user, String pass) {
		String sql = "insert into student values(?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql, new Object[] { user.getId(), user.getEmail(), user.getName(), user.getBatch(),
				user.getSession(), user.getAddress(), user.getContact(), user.getStatus() });
		String sqlq2 = "insert into login values(?,?)";
		jdbcTemplate.update(sqlq2, user.getId(), pass);
	}

	public Student validateUser(Login login) {
		String sql = "select * from student,login where student.id=login.id and login.id='" + login.getId()
				+ "' and password='" + login.getPassword() + "'";
		List<Student> users = jdbcTemplate.query(sql, new StudentMapper());
		return users.size() > 0 ? users.get(0) : null;
	}

	@Override
	public List<Student> getStudents(Subbatch user) {
		List<Student> users = new ArrayList<Student>();
		ListIterator<String> ltr = user.getBatches().listIterator();
		while (ltr.hasNext()) {
			String sql = "select * from student where student.batch='" + ltr.next() + "'";
			users.addAll(jdbcTemplate.query(sql, new StudentMapper()));
		}
		return users;
	}

	@Override
	public void rmStudent(Integer id, String batch) {
		String sql = "update student set status='i' where id=? and batch=?";
		jdbcTemplate.update(sql, id, batch);

	}

	@Override
	public Student editStd(Integer parameter) {
		String sql = "select * from student where id='" + parameter + "'";
		List<Student> a = jdbcTemplate.query(sql, new StudentMapper());
		System.out.println(a.get(0).getId());
		return a.isEmpty() ? null : a.get(0);
	}

	@Override
	public Student updStd(int p1, String p2, String p3, String p4, String p5, String p6, String p7) {
		String sql = "update student set name=?, email=? ,batch=? , session=? , address=? , phone=?  where id='" + p1
				+ "'";
		jdbcTemplate.update(sql, p2, p3, p4, p5, p6, p7);
		String sql1 = "select * from student where id='" + p1 + "'";
		List<Student> l = jdbcTemplate.query(sql1, new StudentMapper());
		System.out.println(l.get(0).getId());
		return l.isEmpty() ? null : l.get(0);

	}

	@Override
	public int getLastStd() {
		// TODO Auto-generated method stub
		String sql="select id from student order by id DESC limit 1";
		List<Integer> id=jdbcTemplate.query(sql,new LastIdGetterstd());
		return id.get(0);
	}

}

class StudentMapper implements RowMapper<Student> {
	public Student mapRow(ResultSet rs, int arg1) throws SQLException {
		Student user = new Student();
		user.setId(rs.getInt(1));
		user.setEmail(rs.getString(2));
		user.setName(rs.getString(3));
		user.setBatch(rs.getString(4));
		user.setSession(rs.getString(5));
		user.setAddress(rs.getString(6));
		user.setContact(rs.getString(7));
		user.setStatus(rs.getString(8));
		return user;
	}
}
class LastIdGetterstd implements RowMapper<Integer> {
public Integer mapRow(ResultSet rs, int arg1) throws SQLException {  
return rs.getInt(1);
}
}