package bg.pojo;

public class Game {
private String gno;
private String gname;
private float grate; 
private int difficulty; 
private String dno;
private String tno;
private int sales;
public String getGno() {
	return gno;
}
public void setGno(String gno) {
	this.gno = gno;
}
public String getGname() {
	return gname;
}
public void setGname(String gname) {
	this.gname = gname;
}
public float getGrate() {
	return grate;
}
public void setRate(float rate) {
	this.grate = rate;
}
public int getDifficulty() {
	return difficulty;
}
public void setDifficulty(int difficulty) {
	this.difficulty = difficulty;
}
public String getDno() {
	return dno;
}
public void setDno(String dno) {
	this.dno = dno;
}
public String getTno() {
	return tno;
}
public void setTno(String tno) {
	this.tno = tno;
}
public int getSales() {
	return sales;
}
public void setSales(int sales) {
	this.sales = sales;
}
public Game() {
	super();
	// TODO Auto-generated constructor stub
}
public Game(String gno, String gname, float grate, int difficulty, String dno,
		String tno, int sales) {
	super();
	this.gno = gno;
	this.gname = gname;
	this.grate = grate;
	this.difficulty = difficulty;
	this.dno = dno;
	this.tno = tno;
	this.sales = sales;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + difficulty;
	result = prime * result + ((dno == null) ? 0 : dno.hashCode());
	result = prime * result + ((gname == null) ? 0 : gname.hashCode());
	result = prime * result + ((gno == null) ? 0 : gno.hashCode());
	result = prime * result + Float.floatToIntBits(grate);
	result = prime * result + sales;
	result = prime * result + ((tno == null) ? 0 : tno.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Game other = (Game) obj;
	if (difficulty != other.difficulty)
		return false;
	if (dno == null) {
		if (other.dno != null)
			return false;
	} else if (!dno.equals(other.dno))
		return false;
	if (gname == null) {
		if (other.gname != null)
			return false;
	} else if (!gname.equals(other.gname))
		return false;
	if (gno == null) {
		if (other.gno != null)
			return false;
	} else if (!gno.equals(other.gno))
		return false;
	if (Float.floatToIntBits(grate) != Float.floatToIntBits(other.grate))
		return false;
	if (sales != other.sales)
		return false;
	if (tno == null) {
		if (other.tno != null)
			return false;
	} else if (!tno.equals(other.tno))
		return false;
	return true;
}
@Override
public String toString() {
	return "Game [gno=" + gno + ", gname=" + gname + ", grate=" + grate
			+ ", difficulty=" + difficulty + ", dno=" + dno + ", tno=" + tno
			+ ", sales=" + sales + "]";
}

}
