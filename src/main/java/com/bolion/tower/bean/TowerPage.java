package com.bolion.tower.bean;

import com.bolion.common.TowerConfig;

public class TowerPage {
	

	private int towercity;
	
	private int towerarea;
	
	private int towerdistrict;
	
	private int sort;
	
	private int towerpoint; 
	
	private String towername;
	
	private int towerstyle;
	
	private int userid;
	
	private int userlevel;
	
	private int pageindex=1;
	
	private int pagesize=TowerConfig.tower_list_page_size;

	private int []towerlevel;
	
	
	

	public int getTowercity() {
		return towercity;
	}

	public void setTowercity(int towercity) {
		this.towercity = towercity;
	}

	public int getTowerarea() {
		return towerarea;
	}

	public void setTowerarea(int towerarea) {
		this.towerarea = towerarea;
	}

	public int getTowerdistrict() {
		return towerdistrict;
	}

	public void setTowerdistrict(int towerdistrict) {
		this.towerdistrict = towerdistrict;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}


	public int getTowerpoint() {
		return towerpoint;
	}

	public void setTowerpoint(int towerpoint) {
		this.towerpoint = towerpoint;
	}

	public String getTowername() {
		return towername;
	}

	public void setTowername(String towername) {
		this.towername = towername;
	}

	public int getPageindex() {
		return pageindex;
	}

	public void setPageindex(int pageindex) {
		this.pageindex = pageindex;
	}

	public int[] getTowerlevel() {
		return towerlevel;
	}

	public void setTowerlevel(int[] towerlevel) {
		this.towerlevel = towerlevel;
	}

	public int getTowerstyle() {
		return towerstyle;
	}

	public void setTowerstyle(int towerstyle) {
		this.towerstyle = towerstyle;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getUserlevel() {
		return userlevel;
	}

	public void setUserlevel(int userlevel) {
		this.userlevel = userlevel;
	}
	
	
	
	
	
	
}
