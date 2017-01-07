package com.bolion.money.bean;

public class TxSource {
	
	private int id;
	
	private int orderid;
	
	private int userid;
	
	private String wxid;
	
	private int fee;
	
	private int feetype;
	
	private String paytime;
	
	private int txid;
	
	private String towername;

	private String towertypeimg;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public String getWxid() {
		return wxid;
	}

	public void setWxid(String wxid) {
		this.wxid = wxid;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	public int getFeetype() {
		return feetype;
	}

	public void setFeetype(int feetype) {
		this.feetype = feetype;
	}

	public String getPaytime() {
		return paytime;
	}

	public void setPaytime(String paytime) {
		this.paytime = paytime;
	}

	public int getTxid() {
		return txid;
	}

	public void setTxid(int txid) {
		this.txid = txid;
	}

	public String getTowername() {
		return towername;
	}

	public void setTowername(String towername) {
		this.towername = towername;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getTowertypeimg() {
		return towertypeimg;
	}

	public void setTowertypeimg(String towertypeimg) {
		this.towertypeimg = towertypeimg;
	}
}
