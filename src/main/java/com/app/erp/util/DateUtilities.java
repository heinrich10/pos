package com.app.erp.util;

import java.util.LinkedHashMap;
import java.util.Map;

public class DateUtilities {
	
	private static final String[] months = {
				"January",
				"February",
				"March",
				"April",
				"May",
				"June",
				"July",
				"August",
				"September",
				"October",
				"November",
				"December"
		};
	
	private static final int[] year = {2013, 2014, 2015, 2016};
	
	private static Map<Integer, String> monthMap;
	
	static{
		monthMap = new LinkedHashMap<Integer, String>();
		for(int i=0; i < months.length; i++){
			monthMap.put(i+1, months[i]);
		}
	}
		
	public static String[] getMonths(){
		return months; 
	}
	
	public static Map<Integer, String> getMonthMap(){
		return monthMap;
	}
	
	public static int[] getYear(){
		return year;
	}
}
