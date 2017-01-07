package com.bolion.setting.service.impl;

import java.util.List;
import java.util.Map;

import com.bolion.setting.bean.AppMessage;
import com.bolion.setting.bean.AppQuestion;

public interface SetService {
	
	public AppMessage getAppAbout(int clienttype);
	
	public int addOpinion(AppQuestion appQuestion);
	
	public List<AppQuestion> weQdFlow(Map map);
	
	public AppQuestion weCommonQuesionInfo(int id);
	
}
