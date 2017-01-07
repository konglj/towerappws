package com.bolion.money.common;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.w3c.dom.stylesheets.StyleSheetList;


public class ParamerUtil {

	public static String getOrderid(int userid, String qz) {
		String time = TimeUtil.getNNow();
		StringBuilder sb = new StringBuilder();
		sb.append(qz);
		sb.append(time);
		sb.append(numberFormat(userid, 6));
		return sb.toString();
	}

	public static String numberFormat(int number, int count) {
		NumberFormat formatter = NumberFormat.getNumberInstance();
		formatter.setMinimumIntegerDigits(count);
		formatter.setGroupingUsed(false);
		String s = formatter.format(number);
		return s;
	}


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

	public static String getOrderSyTime(long time_distance) {
		// Timestamp endtime = Timestamp.valueOf(orderendtime);
		// long end = endtime.getTime();
		// long time_distance = end - current;
		time_distance=time_distance*1000;
		if (time_distance <= 0)
			return String.format("%d天%d小时%d分钟%d秒", 0, 0, 0, 0);
		// 天
		long int_day = time_distance / 86400000;
		time_distance -= int_day * 86400000;
		// 时
		long int_hour = time_distance / 3600000;
		time_distance -= int_hour * 3600000;
		// 分
		long int_minute = time_distance / 60000;
		time_distance -= int_minute * 60000;
		// 秒
		long int_second = time_distance / 1000;

		return String.format("%d天%d小时%d分钟%d秒", int_day, int_hour, int_minute,
				int_second);

	}

	public static int getAdminType(int power) {
		if (power == 1 || power == 6 || power == 8 || power == 11)
			return 0;
		else if (power == 3)
			return 2;
		return 1;
	}

	public static int getUpdateOrderState(int oldstate, int result) {

		int state = -1;
		switch (oldstate) {

		case 0:
			if (result == 0)
				state = 3;
			else
				state = 0;
			break;

		case 2:
			if (result == 0)
				state = 3;
			else
				state = 4;
			break;
		case 4:
			if (result == 0)
				state = 23;
			break;

		case 5:
			if (result == 0)
				state = 6;

			break;
		case 7:
			if (result == 0)
				state = 22;
			else
				state = 4;
			break;

		case 8:
			if (result == 0)
				state = 10;
			else
				state = 9;
			break;
		case 10:
			if (result == 0)
				state = 23;
			break;

		case 13:// 延期申请中
			if (result == 0)
				state = 20;
			else
				state = 21;
			break;
		case 20:// 初级延期审核
		case 21:
			if (result == 0)
				state = 14;
			else
				state = 12;
			break;
		case 14:
			if (result == 0)
				state = 3;
			else
				state = 0;
			break;
		case 15:// 目标建站地址审核
			if (result == 0)
				state = 16;
			else
				state = 17;
			break;
		case 16:
		case 17:
			if (result == 0)
				state = 18;
			else
				state = 19;

		default:
			break;
		}
		return state;

	}

	public static int getUserLevel(int score, int ep) {
		if (score < 450 || ep < 4)
			return 1;

		if (score >= 450 && score < 900) {
			if (ep >= 4)
				return 2;
			else
				return 1;
		}
		if (score >= 900 && score < 1400) {
			if (ep >= 8)
				return 3;
			else
				return 2;
		}
		if (score >= 1400) {
			if (ep >= 12)
				return 4;
			else
				return 3;
		}

		return 0;
	}

	public static String getWebRootPath(HttpServletRequest request) {
		String path = "";
		path = request.getRequestURL().toString();
		return path;

	}

	public static boolean getCanAbandonOrder(int state) {
		if (state == 0 || state == 12 || state == 13 || state == 14
				|| state == 15 || state == 16 || state == 17 || state == 19
				|| state == 20 || state == 21)
			return true;
		return false;
	}

	public static boolean getCanPostOrder(int state) {

		if (state == 0 || state == 12 || state == 13 || state == 14
				|| state == 15 || state == 16 || state == 17 || state == 19
				|| state == 20 || state == 21)
			return true;
		return false;
	}

	public static Integer[] getAdminOrder(int power) {
		if (power == 1 || power == 6 || power == 8 || power == 11)
			return new Integer[] { -1 };
		if (power == 2)
			return new Integer[] { 2, 4, 5, 10, 16, 17, 20, 21, 22 };
		if (power == 3)
			return new Integer[] { 2, 4, 5, 10, 13, 15, 22 };
		if (power == 4)
			return new Integer[] { 7 };

		if (power == 12)
			return new Integer[] { 2, 4, 5, 10, 13, 15, 16, 17, 20, 21, 22 };

		if (power == 13)
			return new Integer[] { 2, 4, 5, 7, 10, 13, 15, 22 };

		if (power == 14)
			return new Integer[] { 2, 4, 5, 7, 10, 16, 17, 20, 21, 22 };

		if (power == 15)
			return new Integer[] { 2, 4, 5, 7, 10, 13, 15, 16, 17, 20, 21, 22 };

		return new Integer[] { -1 };
	}

	/*
	 * public int getOrderStateBySelectIndex(int index){ Integer [] states=new
	 * Integer[]; ; switch (index) { case 0:
	 * 
	 * break; case 1: //区域管理员 states={2,4,5,7,8,10,13,15}; //选择管理员理员
	 * states={2,4,5,7,8,10,16,17}; //建维经理 states={2,4,5,7,8,10,13,15,16,};
	 * break; case 2: break;
	 * 
	 * default: break; } return 0; }
	 */

	public static int xihuaPower(int power, int state) {
		boolean isXZ = false;
		boolean isQY = false;
		boolean isJW = false;
		
		switch (state) {
		case 3:
			isXZ=true;
			isQY=true;
			break;
		case 4:
			isJW=true;
			break;
		case 5:
			isXZ=true;
			isQY=true;
			break;

		case 6:
			isXZ=true;
			isQY=true;
			break;
		case 7:
			isXZ=true;
			isQY=true;
			break;
		case 8:
			isXZ=true;
			isQY=true;
			break;
		case 9:
			isJW=true;
			break;
		case 10:
			isJW=true;
			break;
		case 12:
			isXZ=true;
			break;
		case 14:
			isXZ=true;
			break;

		case 16:
			isQY=true;
			break;
		case 17:
			isQY=true;
			break;
		case 18:
			isXZ=true;
			break;
		case 19:
			isXZ=true;
			break;
		case 20:
			isQY=true;
			break;
		case 21:
			isQY=true;
			break;
		case 22:
			isJW=true;
			break;
		case 23:
			isXZ=true;
			isQY=true;
			break;
		case 24:
			isXZ=true;
			isQY=true;
			break;

		}
		int xhpower = power;
		switch (power) {
		case 12:
			if (isQY)
				xhpower = 3;
			else if (isXZ)
				xhpower = 2;
			break;
		case 13:
			if (isQY)
				xhpower = 3;
			if (isJW)
				xhpower = 4;
			break;
		case 14:
			if (isXZ || isQY)
				xhpower = 2;
			if (isJW)
				xhpower = 4;
		case 15:
			if (isQY)
				xhpower = 3;
			else if (isXZ)
				xhpower = 2;
			else if (isJW)
				xhpower = 4;

			break;

		default:
			break;
		}
		return xhpower;

	}

}
