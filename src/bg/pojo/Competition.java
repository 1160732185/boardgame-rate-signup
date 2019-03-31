package bg.pojo;

public class Competition {
private String cno;
private String cname;
private String gno;
private int cpno;
public String getCno() {
	return cno;
}
public void setCno(String cno) {
	this.cno = cno;
}
public String getCname() {
	return cname;
}
public void setCname(String cname) {
	this.cname = cname;
}
public String getGno() {
	return gno;
}
public void setGno(String gno) {
	this.gno = gno;
}
public int getCpno() {
	return cpno;
}
public void setCpno(int cpno) {
	this.cpno = cpno;
}
public Competition() {
	super();
	// TODO Auto-generated constructor stub
}
public Competition(String cno, String cname, String gno, int cpno) {
	super();
	this.cno = cno;
	this.cname = cname;
	this.gno = gno;
	this.cpno = cpno;
}
}
