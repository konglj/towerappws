package com.bolion.user.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolion.login.mapper.RegistMapper;
import com.bolion.user.bean.User;
import com.bolion.user.bean.UserChargeInfo;
import com.bolion.user.bean.UserIndex;
import com.bolion.user.bean.UserInfo;
import com.bolion.user.mapper.UserMapper;
import com.bolion.user.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private RegistMapper registMapper;
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public Map getUseridByPhone(String phone) {
		return userMapper.getUseridByPhone(phone);
	}

	@Override
	public int insertUser(Map map) {
		return userMapper.insertUser(map);
	}

	@Override
	@Transactional
	public int updateUserInfo(User user) {
		int count=0;
		if(user.getUsertele()!=null&&!user.getUsertele().equals("")){
		 count=registMapper.updateValidateCodeState(user.getUsertele());
		 if(count ==0)
			return 0 ;
		}
		count=userMapper.updateUserInfo(user);
		if(count ==0)
			throw new RuntimeException();
		return 1;
	}
	
	@Override
	public int updateUserHeadImg(User user) {
		return userMapper.updateUserHeadImg(user);
	}

	@Override
	public int updateUserTeamImg(User user) {
		return userMapper.updateUserTeamImg(user);
	}

	@Override
	public UserIndex getUserIndexInfo(int userid) {
		return userMapper.getUserIndexInfo(userid);
	}

	@Override
	public UserInfo getUserInfo(int userid) {
		return userMapper.getUserInfo(userid);
	}

	@Override
	public int getUserLevel(int userid) {
		Map map=userMapper.getUserLevel(userid);
		if(map==null || map.get("userlevel")==null)
			return  0;
		return Integer.valueOf(map.get("userlevel").toString());
	}

	@Override
	public int updateUserCharge(UserChargeInfo chargeInfo) {
		return 0;
	}

	
	

}
