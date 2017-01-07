package com.bolion.common;

public class TowerConfig {

	
	public static String userteamimg="images/userteam/";
	
	// 每日查看多少站址给积分
	public static int tower_see_score_count = 5;
	// 站址列表每次加载个数
	public static int tower_list_page_size = 10;

	// 订单列表每次加载个数
	public static int order_list_page_size = 15;
	// 公示时间设置
	public static String gstimename = "gstime";
	// 点击公示时的时间
	public static String gsgsstarttimename = "gsstarttime";
	// 社会能人抢单数
	public static String nrqdcountname = "nrqdcount";

	// 高级用户抢单书
	public static String otherqdcountname = "otherqdcount";

	public static String qdtimename = "qdtime";

	// 首页推荐站址的条数
	public static int index_show_tower_count = 20;
	// 百度地图API
	public static String baidu_map_api = "X7VfT2X8QbCWgr5hazkMuL98Rq64L1VQ";

	// 社会能人
	public static int usertypenr = 6;

	// 订单编号前缀
	public static String order_no_qz = "QD";
	
	//订单星期中显示的操作记录条数
	//要求所有操作记录都显示
	public static int order_option_top=40;
	
	//连续弃单多少条后冻结用户
	public static int order_concancel_dj_count=10;
	
	public static int yq_max_count=2;
}
