package com.bolion.order.service;

import java.util.List;
import java.util.Map;

import com.bolion.order.bean.OrderInfo;
import com.bolion.order.bean.OrderPage;
import com.bolion.order.bean.UserOrderInfo;

public interface OrderService {
	
	public Object addOrder(int userid,int towerid);

	public int updateUserOrderInfo(UserOrderInfo userOrderInfo);
	
	public UserOrderInfo getUserOrderInfo(int userid);
	
	public Map  getOrders(OrderPage orderPage);
	
	public OrderInfo getOrderInfo(int orderid);
	
	public List<Map<String,String>> getShOptions(Map<String,Integer> map);
	
	public Object updateOrderTargetAddress(int orderid,String gps,String address);
	
	public  Object abandonOrder(int orderid);
	
	public  Object postOrder(int orderid);
	
	public  Object delayOrder(int orderid,String delayreason);
}
