package com.bolion.setting.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolion.setting.bean.AppMessage;
import com.bolion.setting.bean.AppQuestion;
import com.bolion.setting.mapper.SetMapper;

@Service
public class SetServiceImpl implements SetService{
	
	@Autowired
	private SetMapper setMapper;
	
	@Override
	public AppMessage getAppAbout(int clienttype) {
		// TODO Auto-generated method stub
		
		return setMapper.getAppAbout(clienttype);
	}

	@Override
	public int addOpinion(AppQuestion appQuestion) {
		// TODO Auto-generated method stub
		
		return setMapper.addOpinion(appQuestion);
	}

	@Override
	public List<AppQuestion> weQdFlow(Map map) {
		// TODO Auto-generated method stub
		return setMapper.weQdFlow(map);
	}

	@Override
	public AppQuestion weCommonQuesionInfo(int id) {
		// TODO Auto-generated method stub
		return setMapper.weCommonQuesionInfo(id);
	}
	
}
