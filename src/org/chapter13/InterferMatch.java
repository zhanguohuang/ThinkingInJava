package org.chapter13;


public class InterferMatch {
	
	public static void main(String[] args) {
		System.out.println("-1234".matches("-?\\d+"));
		System.out.println("5678".matches("-?\\d+"));
		System.out.println("+911".matches("-?\\d+")); /*false*/
		System.out.println("+911".matches("(-|\\+)?\\d+"));
	}
}
