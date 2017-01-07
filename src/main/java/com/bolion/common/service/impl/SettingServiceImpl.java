package com.bolion.common.service.impl;

import javax.xml.ws.soap.Addressing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolion.common.mapper.SettingMapper;
import com.bolion.common.service.SettingService;


@Service
public class SettingServiceImpl implements SettingService {

	@Autowired
	private SettingMapper settingMapper;
	

	@Override
	public String getSettingContent(String name) {
		return settingMapper.getSettingContent(name);
	}

}
