package bg.pojo;

public class Judger {
	private int jno;
	private String jid;
	private String jpassword;
	private String jname;
	private String jmobile;
	public int getJno() {
		return jno;
	}
	public void setJno(int jno) {
		this.jno = jno;
	}
	public String getJid() {
		return jid;
	}
	public void setJid(String jid) {
		this.jid = jid;
	}
	public String getJpassword() {
		return jpassword;
	}
	public void setJpassword(String jpassword) {
		this.jpassword = jpassword;
	}
	public String getJname() {
		return jname;
	}
	public void setJname(String jname) {
		this.jname = jname;
	}
	public String getJmobile() {
		return jmobile;
	}
	public void setJmobile(String jmobile) {
		this.jmobile = jmobile;
	}
	public Judger() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Judger(int jno, String jid, String jpassword, String jname,
			String jmobile) {
		super();
		this.jno = jno;
		this.jid = jid;
		this.jpassword = jpassword;
		this.jname = jname;
		this.jmobile = jmobile;
	}
}
