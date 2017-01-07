package com.bolion.common.util.sms;

import java.io.UnsupportedEncodingException;

import com.bolion.common.util.HttpRequestUtil;

public class SmsUtil {
	
	 // 获取验证码
	private static	String url = "http://manager.wxtxsms.cn/smsport/sendPost.aspx";
	private static String uid = "sdtower7";
	private static String upwd = "4e24e728ac74550695e4962ca0f904da";

	

	public static boolean sendSms(String phone,String content) {
		  String sign = "选址吧";
		String msg="";
		
		
		try {
			System.out.println("sms sign : "+sign);
			msg = java.net.URLEncoder.encode(content, "utf-8");
			sign = java.net.URLEncoder.encode(sign, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String param = String.format(
				"uid=%s&upsd=%s&sendtele=%s&Msg=%s&sign=%s", uid, upwd, phone,
				msg, sign);
		String result = "";
		try {
			result = HttpRequestUtil.sendPost(url, param);
			System.out.println("sms content : "+content);
		
			System.out.println("sms result : "+result);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		if (result.startsWith("success"))
			return true;
		return false;
	}

}
