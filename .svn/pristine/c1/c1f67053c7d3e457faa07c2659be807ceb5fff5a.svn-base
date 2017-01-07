package com.bolion.setting.common;
/**
 * 
 * @author sujw 封装返回的结果集
 *
 */

public class MsgResult {
	private int status;
	private Object data;

	public MsgResult() {

	}

	public MsgResult(int status, Object obj) {
		this.status = status;
		
		if (obj == null) {
			this.data = new String("[]");
		} else if (obj.equals("")) {
			this.data = "[]";
		} else {
			this.data = obj;
		}
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
