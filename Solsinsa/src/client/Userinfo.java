package client;

public class Userinfo {
	String id;
	String pw;
	String name;
	String birth;
	String addr;
	String phone;
	String mail;
	
	
	private Userinfo(String id, String pw, String name, String birth, String addr, String phone, String mail) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.birth = birth;
		this.addr = addr;
		this.phone = phone;
		this.mail = mail;
	}

	private static Userinfo instance = null;

	public static Userinfo getUserInfo(String id, String pw, String name, String birth, String addr, String phone, String mail) {
		if (instance == null)
			instance = new Userinfo(id, pw, name, birth, addr, phone, mail);

		return instance;
	}
	
	public void Logout() {
		instance = null;
	}

}
