package project.ams.model;
public class Attendance {
	private Integer studId;
	private String facName;
	private String subject;
	private String atten;
	private Integer start_time;
	private java.sql.Date date;
	public Integer getStudId() {
		return studId;
	}
	public void setStudId(Integer studId) {
		this.studId = studId;
	}
	public String getFacName() {
		return facName;
	}
	public void setFacName(String facName) {
		this.facName = facName;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getAtten() {
		return atten;
	}
	public void setAtten(String atten) {
		this.atten = atten;
	}
	public Integer getStart_time() {
		return start_time;
	}
	public void setStart_time(Integer start_time) {
		this.start_time = start_time;
	}
	public java.sql.Date getDate() {
		return date;
	}
	public void setDate(java.sql.Date date) {
		this.date = date;
	}
	}
