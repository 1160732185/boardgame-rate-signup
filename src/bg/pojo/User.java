package bg.pojo;

public class User {
private int userid;
private String username;
private String password;
private String identitycard;
private int roleid;
public int getUserid() {
	return userid;
}
public void setUserid(int userid) {
	this.userid = userid;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getIdentitycard() {
	return identitycard;
}
public void setIdentitycard(String identitycard) {
	this.identitycard = identitycard;
}
public int getRoleid() {
	return roleid;
}
public void setRoleid(int roleid) {
	this.roleid = roleid;
}
@Override
public String toString() {
	return "User [userid=" + userid + ", username=" + username + ", password="
			+ password + ", identitycard=" + identitycard + ", roleid="
			+ roleid + "]";
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result
			+ ((identitycard == null) ? 0 : identitycard.hashCode());
	result = prime * result + ((password == null) ? 0 : password.hashCode());
	result = prime * result + roleid;
	result = prime * result + userid;
	result = prime * result + ((username == null) ? 0 : username.hashCode());
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
	User other = (User) obj;
	if (identitycard == null) {
		if (other.identitycard != null)
			return false;
	} else if (!identitycard.equals(other.identitycard))
		return false;
	if (password == null) {
		if (other.password != null)
			return false;
	} else if (!password.equals(other.password))
		return false;
	if (roleid != other.roleid)
		return false;
	if (userid != other.userid)
		return false;
	if (username == null) {
		if (other.username != null)
			return false;
	} else if (!username.equals(other.username))
		return false;
	return true;
}
public User() {
	super();
	// TODO Auto-generated constructor stub
}
public User(int userid, String username, String password, String identitycard,
		int roleid) {
	super();
	this.userid = userid;
	this.username = username;
	this.password = password;
	this.identitycard = identitycard;
	this.roleid = roleid;
}





}
