package com.wdy.cyyx.util;

import java.util.Date;

public class OrderUtil {

	public static String creatSn(String userid) {
		String timestamp = new Date().getTime() + "";
		return timestamp.substring(0, timestamp.length() - 2) + userid;
	}

}
