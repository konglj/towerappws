package com.bolion.login.service;

import java.util.Map;

import com.bolion.login.bean.ValidateCode;

public interface RegistService {
	
	
	public int updateValidateCode(Map map);
	
	
	public ValidateCode getValidateInfo(String phone);
	
	public int updateValidateCodeCount(String tel);
	
	public Map  login(String phone);
    
    

}
