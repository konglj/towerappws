package com.bolion.login.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolion.login.bean.ValidateCode;
import com.bolion.login.common.StrUtil;
import com.bolion.login.mapper.RegistMapper;
import com.bolion.login.service.RegistService;
import com.bolion.order.bean.UserOrderInfo;
import com.bolion.order.mapper.OrderMapper;
import com.bolion.user.bean.UserChargeInfo;
import com.bolion.user.mapper.UserMapper;

@Service
public class RegistServiceImpl implements RegistService {

	@Autowired
	private RegistMapper registMapper;

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private OrderMapper orderMapper;
	
	@Override
	public int updateValidateCode(Map map) {
		// 判断是否存在

		int count = registMapper.getValidateCodeCount(map);
		if (count > 0) {
			count = registMapper.updateValidateCode(map);
		} else {
			count = registMapper.insertValidateCode(map);
		}
		return count;
	}

	@Override
	@Transactional
	public ValidateCode getValidateInfo(String phone) {
		return registMapper.getValidateInfo(phone);
	}

	@Override
	public int updateValidateCodeCount(String tel) {
		return registMapper.updateValidateCodeCount(tel);
	}

	@Override
	@Transactional
	public Map login(String phone) {
		// 验证是否已经注册过，防止重复注册
		int count = 0;
		Map map = userMapper.getUseridByPhone(phone);
		Map mapResult = new HashMap();
		if (null == map) {
			// 未注册 插入
			Map mapUser = new HashMap();
			mapUser.put("usertele", phone);
			count = userMapper.insertUser(mapUser);
			if (count == 0) {
				mapResult.put("userid", 0);
				mapResult.put("errmsg", StrUtil.regist_error);
				mapResult.put("state", 1);
				mapResult.put("logintype", 2);
			} else {
				mapResult.put("userid", mapUser.get("id"));
				mapResult.put("errmsg", "");
				mapResult.put("state", 1);
				mapResult.put("logintype", 2);
				// 插入用户订单表
				UserOrderInfo orderInfo = new UserOrderInfo();
				orderInfo.setUserid(Integer.valueOf(mapUser.get("id")
						.toString()));
				count = orderMapper.insertUserOrderInfo(orderInfo);
				if (count == 0)
					throw new RuntimeException();
				//插入用户积分
				UserChargeInfo userChargeInfo=new UserChargeInfo();
				userChargeInfo.setUserid(Integer.valueOf(mapUser.get("id")
						.toString()));
				count = userMapper.insertUserCharge(userChargeInfo);
				if (count == 0)
					throw new RuntimeException();
			}
		} else {
			// 已注册 登录
			mapResult.put("userid", map.get("userid"));
			mapResult.put("errmsg", StrUtil.login_success);
			mapResult.put("state",map.get("userstate"));
			mapResult.put("logintype", 1);
		}
		// 修改验证码使用状态
		count = registMapper.updateValidateCodeState(phone);
		if (count == 0)
			throw new RuntimeException();
		return mapResult;
	}

}
