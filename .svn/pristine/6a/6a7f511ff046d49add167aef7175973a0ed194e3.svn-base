package com.bolion.user.mapper;

import java.util.Map;

import com.bolion.order.bean.UserOrderInfo;
import com.bolion.user.bean.User;
import com.bolion.user.bean.UserBaseInfo;
import com.bolion.user.bean.UserChargeInfo;
import com.bolion.user.bean.UserIndex;
import com.bolion.user.bean.UserInfo;



public interface UserMapper {
	
	public Map getUseridByPhone(String phone);
	
	public int insertUser(Map map);
	
	public int updateUserInfo(User user);
	
	public int updateUserHeadImg(User user);
	
	public int updateUserTeamImg(User user);
	
	public UserIndex getUserIndexInfo(int userid);
	
	public UserInfo getUserInfo(int userid);
	
	/**
	 * 修改用户费用
	 * @param userOrderInfo
	 * @return
	 */
	public int updateUserCharge(UserChargeInfo userOrderInfo);
	
	/**
	 * 插入用户费用
	 * @param chargeInfo
	 * @return
	 */
	public int insertUserCharge(UserChargeInfo chargeInfo);
	
	/**
	 * 获取用户费用
	 * @param userid
	 * @return
	 */
	public int getUserCharge(int userid);
	
	
	public Map getUserLevel(int userid);
	
	public UserBaseInfo getUserBaseInfo(int userid);
	
	public int updateUserState(Map<String,Object> map);
}
