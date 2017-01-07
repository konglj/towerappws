package com.bolion.user.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bolion.common.TowerConfig;
import com.bolion.common.util.FileUpload;
import com.bolion.common.util.ImageUtil;
import com.bolion.common.util.HttpRequestUtil;
import com.bolion.login.bean.ValidateCode;
import com.bolion.login.service.RegistService;
import com.bolion.user.bean.User;
import com.bolion.user.bean.UserInfo;
import com.bolion.user.common.util.StrUtil;
import com.bolion.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserWS {
	
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RegistService registService;
	
	@RequestMapping("/weGetUserIndexInfo")
	@ResponseBody
	public Object getUserIndexInfo(int userid){
		return userService.getUserIndexInfo(userid);
	}
	
	
	@RequestMapping("/weGetUserInfo")
	@ResponseBody
	public Object getUserInfo(int userid){
		UserInfo userInfo=userService.getUserInfo(userid);
		if(userInfo!=null && userInfo.getUserteamtype()==0)
			userInfo.setUserteamimg("");
		return userService.getUserInfo(userid);
	}
	
	
	
	@RequestMapping("/weUpdateImage")
	@ResponseBody
	public Object updateImage(HttpServletRequest request,int userid){
		User user=new User();
		user.setUserid(userid);
		user.setIsupdate(1);
		Map<String,String> mapResult=new HashMap<String,String>();
		String filepath="/userhead/";
		String headimg=FileUpload.uploadFile(request, filepath, "image");
		if(headimg==""){
			mapResult.put("result",StrUtil.update_error);
			return mapResult;
		}
		user.setHeadimg(headimg);
		//user.setIsupdate(1);
		int count = userService.updateUserHeadImg(user);
		
		if(count==0){
			mapResult.put("result",StrUtil.update_error);
		}else{
			mapResult.put("result","1");
		}
		return mapResult;
	}
  
	
	@RequestMapping("/weUpdateName")
	@ResponseBody
	public Object updateName(HttpServletRequest request,int userid,String username){
		User user=new User();
		user.setUserid(userid);
		user.setUsername(username);
		int count = userService.updateUserInfo(user);
		Map<String,String> mapResult=new HashMap<String,String>();
		if(count==0){
			mapResult.put("result",StrUtil.update_error);
		}else{
			mapResult.put("result","1");
		}
		return mapResult;
	}
	
	
	@RequestMapping("/weUpdatePhone")
	@ResponseBody
	public Object updatePhone(HttpServletRequest request,int userid,String phone,String validatecode){
		Map map=userService.getUseridByPhone(phone);
		Map<String,String> mapResult=new HashMap<String,String>();
		//验证验证
		if(map !=null && Integer.valueOf(map.get("userid").toString())!=userid){
			mapResult.put("result",StrUtil.phone_exist_error);
			return mapResult;
		}
		map=new HashMap();
		map.put("phone", phone);
		map.put("validatecode", validatecode);
		int count = 0;
		try {
			ValidateCode code = registService.getValidateInfo(phone);
			//没有验证码
			if(code==null){
				mapResult.put("result",StrUtil.login_code_exist);
				return mapResult;
			}
			//验证码已使用
			if(code.getState()==1){
				mapResult.put("result",StrUtil.login_code_user);
				return mapResult;
			
			}
			//三次输入失败
			if(code.getErrcount()==3){
				mapResult.put("result",StrUtil.login_code_errorcout);
				return mapResult;
				
			}
			if(!code.getCode().equals(validatecode)){
				//修改错误次数
				count=registService.updateValidateCodeCount(phone);
				mapResult.put("result",StrUtil.phone_code_error);
				return mapResult;
		
			}
			count=1;
			
		} catch (Exception e) {
			count = 0;
		}
		if(count==0){
			mapResult.put("result",StrUtil.phone_code_error);
			return mapResult;
		}
		User user=new User();
		user.setUserid(userid);
		user.setUsertele(phone);;
		 count = userService.updateUserInfo(user);
		
		if(count==0){
			mapResult.put("result",StrUtil.update_error);
		}else{
			mapResult.put("result","1");
		}
		return mapResult;
	}
	
	
	
	@RequestMapping("/weUpdateUserType")
	@ResponseBody
	public Object updateUserType(HttpServletRequest request,int userid,int userteamtype){
		User user=new User();
		user.setUserid(userid);
		user.setUserteamtype(userteamtype);
		int count = userService.updateUserInfo(user);
		Map<String,String> mapResult=new HashMap<String,String>();
		if(count==0){
			mapResult.put("result",StrUtil.update_error);
		}else{
			mapResult.put("result","1");
		}
		return mapResult;
	}
	
	@RequestMapping("/weUpdateUserTypeImage")
	@ResponseBody
	public Object updateUserTypeImage(HttpServletRequest request,int userid){
		User user=new User();
		user.setUserid(userid);
		user.setIsupdate(1);
		Map<String,String> mapResult=new HashMap<String,String>();
		/*
		Map map = HttpRequestUtil.getStringMap(request);
		String postImage = (String) map.get("userteamimg");
		String img = "";
		if (postImage != null && !("".equals(postImage))) {
			img = ImageUtil.byteChangeImage(request,postImage, TowerConfig.userteamimg);
			if (img != null && !img.equals("")) {
			} else {
				img = "";
			}
		}
		*/
		String filepath="/userteam/";
		String img=FileUpload.uploadFile(request, filepath, "userteamimg");
		
		if(img==""){
			mapResult.put("result",StrUtil.update_error);
			return mapResult;
		}
		user.setUserteamimg(img);
		int count = userService.updateUserTeamImg(user);
		if(count==0){
			mapResult.put("result",StrUtil.update_error);
		}else{
			mapResult.put("result","1");
		}
		return mapResult;
		
	}
	
	@RequestMapping("/weUpdateUserSex")
	@ResponseBody
	public Object updateUserSex(HttpServletRequest request,int userid,int usersex){
		User user=new User();
		user.setUserid(userid);
		user.setUsersex(usersex);
		int count = userService.updateUserInfo(user);
		Map<String,String> mapResult=new HashMap<String,String>();
		if(count==0){
			mapResult.put("result",StrUtil.update_error);
		}else{
			mapResult.put("result","1");
		}
		return mapResult;
	}
	
	@RequestMapping("/weUpdateUserOld")
	@ResponseBody
	public Object updateUserOld(HttpServletRequest request,int userid,int userold){
		User user=new User();
		user.setUserid(userid);
		user.setUserold(userold);
		int count = userService.updateUserInfo(user);
		Map<String,String> mapResult=new HashMap<String,String>();
		if(count==0){
			mapResult.put("result",StrUtil.update_error);
		}else{
			mapResult.put("result","1");
		}
		return mapResult;
	}
	
	
	@RequestMapping("/weUpdateUserBussiness")
	@ResponseBody
	public Object updateUserBussiness(HttpServletRequest request,int userid,int userbusiness){
		User user=new User();
		user.setUserid(userid);
		user.setUserbusiness(userbusiness);
		int count = userService.updateUserInfo(user);
		Map<String,String> mapResult=new HashMap<String,String>();
		if(count==0){
			mapResult.put("result",StrUtil.update_error);
		}else{
			mapResult.put("result","1");
		}
		return mapResult;
	}
	
	@RequestMapping("/weUpdateUserArea")
	@ResponseBody
	public Object updateUserArea(HttpServletRequest request,int userid,int usercity,int userdistrict){
		User user=new User();
		user.setUserid(userid);
		user.setUserdistrict(userdistrict);
		if(usercity/100==0)
			usercity=usercity*100+1;
		user.setUsercity(usercity);
		
		user.setUserprovince(usercity/100);
		int count = userService.updateUserInfo(user);
		Map<String,String> mapResult=new HashMap<String,String>();
		if(count==0){
			mapResult.put("result",StrUtil.update_error);
		}else{
			mapResult.put("result","1");
		}
		return mapResult;
	}
	
	@RequestMapping("/weUpdateUserCompany")
	@ResponseBody
	public Object updateUserCompany(HttpServletRequest request,int userid,String usercompany){
		User user=new User();
		user.setUserid(userid);
		user.setUsercompany(usercompany);
		int count = userService.updateUserInfo(user);
		Map<String,String> mapResult=new HashMap<String,String>();
		if(count==0){
			mapResult.put("result",StrUtil.update_error);
		}else{
			mapResult.put("result","1");
		}
		return mapResult;
	}
	
	
  
}
