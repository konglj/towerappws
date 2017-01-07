package com.bolion.common.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolion.common.bean.Score;
import com.bolion.common.mapper.ScoreMapper;
import com.bolion.common.service.ScoreService;
import com.bolion.user.bean.UserChargeInfo;
import com.bolion.user.mapper.UserMapper;

@Service
public class ScoreServiceImpl implements ScoreService {

	@Autowired
	private ScoreMapper scoreMapper;
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	@Transactional
	public int updateUserScore(Score score) {
		//插入积分
		int count=scoreMapper.insertScore(score);
		if(count==0)
			return  0;
		//修改用户积分信息
		UserChargeInfo userChargeInfo=new UserChargeInfo();
		userChargeInfo.setUserid(score.getUserid());
		userChargeInfo.setScore(score.getScorecount());
		count=userMapper.updateUserCharge(userChargeInfo);
		if(count==0)
			throw new RuntimeException();
		return 1;
	}

}
