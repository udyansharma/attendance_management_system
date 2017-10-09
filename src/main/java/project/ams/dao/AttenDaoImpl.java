package project.ams.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import project.ams.model.*;

public class AttenDaoImpl implements AttenDao {
	@Autowired
	DataSource datasource;
	@Autowired
	JdbcTemplate jdbcTemplate;

	public void updateAttentab(AttenList alist) {
		String sql = "insert into attendance values(?,?,?,?,?,?)";
		ListIterator<String> ltr = alist.getId().listIterator();
		ListIterator<String> ltr1 = alist.getAtt().listIterator();
		while (ltr.hasNext()) {
			Integer a = Integer.parseInt(ltr.next());
			String aten = ltr1.next();
			jdbcTemplate.update(sql, a, alist.getSub(), aten, alist.getStart_time(), alist.getDate(), alist.getFname());
		}
	}

	@Override
	public List<Integer> attenperc(Integer id, List<String> allsubs) {
		ListIterator<String> ltr = allsubs.listIterator();
		List<Integer> users = new ArrayList<Integer>();
		while (ltr.hasNext()) {
			String cur = ltr.next();
			String sql = "select (select COUNT(atten)*100 from attendance where student_id='" + id
					+ "' and subject_name='" + cur + "' and atten='p')/COUNT(*) from attendance where student_id='" + id
					+ "' and subject_name='" + cur + "'";
			users.addAll(jdbcTemplate.query(sql, new PerMapper()));
			System.out.print(users.get(0));
		}
		return users.size() > 0 ? users : null;
	}

	@Override
	public List<String> registrdSubs(Integer id) {
		String sql = "select DISTINCT(subject_name) from attendance where student_id='" + id + "'";
		List<String> users = jdbcTemplate.query(sql, new SubMapper());
		return users.size() > 0 ? users : null;
	}

	@Override
	public List<Attendance> getDetailed(Integer id, String s) {
		// TODO Auto-generated method stub
		String sql = "select * from attendance where student_id='" + id + "' and subject_name='" + s + "'";
		List<Attendance> users = jdbcTemplate.query(sql, new AttenMapper());
		return users.size() > 0 ? users : null;
	}

	@Override
	public String editAtten(int id, String p1, Date p2, String p3) {
		String sqltest="select * from attendance where student_id='" + id + "' and subject_name='" + p1 + "'and date='" + p2 + "'and start_time='" + p3 + "'";
		List<Attendance> users=jdbcTemplate.query(sqltest, new AttenMapper());
		if(users.isEmpty()){
			return null;
		}
		else{
			String sql = "update attendance set atten=? where student_id='" + id + "'and subject_name='" + p1
					+ "' and date='" + p2 + "'and start_time='" + p3 + "'";
			jdbcTemplate.update(sql,"p");
		}
		return "Has been successfully marked as Present";
	}
}

class SubMapper implements RowMapper<String> {
	public String mapRow(ResultSet rs, int arg1) throws SQLException {
		return rs.getString(1);
	}
}

class PerMapper implements RowMapper<Integer> {
	public Integer mapRow(ResultSet rs, int arg1) throws SQLException {
		return rs.getInt(1);
	}
}

class AttenMapper implements RowMapper<Attendance> {
	public Attendance mapRow(ResultSet rs, int arg1) throws SQLException {
		Attendance user = new Attendance();
		user.setStudId(rs.getInt(1));
		user.setSubject(rs.getString(2));
		user.setAtten(rs.getString(3));
		user.setStart_time(rs.getInt(4));
		user.setDate(rs.getDate(5));
		user.setFacName(rs.getString(6));
		return user;
	}
}