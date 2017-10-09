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

public class SubjectDaoImpl implements SubjectDao {
  @Autowired
  DataSource datasource;
  @Autowired
  JdbcTemplate jdbcTemplate;
  public void register(Subject sub) {
    String sql = "insert into subject values(?,?,?,?)";
    jdbcTemplate.update(sql, new Object[] { sub.getId(),sub.getName(), sub.getDept(), sub.getSemester() });
    }
  public List<String> getsub(Integer sem,String dept){
	  String sql = "select * from subject where semester='" + sem + "' and dept='" + dept +"'";
	    List<Subject> users = jdbcTemplate.query(sql, new SubjectMapper());
	    ListIterator<Subject> litr=users.listIterator();
	    List<String> subs=new ArrayList<String>();
	    while(litr.hasNext()){
	    	Subject sub=litr.next();
	    	subs.add("("+sub.getId()+")"+sub.getName());
	    }
	    return subs.size() > 0 ?  subs: null;   
  }
@Override
public List<String> rgisteredSubs(String branch,String batch) {
	String sql="select subject.name,subject.id from subject,subbranch,batch where subject.id=subbranch.id and subject.semester=batch.semester and batch.name='"+ batch +"' and (branch1='"+branch+"'or branch2='"+branch+"'or branch3='"+branch+"'or branch4='"+branch+"' or branch5='"+branch+"'or branch6='"+branch+"'or branch7='"+branch+"'or branch8='"+branch+"')";
	List<String> names=jdbcTemplate.query(sql,new SubnameListMapper());
	List<String> ids=jdbcTemplate.query(sql,new SubidListMapper());
	List<String> subs=new ArrayList<String>();
	ListIterator<String> l1=names.listIterator();
	ListIterator<String> l2=ids.listIterator();
	while(l1.hasNext()){
		subs.add("("+l2.next()+")"+l1.next());
	}
	return subs.size() > 0 ?  subs: null;   
}
@Override
public void completesubreg(String id, List<String> branches) {
	String sql="insert into subbranch (id) values(?)";
	jdbcTemplate.update(sql,id);
	ListIterator<String> l=branches.listIterator();
	String sql1="update subbranch set branch1=? where id='"+id+"'";
	jdbcTemplate.update(sql1,l.next());
	if(l.hasNext()){
		String sql2="update subbranch set branch2=? where id='"+id+"'";
		jdbcTemplate.update(sql2,l.next());
	}
	if(l.hasNext()){
		String sql3="update subbranch set branch3=? where id='"+id+"'";
		jdbcTemplate.update(sql3,l.next());
	}
	if(l.hasNext()){
		String sql4="update subbranch set branch4=? where id='"+id+"'";
		jdbcTemplate.update(sql4,l.next());
	}
	if(l.hasNext()){
		String sql5="update subbranch set branch5=?  where id='"+id+"'";
		jdbcTemplate.update(sql5,l.next());
	}
	if(l.hasNext()){
		String sql6="update subbranch set branch6=?  where id='"+id+"'";
		jdbcTemplate.update(sql6,l.next());
	}
	if(l.hasNext()){
		String sql7="update subbranch set branch7=?  where id='"+id+"'";
		jdbcTemplate.update(sql7,l.next());
	}
	if(l.hasNext()){
		String sql8="update subbranch set branch8=?  where id='"+id+"'";
		jdbcTemplate.update(sql8,l.next());
	}
	if(l.hasNext()){
		String sql9="update subbranch set branch9=?  where id='"+id+"'";
		jdbcTemplate.update(sql9,l.next());
	}
	
}

}
class SubjectMapper implements RowMapper<Subject> {
	  public Subject mapRow(ResultSet rs, int arg1) throws SQLException {
	    Subject user = new Subject();
	    user.setId(rs.getString(1));
	    user.setName(rs.getString(2));
	    user.setDept(rs.getString(3));
	    user.setSemester(rs.getInt(4));	    
	    return user;
	  }
}
class SubnameListMapper implements RowMapper<String> {
	  public String mapRow(ResultSet rs, int arg1) throws SQLException {
	    return rs.getString(1);
	  }
}
class SubidListMapper implements RowMapper<String> {
	  public String mapRow(ResultSet rs, int arg1) throws SQLException {
	    return rs.getString(2);
	  }
}