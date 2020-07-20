package com.hackathon.cloud.function;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonObject;

/*Generating Fibonacci series based on given input number*/
public class FunctionApp {
	private static final Logger Logger = LoggerFactory.getLogger(FunctionApp.class);

    public static JsonObject main(JsonObject input) {
		int first=0,second=1,sum=0;
		List<Integer> list=new ArrayList<Integer>();
	    int count=input.getAsJsonPrimitive("number").getAsInt();
	    while (first <= count) {
			sum=first+second;
			list.add(first);
			first=second;
			second=sum;
		}
	    input.addProperty("FibonacciSeries", list.toString());
		Logger.info(input.toString());
		return input;
}

}
