package com.example.demointern;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class WarmUp {
	public static void main(String[] args){

		//WAP to create an array for range of values from 0,1,2,3....100
		int[] numArray = new int[101];

		for (int i=0;i<=100;i++){
			numArray[i]=i;
			//avg pprogrammer metthod
		}
		//java 8 feature
		int[] numbersArray = IntStream.rangeClosed(0,100).toArray();
		for (int i=0;i<=100;i++){
			System.out.print(numbersArray[i]);
			//avg pprogrammer metthod
		}

		// WAP to create a ArrayList<Integer> that contains 0,1,2,3......100 Integer numbers.
		List<Integer> numList = new ArrayList<>();
		for (int i = 0; i <= 100; i++) {
			numList.add(new Integer(i));
		}
// Using Java 8 Feature: IntStream
		List<Integer> numbersList = IntStream.rangeClosed (0, 100) //0,1,2,,100
				.mapToObj(i -> new Integer(i))//integer objects
				.toList();//add all integer objs to arraylist
	}
}
