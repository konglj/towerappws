package com.bolion.money.bean;

public class TxRecordTower {
	private int towerid;
	private int orderid;
	private String towername;
	private int towerfee;
	private String towerimg; 
	private int feetype;
	private String adddate;
	private String completedate;
	
	public int getTowerid() {
		return towerid;
	}
	public void setTowerid(int towerid) {
		this.towerid = towerid;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public String getTowername() {
		return towername;
	}
	public void setTowername(String towername) {
		this.towername = towername;
	}
	public int getTowerfee() {
		return towerfee;
	}
	public void setTowerfee(int towerfee) {
		this.towerfee = towerfee;
	}
	public String getTowerimg() {
		return towerimg;
	}
	public void setTowerimg(String towerimg) {
		this.towerimg = towerimg;
	}
	public int getFeetype() {
		return feetype;
	}
	public void setFeetype(int feetype) {
		this.feetype = feetype;
	}
	public String getAdddate() {
		return adddate;
	}
	public void setAdddate(String adddate) {
		this.adddate = adddate;
	}
	public String getCompletedate() {
		return completedate;
	}
	public void setCompletedate(String completedate) {
		this.completedate = completedate;
	}
}
