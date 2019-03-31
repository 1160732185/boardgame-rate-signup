package bg.pojo;

public class Table {
private String tano;
private String cno;
private int jno;
private int pmax;
private int pnow;
public String getTano() {
	return tano;
}
public void setTano(String tano) {
	this.tano = tano;
}
public String getCno() {
	return cno;
}
public void setCno(String cno) {
	this.cno = cno;
}
public int getJno() {
	return jno;
}
public void setJno(int jno) {
	this.jno = jno;
}
public int getPmax() {
	return pmax;
}
public void setPmax(int pmax) {
	this.pmax = pmax;
}
public int getPnow() {
	return pnow;
}
public void setPnow(int pnow) {
	this.pnow = pnow;
}
public Table(String tano, String cno, int jno, int pmax, int pnow) {
	super();
	this.tano = tano;
	this.cno = cno;
	this.jno = jno;
	this.pmax = pmax;
	this.pnow = pnow;
}
public Table() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Table [tano=" + tano + ", cno=" + cno + ", jno=" + jno + ", pmax="
			+ pmax + ", pmin=" + pnow + "]";
}
}
