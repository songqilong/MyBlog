package com.song.common;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Common {
	
	/**
	 * 获取当前时间的字符串
	 * @return
	 */
	public static String GetCurrentTime(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date = Calendar.getInstance().getTime();
		return sdf.format(date);
	}
}
