package com.bolion.order.mapper;

import java.util.List;
import java.util.Map;

import com.bolion.login.bean.ValidateCode;
import com.bolion.order.bean.AddOrder;
import com.bolion.order.bean.OrderBaseInfo;
import com.bolion.order.bean.OrderInfo;
import com.bolion.order.bean.OrderListInfo;
import com.bolion.order.bean.OrderPage;
import com.bolion.order.bean.UserOrderInfo;


public interface OrderMapper {


	//用户订单统计
	public int insertUserOrderInfo(UserOrderInfo userOrderInfo);

    public int updateUserOrder(UserOrderInfo userOrderInfo);
	
	public int checkUserOrder(int userid);
	
	public UserOrderInfo getUserOrderInfo(Map map);
	
	public int insertOrder(AddOrder order);
	
	public List<OrderListInfo>  getOrders(OrderPage orderPage);
	
	public int  getOrderPageCount(OrderPage orderPage);
	
	public OrderInfo getOrderInfo(int orderid);
	
	public OrderBaseInfo getOrderBaseInfo(int orderid);
	
	//取消订单
	public int abandonOrder(Map<String,Object> map);
	
	//延期
	public int delayOrder(Map<String,Object> map);
	//交单
	public int postOrder(Map<String,Object> map);
	//目标建站地址
	public int updateTargetAddress(Map<String,Object> map);
	
}
