package com.bolion.tower.bean;

import com.bolion.common.Config;

public class TowerIndex {
	 
    private int towerid;
	
	private String towername="";
	
	private int towerfee;
	
	private String  toweraddress="";
	
	private String towertypeimg="";
	
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

	public String getTowertypeimg() {
		return Config.getWspath()+Config.getFilerootname()+ towertypeimg;
	}

	public void setTowertypeimg(String towertypeimg) {
		this.towertypeimg = towertypeimg;
	}

	public String getTowersection() {
		return towersection;
	}

	public void setTowersection(String towersection) {
		this.towersection = towersection;
	}
	
	

}
