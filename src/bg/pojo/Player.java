package bg.pojo;

public class Player {
	private int pno;
	private String pid;
	private String password;
	private String realname;
	private String mobile;
	private int balance;
	public Player() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + balance;
	result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
	result = prime * result + ((password == null) ? 0 : password.hashCode());
	result = prime * result + ((pid == null) ? 0 : pid.hashCode());
	result = prime * result + pno;
	result = prime * result + ((realname == null) ? 0 : realname.hashCode());
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
	Player other = (Player) obj;
	if (balance != other.balance)
		return false;
	if (mobile == null) {
		if (other.mobile != null)
			return false;
	} else if (!mobile.equals(other.mobile))
		return false;
	if (password == null) {
		if (other.password != null)
			return false;
	} else if (!password.equals(other.password))
		return false;
	if (pid == null) {
		if (other.pid != null)
			return false;
	} else if (!pid.equals(other.pid))
		return false;
	if (pno != other.pno)
		return false;
	if (realname == null) {
		if (other.realname != null)
			return false;
	} else if (!realname.equals(other.realname))
		return false;
	return true;
}
@Override
public String toString() {
	return "Player [pno=" + pno + ", pid=" + pid + ", password=" + password
			+ ", realname=" + realname + ", mobile=" + mobile + ", balance="
			+ balance + "]";
}
public Player(int pno, String pid, String password, String realname,
		String mobile, int balance) {
	super();
	this.pno = pno;
	this.pid = pid;
	this.password = password;
	this.realname = realname;
	this.mobile = mobile;
	this.balance = balance;
}
}
