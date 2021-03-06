package com.bolion.tower.bean;

import com.bolion.common.Config;

public class TowerInfo {

	 private String towername="";
	 private String toweraddress="";
	 private int isfavourite;
	 private String towertypeimg="";
	 private int towerfee;
	 private String towercity="";
	 private String towerdistrict="";
	
	 private String towerarea="";
	 private String towersection="";
	 private String towergpsx="";
	 private String towergpsy="";
	 private String towerfirstgpsx="";
	 private String towerfirstgpsy="";
	 private String towersecondgpsx="";
	 private String towersecondgpsy="";
	 private int towerlarge;
	 private String towertype="";
	 private String towerinfo="";
	 private String towerremark="";
	 private String towermanager="";
	 private String towermanagername="";
	 private String towermanagerchat="";
	public String getTowername() {
		return towername;
	}
	public void setTowername(String towername) {
		this.towername = towername;
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
	public int getTowerfee() {
		return towerfee;
	}
	public void setTowerfee(int towerfee) {
		this.towerfee = towerfee;
	}
	public String getTowercity() {
		return towercity;
	}
	public void setTowercity(String towercity) {
		this.towercity = towercity;
	}
	public String getTowerdistrict() {
		return towerdistrict;
	}
	public void setTowerdistrict(String towerdistrict) {
		this.towerdistrict = towerdistrict;
	}
	public String getTowerarea() {
		return towerarea;
	}
	public void setTowerarea(String towerarea) {
		this.towerarea = towerarea;
	}
	
	public String getTowersection() {
		return towersection;
	}
	public void setTowersection(String towersection) {
		this.towersection = towersection;
	}
	public String getTowergpsx() {
		return towergpsx;
	}
	public void setTowergpsx(String towergpsx) {
		this.towergpsx = towergpsx;
	}
	public String getTowergpsy() {
		return towergpsy;
	}
	public void setTowergpsy(String towergpsy) {
		this.towergpsy = towergpsy;
	}
	public String getTowerfirstgpsx() {
		return towerfirstgpsx;
	}
	public void setTowerfirstgpsx(String towerfirstgpsx) {
		this.towerfirstgpsx = towerfirstgpsx;
	}
	public String getTowerfirstgpsy() {
		return towerfirstgpsy;
	}
	public void setTowerfirstgpsy(String towerfirstgpsy) {
		this.towerfirstgpsy = towerfirstgpsy;
	}
	public String getTowersecondgpsx() {
		return towersecondgpsx;
	}
	public void setTowersecondgpsx(String towersecondgpsx) {
		this.towersecondgpsx = towersecondgpsx;
	}
	public String getTowersecondgpsy() {
		return towersecondgpsy;
	}
	public void setTowersecondgpsy(String towersecondgpsy) {
		this.towersecondgpsy = towersecondgpsy;
	}
	public int getTowerlarge() {
		return towerlarge;
	}
	public void setTowerlarge(int towerlarge) {
		this.towerlarge = towerlarge;
	}
	public String getTowertype() {
		return towertype;
	}
	public void setTowertype(String towertype) {
		this.towertype = towertype;
	}
	public String getTowerinfo() {
		return towerinfo;
	}
	public void setTowerinfo(String towerinfo) {
		this.towerinfo = towerinfo;
	}
	public String getTowerremark() {
		if(towerremark==null||towerremark=="")
			return "";
		return Config.getWspath()+Config.getFilerootname()+towerremark;
	}
	public void setTowerremark(String towerremark) {
		this.towerremark = towerremark;
	}
	public String getTowermanager() {
		return towermanager;
	}
	public void setTowermanager(String towermanager) {
		this.towermanager = towermanager;
	}
	public String getTowermanagername() {
		return towermanagername;
	}
	public void setTowermanagername(String towermanagername) {
		this.towermanagername = towermanagername;
	}
	public String getTowermanagerchat() {
		return towermanagerchat;
	}
	public void setTowermanagerchat(String towermanagerchat) {
		this.towermanagerchat = towermanagerchat;
	}
	
	

	 
	

}
