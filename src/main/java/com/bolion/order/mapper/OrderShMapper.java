package com.bolion.order.mapper;

import java.util.List;
import java.util.Map;

import com.bolion.order.bean.OrderShInfo;

public interface OrderShMapper {
	
	public int insertOrderShInfo(OrderShInfo orderShInfo);

	public List<Map<String,String>> getShOptions(Map<String,Integer> map);
}
