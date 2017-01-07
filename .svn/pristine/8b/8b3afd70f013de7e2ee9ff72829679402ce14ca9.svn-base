package com.bolion.money.common;

public class StrUtil {
	
	public static final String sms_post_url="http://manager.wxtxsms.cn/smsport/sendPost.aspx";
	
	public static final String sms_uid="sdtower1";
	
	public static final String sms_pwd="26f9d31dd9889cb49f303a55c7aa5518";
	
	public static final String sms_sign="上海铁塔";
	
	public static final String sms_conteten="欢迎关注上海铁塔寻址俱乐部！您的验证码是%s";
	
	public static final String validatecode_get_ok="验证码获取成功！";
	
	public static final String validatecode_get_error="验证码获取失败！";
	
	public static final String regist_phone_exist="该手机号已注册！";
	
	public static final String regist_open_exist="该微信已注册！";
	
	public static final String regist_error="注册失败！";
	
	public static final String regist_validate_error="验证码错误！";
	
	public static final String order_insert_error="抢单失败！";
	
	public static final String update_error="修改失败！";
	
	public static final String add_favourite_error="加入收藏失败！";
	
	public static final String card_insert_error="银行卡添加失败！";
	
	public static final String card_delete_error="银行卡删除失败！";

	public static final String abandon_order_error="弃单失败！";
	
	public static final String abandon_order="该订单已失败！";
	
	public static final String delay_order_error="延期失败！";
	
	public static final String delay_count_error="延期超过次数！";
	
	public static final String delay_yyq_error="已经有一个延期申请正在处理中!";
	
	public static final String tj_order_target_address_error="提交目标建站地址失败！";
	
	public static final String pj_order_error="订单评价失败！";
	
	public static final String post_order_error="交单失败！";
	
	public static final String post_order="该订单已处于交单状态！";
	
	public static final String user_tx_error="提现失败！";
	
	public static final String user_tx_money_error="当前没有可提现金额！";
	
	public static final String user_no_defaultcard="没有设置默认银行卡，请先设置！";
	
	public static final String update_card_error="银行卡修改失败！";
	
	public static final String default_card_error="银行卡设置默认失败！";
	
	public static final String default_card_success="设置成功！";
	
	public static final String tx_recode_state_error="确认失败！";
	
	public static final String tx="tx";
	
	public static final String qd="qd";
	
	public static final String three_ht_name="/three_ht.ftl";
	

	
	//public static final int qd_start_time=15;
	
	public static final int qd_end_time=6;
	
	public static final int tx_record_zidong=24;
	
	public static final int defult_user_type=6;//社会能人
	
	public static final String qd_count_out="抢单数量达到上限！";
	
	public static final String qd_time_error="%s点之后才能抢单哦！";
	
	public static final String qd_state_error="抢单失败！";
	
	public static final Integer[] yqiangd_states={0,5,7,12,13,14,15,16,17,19,20,21,22};
	
	public static final Integer[] yqd_states={1,3,6,11,18,23};
	
	public static final Integer[] yqsqz_states={13,20,21};
	
	public static final Integer[] yjd_states={2,4,8,9,10};
	
	public static int getSelectIndex(int state){
		for (Integer s : yqiangd_states) {
			if(s==state)
				return 0;
		}
		for (Integer s : yqd_states) {
			if(s==state)
				return 1;
		}
		for (Integer s : yqsqz_states) {
			if(s==state)
				return 3;
		}
		for (Integer s : yjd_states) {
			if(s==state)
				return 2;
		}
		return 1;
	}
	
	public static String FormatStr(String str){
		if(str==null){
			return str="";
		}else if(str.equals("")){
			return str;
		}else{
			return str.replace("../","");
		}
	}
	
}
