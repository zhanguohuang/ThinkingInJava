package org.chapter9;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Random;
import java.util.Scanner;

public class RandomWords implements Readable{

	private static Random rand = new Random(47);
	private static final char[] capitals = "ABCDEFGHIJKLMNOPQRSTUVWSYZ".toCharArray();
	private static final char[] lowers = "abcdefghijklmnopqrstuvwsyz".toCharArray();
	private static final char[] vowels = "aeiou".toCharArray();
	private int count;
	public RandomWords(int count){
		this.count = count;
	}
	@Override
	public int read(CharBuffer cb) throws IOException {
		if(count-- == 0){
			return -1;
		}
		cb.append(capitals[rand.nextInt(capitals.length)]);
		for(int i=0;i<4;i++){
			cb.append(vowels[rand.nextInt(vowels.length)]);
			cb.append(lowers[rand.nextInt(lowers.length)]);
		}
		cb.append(" ");//会变成换行符
		return 10; //number of characters appended
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(new RandomWords(10));
		while(sc.hasNext()){
			System.out.println(sc.next());
		}
	}
	
}