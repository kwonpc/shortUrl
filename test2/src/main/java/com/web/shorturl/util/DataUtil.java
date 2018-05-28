package com.web.shorturl.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtil {

	public static String getToday(String format){
		
		Date today = new Date();
		SimpleDateFormat simpleDate=new SimpleDateFormat(format);

		return simpleDate.format(today);

	}
}
