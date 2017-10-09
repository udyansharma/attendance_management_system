package project.ams.model;
//import java.util.ArrayList;
import java.util.List;
//import java.util.List;
//import org.springframework.util.AutoPopulatingList;
//import java.sql.Date;
public class AttenList {
	
	private List<String> id;
	private String fname;
	private String sub;
	private List<String> att;
	private Integer start_time;
	private String date;
	public AttenList(){}
	public List<String> getId() {
		return id;
	}
	public void setId(List<String> id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getSub() {
		return sub;
	}
	public void setSub(String sub) {
		this.sub = sub;
	}
	public List<String> getAtt() {
		return att;
	}
	public void setAtt(List<String> att) {
		this.att = att;
	}
	public Integer getStart_time() {
		return start_time;
	}
	public void setStart_time(Integer start_time) {
		this.start_time = start_time;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	}