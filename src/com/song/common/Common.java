package com.song.common;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Common {
	
	/**
	 * ��ȡ��ǰʱ����ַ���
	 * @return
	 */
	public static String GetCurrentTime(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date = Calendar.getInstance().getTime();
		return sdf.format(date);
	}
}
