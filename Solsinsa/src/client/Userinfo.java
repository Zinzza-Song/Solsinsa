package client;

public class Userinfo {
	int no;
	private String id;
	private String pw;
	private String name;
	private String birth;
	private String addr;
	private String phone;
	private String mail;
	
	private Userinfo(){}
	
	public void setUserinfo(int no, String id, String pw, String name, String birth, String addr, String phone, String mail) {
		this.no = no;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.birth = birth;
		this.addr = addr;
		this.phone = phone;
		this.mail = mail;
	}

	private static Userinfo instance = null;

	public static Userinfo getUserInfo() {
		if (instance == null)
			instance = new Userinfo();

		return instance;
	}
	
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public void Logout() {
		instance = null;
	}

}
