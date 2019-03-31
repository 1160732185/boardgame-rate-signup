package bg.pojo;

public class Scoring {
private int pno;
private String tano;
public int getPno() {
	return pno;
}
public void setPno(int pno) {
	this.pno = pno;
}
public String getTano() {
	return tano;
}
public void setTano(String tano) {
	this.tano = tano;
}
public Scoring(int pno, String tano) {
	super();
	this.pno = pno;
	this.tano = tano;
}
public Scoring() {
	super();
	// TODO Auto-generated constructor stub
}
}
