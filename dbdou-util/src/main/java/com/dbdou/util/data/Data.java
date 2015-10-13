package com.dbdou.util.data;

/**
 * ajax数据类
 * 
 * @author 0000
 */
public class Data {

	private int code;
	private String msg;
	private Object obj;

	public Data() {
	}

	public Data(int code) {
		this.code = code;
	}

	public Data(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public Data(int code, String msg, Object obj) {
		this.code = code;
		this.msg = msg;
		this.obj = obj;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}
}
