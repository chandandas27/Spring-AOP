package com.chandan.springappaop.aop.business;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.chandan.springappaop.aop.annotations.TrackTime;
import com.chandan.springappaop.aop.data.DataService1;

@Service
public class BusinessService1 {
	
	private DataService1 dataService1;
	
	public BusinessService1(DataService1 dataService1) {
		this.dataService1 = dataService1;
	}
	
	@TrackTime
	public int calculateMax() {
		int[] data = dataService1.retrieveData();
		
//		try {
//			Thread.sleep(30);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		// throw new RuntimeException("Something Went Wrong!");
		
		return Arrays.stream(data).max().orElse(0);
	}

}
