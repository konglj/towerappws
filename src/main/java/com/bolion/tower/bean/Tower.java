package com.bolion.tower.bean;

import com.bolion.common.Config;

public class Tower {

	private int towerid;
	
	private String towername="";
	
	private int towerfee;
	
	private String  toweraddress="";
	
	private int isfavourite;
	
	private String towertypeimg="";
	
	private String towercity="";
	
	private String towerdistrict="";
	
	private String towerarea="";
	
	private String towersection="";//区域  济南市高新区  或   黄浦区**街道

	public int getTowerid() {
		return towerid;
	}

	public void setTowerid(int towerid) {
		this.towerid = towerid;
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

	public String getToweraddress() {
		return toweraddress;
	}

	public void setToweraddress(String toweraddress) {
		this.toweraddress = toweraddress;
	}

	public int getIsfavourite() {
		return isfavourite;
	}

	public void setIsfavourite(int isfavourite) {
		this.isfavourite = isfavourite;
	}

	public String getTowertypeimg() {
		return Config.getWspath()+Config.getFilerootname()+ towertypeimg;
	}

	public void setTowertypeimg(String towertypeimg) {
		this.towertypeimg = towertypeimg;
	}

	public String getTowercity() {
		return towercity;
	}

	public void setTowercity(String towercity) {
		this.towercity = towercity;
	}

	public String getTowerarea() {
		return towerarea;
	}

	public void setTowerarea(String towerarea) {
		this.towerarea = towerarea;
	}

	public String getTowerdistrict() {
		return towerdistrict;
	}

	public void setTowerdistrict(String towerdistrict) {
		this.towerdistrict = towerdistrict;
	}

	public String getTowersection() {
		return towersection;
	}

	public void setTowersection(String towersection) {
		this.towersection = towersection;
	}

	
	
	
	

	
}
