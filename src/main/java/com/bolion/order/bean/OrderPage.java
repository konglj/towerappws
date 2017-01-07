package com.bolion.order.bean;

import com.bolion.common.TowerConfig;

public class OrderPage {
	
	private int towercity;
	
	private int towerdistrict;
	
	private int towerarea;
	
	private int sort;
	
	private String towername;
	
	private int userid;
	
	private int pageindex=1;
	
	private int pagesize=TowerConfig.order_list_page_size;
	
	private int orderstate=-1;

	

	public int getTowercity() {
		return towercity;
	}

	public void setTowercity(int towercity) {
		this.towercity = towercity;
	}

	public int getTowerdistrict() {
		return towerdistrict;
	}

	public void setTowerdistrict(int towerdistrict) {
		this.towerdistrict = towerdistrict;
	}

	public int getTowerarea() {
		return towerarea;
	}

	public void setTowerarea(int towerarea) {
		this.towerarea = towerarea;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
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

	public int getPageindex() {
		return pageindex;
	}

	public void setPageindex(int pageindex) {
		this.pageindex = pageindex;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public int getOrderstate() {
		return orderstate;
	}

	public void setOrderstate(int orderstate) {
		this.orderstate = orderstate;
	}

	
	
	

}
