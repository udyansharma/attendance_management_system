package project.ams.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapper;

import project.ams.model.*;

public class BatchDaoImpl implements BatchDao {
  @Autowired
  DataSource datasource;
  @Autowired
  JdbcTemplate jdbcTemplate;
  public void register(Batch user) {
    String sql = "insert into batch values(?,?,?)";
    jdbcTemplate.update(sql, new Object[] { user.getName(),user.getSemester(),user.getBranch() });
    }
@Override
public List<String> getBatch(Integer sem, String branch) {
	String sql = "select * from batch where semester='" + sem + "' and branch='" + branch +"'";
    List<Batch> users = jdbcTemplate.query(sql, new BatchMapper());
    ListIterator<Batch> litr=users.listIterator();
    List<String> batches=new ArrayList<String>();
    while(litr.hasNext()){
    	batches.add(litr.next().getName());
    }
    return batches.size() > 0 ?  batches: null;
}
@Override
public String getBranch(String batch) {
	String sql ="select branch from batch where name='"+batch+"'";
	List<String> a= jdbcTemplate.query(sql,new SingleBatchMapper());
	return a.get(0);
}
@Override
public List<String> getAllBatch() {
	String sql ="select name from batch";
	return jdbcTemplate.query(sql,new SingleBatchMapper());
}
}

class BatchMapper implements RowMapper<Batch> {
	  public Batch mapRow(ResultSet rs, int arg1) throws SQLException {
		  Batch user = new Batch();
	    user.setName(rs.getString(1));
	    user.setSemester(rs.getInt(2));	 
	    user.setBranch(rs.getString(3));
	    return user;
	  }
}
class SingleBatchMapper implements RowMapper<String> {
	  public String mapRow(ResultSet rs, int arg1) throws SQLException {
		 return rs.getString(1);
	  }
}