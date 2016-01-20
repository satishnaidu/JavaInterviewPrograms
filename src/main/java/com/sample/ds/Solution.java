package com.sample.ds;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Solution {

	private int entranceFee = 2;

	private SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");

	public static void main(String[] args) {

		String E = "10:10";
		String L = "13:21";
		Solution s = new Solution();
		int result = s.solution(E, L);
		System.out.println(result);

	}// end of main

	public int solution(String E, String L) {

		int cost = 0;
		cost = cost + entranceFee;
		try {
			Date entryTime = dateFormat.parse(E);

			Date leftTime = dateFormat.parse(L);
			Calendar cal1 = Calendar.getInstance();
			cal1.setTime(entryTime);
			int hours1 = cal1.get(Calendar.HOUR_OF_DAY);
			int min1 = cal1.get(Calendar.MINUTE);
			
			System.out.println(hours1);
			Calendar cal2 = Calendar.getInstance();
			cal2.setTime(leftTime);
			int hours2 = cal2.get(Calendar.HOUR_OF_DAY);
			int min2 = cal2.get(Calendar.MINUTE);
			
			System.out.println(hours2);
//			long diffInMillis = leftTime.getTime() - entryTime.getTime();
//			cal.setTimeInMillis(diffInMillis);
//			int hours = cal.get(Calendar.HOUR);
//			int minutes = cal.get(Calendar.MINUTE);
//
//			if (hours < 1) {
//				cost = cost + 3;
//				return cost;
//			}
//			if (hours > 1) {
//				if (minutes != 0) {
//					hours = hours + 1;
//				}
//				cost = cost + 3 + ((hours -1) * 4);
//			}

			System.out.println(hours2 - hours1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// write your code in Java SE 8

		return cost;
	}

}