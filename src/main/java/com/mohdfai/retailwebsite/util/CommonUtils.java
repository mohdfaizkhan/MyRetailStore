package com.mohdfai.retailwebsite.util;

import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author mohdfai
 *
 */
public class CommonUtils {

	public static int getDiffYears(Date first, Date last)
	{
		Period period = Period.between(first.toInstant()
				.atZone(ZoneId.systemDefault())
				.toLocalDate(), last.toInstant()
				.atZone(ZoneId.systemDefault())
				.toLocalDate());
		return period.getYears();
	}
}
