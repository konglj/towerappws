package com.bolion.index.bean;

import java.util.ArrayList;
import java.util.List;

import com.bolion.tower.bean.TowerIndex;

public class IndexInfo {
	
	private int  cityid;
	
	private String cityname="";
	
	private List<Banner> banners=new ArrayList<Banner>();
	
	private List<TowerIndex> offers=new ArrayList<TowerIndex>();

	public int getCityid() {
		return cityid;
	}

	public void setCityid(int cityid) {
		this.cityid = cityid;
	}

	public String getCityname() {
		return cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}

	public List<Banner> getBanners() {
		return banners;
	}

	public void setBanners(List<Banner> banners) {
		this.banners = banners;
	}

	public List<TowerIndex> getOffers() {
		return offers;
	}

	public void setOffers(List<TowerIndex> offers) {
		this.offers = offers;
	}
	
	
	
	
	
	
	
	

}
