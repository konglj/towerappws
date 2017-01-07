package com.bolion.login.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bolion.common.service.SettingService;
import com.bolion.common.util.DataValidation;
import com.bolion.common.util.SettingKey;
import com.bolion.common.util.sms.SmsUtil;
import com.bolion.login.bean.ValidateCode;
import com.bolion.login.common.StrUtil;
import com.bolion.login.service.RegistService;
import com.bolion.user.service.UserService;

@Controller
@RequestMapping("/regisAndLogin")
public class RegisAndLoginWS {

	@Autowired
	private RegistService registService;

	@Autowired
	private SettingService settingService;

	@Autowired
	private UserService userService;

	/**
	 * 获取验证码
	 * 
	 * @param request
	 * @param phone
	 * @return
	 */
	@RequestMapping("/weGetValidateCode")
	@ResponseBody
	public Object getCode(HttpServletRequest request, String phone) {
		Map<String, String> mapResult = new HashMap<String, String>();

		if (DataValidation.isNullOrEmpty(phone)) {
			mapResult.put("validatecode", "0");
			mapResult.put("errmsg", StrUtil.phone_empty);
			return mapResult;
		}
		// 获取验证码
		String code = DataValidation.getValidateCode(4);
		String content = String.format(StrUtil.sms_content, code);
		// 插入验证码
		Map<String, String> map = new HashMap<String, String>();
		map.put("phone", phone);
		map.put("validatecode", code);
		int count = 0;
		count = registService.updateValidateCode(map);
		if (count == 0) {
			mapResult.put("validatecode", "0");
			mapResult.put("errmsg", StrUtil.validatecode_get_error);
			return mapResult;
		}

		// 发送短信
		boolean result = SmsUtil.sendSms(phone, content);
		if (!result) {
			mapResult.put("validatecode", "0");
			mapResult.put("errmsg", StrUtil.validatecode_get_error);
			return mapResult;
		}
		mapResult.put("validatecode", code);
		mapResult.put("errmsg","");
		return map;
	}

	/**
	 * 登录或注册
	 * 
	 * @param phone
	 * @param validatecode
	 * @return
	 */
	@RequestMapping("/weLogin")
	@ResponseBody
	public Object login(String phone, String validatecode) {

		Map mapResult = new HashMap();
		// 验证验证吗
		Map mapUser = new HashMap();
		mapUser.put("phone", phone);
		mapUser.put("validatecode", validatecode);
		mapUser.put("usertele", phone);
		int count = 0;
		ValidateCode code = registService.getValidateInfo(phone);
		//没有验证码
			if(code==null){
				mapResult.put("userid", 0);
				mapResult.put("errmsg", StrUtil.login_code_exist);
				mapResult.put("state",1);
				mapResult.put("logintype", 0);
				return mapResult;
			}
			//验证码已使用
			if(code.getState()==1){
				mapResult.put("userid", 0);
				mapResult.put("errmsg", StrUtil.login_code_user);
				mapResult.put("state",1);
				mapResult.put("logintype", 0);
				return mapResult;
			}
			//三次输入失败
			if(code.getErrcount()==3){
				mapResult.put("userid", 0);
				mapResult.put("errmsg", StrUtil.login_code_errorcout);
				mapResult.put("state",1);
				mapResult.put("logintype", 0);
				return mapResult;
			}
			if(!code.getCode().equals(validatecode)){
				mapResult.put("userid", 0);
				mapResult.put("errmsg", StrUtil.login_validate_error);
				mapResult.put("state",1);
				mapResult.put("logintype", 0);
				//修改错误次数
				count=registService.updateValidateCodeCount(phone);
				return mapResult;
			}
			
			try {
				mapResult=registService.login(phone);
			} catch (Exception e) {
				mapResult.put("userid", 0);
				mapResult.put("errmsg", StrUtil.login_error);
				mapResult.put("state",1);
				mapResult.put("logintype", 0);
			}
			
	
		

		return mapResult;
	}

	/**
	 * 获取登录协议内容
	 * 
	 * @return
	 */
	@RequestMapping("/weGetXy")
	@ResponseBody
	public Object getXy() {
		Map<String, String> map = new HashMap<String, String>();
		String xy = settingService.getSettingContent(SettingKey.registxy);
		if (xy == null)
			xy = "";
		map.put("content", xy);
		return map;
	}

}
