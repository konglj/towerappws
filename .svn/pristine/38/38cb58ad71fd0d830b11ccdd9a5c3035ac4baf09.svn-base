package com.bolion.common.util;

import java.sql.Timestamp;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;



public class TowerUtil {

	/**
	 * 获取公示剩余时间
	 * @param visible
	 * @param gstime
	 * @return
	 */
	public static long getTimeBalance(String visible, String gstime) {
		// String visible = tower.getTowervisibletime();
		Timestamp addStamp = Timestamp.valueOf(visible);
		Timestamp curStamp = new Timestamp(System.currentTimeMillis());
		Date d = new Date();
		String startdate = new SimpleDateFormat("yyyy-MM-dd").format(d);
		startdate += " ";
		startdate += gstime;
		startdate += ":00";
		Timestamp startStamp = Timestamp.valueOf(startdate);
		int hour = startStamp.getHours();
		// 判断当前时间的小时

		String date = addStamp.toString();
		String addTime = addStamp.toString();
		long j = 0;
		if (addStamp.getHours() < hour) {
			String cur = "";
			cur = date.substring(0, addTime.indexOf(" ") + 1);
			cur += String.valueOf(hour);
			cur += ":00:00";
			j = Timestamp.valueOf(cur).getTime();

		} else {
			String cur = "";
			cur = date.substring(0, addTime.indexOf(" ") + 1);
			cur += String.valueOf(hour);
			cur += ":00:00";
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(Timestamp.valueOf(cur));
			calendar.add(Calendar.DAY_OF_MONTH, 1);// 日期加一
			j = calendar.getTime().getTime();
		}
		// j为公示结束时间

		if (curStamp.getTime() >= j)
			return 0;

		return j - curStamp.getTime();

	}
	
	
	/**
	 * 根据用户级别获取查看站址级别
	 * @param userlevel
	 * @return
	 */
	public static int[]getTowerLevel(int userlevel){
		if(userlevel==1)
			return new int[]{4};
		if(userlevel==2)
			return new int[]{3,4};
		if(userlevel==3)
			return new int[]{2,3,4};
		if(userlevel==4)
			return new int[]{1,2,3,4};
		return new int[]{0};
		
	}
	/**
	 *  根据用户类型获取查看站址级别
	 * @param usertype
	 * @return
	 */
	public static int[] getTowerLevelByUserType(int usertype) {
		if (usertype == 6)
			return new int[] { 4 };
		return new int[] { 1, 2, 3, 4 };

	}
	/**
	 * 获取订单编号
	 * @param userid
	 * @param qz
	 * @return
	 */
	public static String getOrderid(int userid, String qz) {
		String time = TimeUtil.getNNow();
		StringBuilder sb = new StringBuilder();
		sb.append(qz);
		sb.append(time);
		sb.append(numberFormat(userid, 6));
		return sb.toString();
	}
	
	/**
	 * 整数补0操作
	 * @param number 数值
	 * @param count  长度
	 * @return
	 */
	private static String numberFormat(int number, int count) {
		NumberFormat formatter = NumberFormat.getNumberInstance();
		formatter.setMinimumIntegerDigits(count);
		formatter.setGroupingUsed(false);
		String s = formatter.format(number);
		return s;
	}
	
	
}
