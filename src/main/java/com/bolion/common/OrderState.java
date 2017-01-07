package com.bolion.common;

public class OrderState {
	
	public static int qd=0;
	
	public static int cancel=1;
	
	public static int post=2;
	
	public static int delay=13;
	
	public static int target_address_apply=15;
	
	
	
	
	/**
	 * 是否可提交目标
	 * @param state
	 * @return
	 */
	public static boolean canTargetAddressOrder(int state) {
		if(state == 0)
		  return true;
		return false;
	}
	
	/**
	 * 可取消订单的状态
	 * @param state
	 * @return
	 */
	public static boolean canAbandonOrder(int state) {
		if (state == 0 || state == 12 || state == 13 || state == 14
				|| state == 15 || state == 16 || state == 17 || state == 19
				|| state == 20 || state == 21)
			return true;
		return false;
	}

	/**
	 * 可交单的状态
	 * @param state
	 * @return
	 */
	public static boolean canPostOrder(int state) {

		if (state == 0 || state == 12 || state == 13 || state == 14
				|| state == 15 || state == 16 || state == 17 || state == 19
				|| state == 20 || state == 21)
			return true;
		return false;
	}
	
	/**
	 * 是否可以延期
	 * @param state
	 * @return
	 */
	public static boolean canDelayOrder(int state) {
		if(state == 0||state == 19 || state==12 ||state==14)
			
		  return true;
		return false;
	}
	

}
