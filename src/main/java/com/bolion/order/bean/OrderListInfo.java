package com.bolion.order.bean;

import java.util.ArrayList;
import java.util.List;

import com.bolion.common.Config;

public class OrderListInfo {

	private int orderid;
	private int towerid;
	private String towername;
	private String towertypeimg;
	private int towerfee;
	private String orderaddtime;
	private String orderabandontime;
	private String ordercompletetime;
	private long ordersytime;
	private int orderstate;
	private int towercity;
	
	private List<OrderTime> ordertimes=new ArrayList<OrderTime>();
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
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
	public String getTowertypeimg() {
		if(orderstate==1||orderstate==13){
			if(towertypeimg!=null){
				 return Config.getWspath()+Config.getFilerootname()+ towertypeimg.substring(0,towertypeimg.length()-4)+"1.png";
			}
				
		}
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
	public String getOrderaddtime() {
		return orderaddtime;
	}
	public void setOrderaddtime(String orderaddtime) {
		this.orderaddtime = orderaddtime;
	}
	public String getOrderabandontime() {
		return orderabandontime;
	}
	public void setOrderabandontime(String orderabandontime) {
		this.orderabandontime = orderabandontime;
	}
	public String getOrdercompletetime() {
		return ordercompletetime;
	}
	public void setOrdercompletetime(String ordercompletetime) {
		this.ordercompletetime = ordercompletetime;
	}
	public long getOrdersytime() {
		return ordersytime;
	}
	public void setOrdersytime(long ordersytime) {
		this.ordersytime = ordersytime;
	}
	public int getOrderstate() {
		return orderstate;
	}
	public void setOrderstate(int orderstate) {
		this.orderstate = orderstate;
	}
	public int getTowercity() {
		return towercity;
	}
	public void setTowercity(int towercity) {
		this.towercity = towercity;
	}
	public List<OrderTime> getOrdertimes() {
		return ordertimes;
	}
	public void setOrdertimes(List<OrderTime> ordertimes) {
		this.ordertimes = ordertimes;
	}
	
	
	
	

}
