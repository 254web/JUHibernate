package com.juhibernate.util;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class JUDateDefferent {

	public static Object convertSqlToUtilDate(Date firstDateObj, Date secDateObj) {
		final long differnceValue = secDateObj.getTime() - firstDateObj.getTime();

		return TimeUnit.DAYS.convert(differnceValue, TimeUnit.MILLISECONDS);
	}
}
