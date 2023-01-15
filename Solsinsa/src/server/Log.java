package server;

import java.io.Serializable;

public class Log implements Serializable {

	private static final long serialVersionUID = 456789654L;

	private String date;
	private String msg;
	private int code;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

}
