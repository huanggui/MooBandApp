package com.moo.utils;

import java.util.List;

import com.moo.model.FriendInfo;

public class BLEDataUtils {

	/**
	 * 从手环获取用户的心率
	 * @return 
	 */
	public static int getHeartRate() {
		return 77;
	}
	
	/**
	 * 从手环获取用户的体温
	 * @return
	 */
	public static float getTemperature() {
		return (float) 37.0;
	}
	
	/**
	 * 从手环获取用户当天目前的总步数
	 * @return
	 */
	public static int getStepNumber() {
		return 12345;
	}
	
	/**
	 * 获取用户开始入睡的时间，以时间截记录
	 * @return  
	 */
	public static long getTimeOfEnterSleep() {
		return 123456;
	}
	
	/**
	 * 获取用户在睡眠过程中手环摆动的时间，用于记录深睡与浅睡
	 * @return
	 */
	public static long getTimeOfActiveInSleep() {
		return 123456;
	}
	
	/**
	 * 获取手环当前的工作状态
	 * @return 返回手环工作状态集中当前状态
	 */
	public static int getCurrentState() {
		return 0;
	}
	
	/**
	 * 获取当前用户对手环施加的动作事件，如轻巧、晃动等
	 * @return
	 */
	public static int getDoingEvents() {
		return 0;
	}
	
	/**
	 * 获取手环中存储的新添加好友信息
	 * @return
	 */
	public static List<FriendInfo> getFriendInfos() {
		return null;
	}
 }
