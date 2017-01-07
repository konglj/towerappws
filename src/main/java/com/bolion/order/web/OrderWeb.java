package com.bolion.order.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bolion.common.TowerConfig;
import com.bolion.common.TowerScore;
import com.bolion.common.util.DataValidation;
import com.bolion.common.util.ResultUtil;
import com.bolion.order.bean.OrderListInfo;
import com.bolion.order.bean.OrderPage;
import com.bolion.order.bean.UserOrderInfo;
import com.bolion.order.common.util.StrUtil;
import com.bolion.order.service.OrderService;
import com.bolion.tower.bean.TowerBaseInfo;
import com.bolion.tower.service.TowerService;

@Controller
@RequestMapping("/order")
public class OrderWeb {
	
	@Autowired
	private TowerService towerService;
	
	@Autowired
	private OrderService orderService;
	
	
	@RequestMapping("/weAddOrder")
	@ResponseBody
	public Object addOrder(Integer userid,Integer towerid){
		if(userid == null || towerid == null || userid == 0 || towerid == 0 )
			return ResultUtil.generateResponseMsg(StrUtil.order_parmar_error);
		Object object=null;
		try {
			object=orderService.addOrder(userid, towerid);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return ResultUtil.generateResponseMsg(StrUtil.order_add_error);
		}
	 	return object;
	}
	@RequestMapping("/weGetOrders")
	@ResponseBody
	public Object getOrders(OrderPage orderPage){
		if(orderPage==null)
			orderPage=new OrderPage();
		return orderService.getOrders(orderPage);
	}

	@RequestMapping("/weGetOrderInfo")
	@ResponseBody
	public Object getOrderInfo(Integer orderid){
		if(orderid==null || orderid == 0)
			return null;
		
		return orderService.getOrderInfo(orderid);
	}
	
	@RequestMapping("/weGetOrderOptions")
	@ResponseBody
	public Object getOrderShOptions(Integer orderid){
		if(orderid == null)
			orderid=0;
		Map<String,Integer> map=new HashMap<String,Integer>();
		map.put("orderid", orderid);
		map.put("topcount",0);
		return orderService.getShOptions(map);
	}
	
	@RequestMapping("/weTargetaddressOrder")
	@ResponseBody
	public Object updateTargetAddress(HttpServletRequest request, Integer orderid,
			String address,String gps) {
		  if(orderid ==null || orderid==0 ||DataValidation.isNullOrEmpty(address)||DataValidation.isNullOrEmpty(gps))
			  return ResultUtil.generateResponseMsg(StrUtil.order_parmar_error);
		  Object obj=null;
		  try {
			  obj= orderService.updateOrderTargetAddress(orderid, gps, address);
		} catch (Exception e) {
			
		}
		  if(obj==null)
			  return ResultUtil.generateResponseMsg(StrUtil.order_target_address_error);
		  return obj;
	}

	@RequestMapping("/weAbandonOrder")
	@ResponseBody
	public Object updateAbandonOrder(HttpServletRequest request, Integer orderid) {
		  if(orderid ==null || orderid==0 )
			  return ResultUtil.generateResponseMsg(StrUtil.order_parmar_error);
		  Object obj=null;
		  try {
			  obj= orderService.abandonOrder(orderid);
		} catch (Exception e) {
			
		}
		  if(obj==null)
			  return ResultUtil.generateResponseMsg(StrUtil.order_abandon_error);
		  return obj;
	}
	
	@RequestMapping("/wePostOrder")
	@ResponseBody
	public Object updatePosterOrder(HttpServletRequest request, Integer orderid) {
		  if(orderid ==null || orderid==0 )
			  return ResultUtil.generateResponseMsg(StrUtil.order_parmar_error);
		  Object obj=null;
		  try {
			  obj= orderService.postOrder(orderid);
		} catch (Exception e) {
			
		}
		  if(obj==null)
			  return ResultUtil.generateResponseMsg(StrUtil.order_post_error);
		  return obj;
	}
	
	@RequestMapping("/weDelayOrder")
	@ResponseBody
	public Object updatePosterOrder(HttpServletRequest request, Integer orderid,String delayreason) {
		  if(orderid ==null || orderid==0 || DataValidation.isNullOrEmpty(delayreason) )
			  return ResultUtil.generateResponseMsg(StrUtil.order_parmar_error);
		  Object obj=null;
		  try {
			  obj= orderService.delayOrder(orderid, delayreason);
		} catch (Exception e) {
			
		}
		  if(obj==null)
			  return ResultUtil.generateResponseMsg(StrUtil.order_dealy_error);
		  return obj;
	}
	
	
	
	
	
	
	

	
}
