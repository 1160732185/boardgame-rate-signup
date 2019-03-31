package bg.pojo;

public class Rate {
private int pno;
private String gno;
private int rate;
public int getPno() {
	return pno;
}
public void setPno(int pno) {
	this.pno = pno;
}
public String getGno() {
	return gno;
}
public void setGno(String gno) {
	this.gno = gno;
}
public int getRate() {
	return rate;
}
public void setRate(int rate) {
	this.rate = rate;
}
public Rate(int pno, String gno, int rate) {
	super();
	this.pno = pno;
	this.gno = gno;
	this.rate = rate;
}
public Rate() {
	super();
	// TODO Auto-generated constructor stub
}
}
