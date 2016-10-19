package org.chapter13;

import java.util.Arrays;

public class Splitting {

	public static String knights = "Then, when you have found the shrubbery, " + 
			"you must cut down the mightiest tree in the forest... with... a herring!";
	
	public static void split(String regex) {
		System.out.println(Arrays.toString(knights.split(regex)));
	}
	
	public static void main(String[] args) {
		split(" ");	//切开空格
		split("\\W+"); //从非单词字符里切下来
		split("n\\W+");
	}
}
