package org.chapter13;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 匹配最后三个词
 * @author Administrator
 *
 */
public class Groups {
	
	public static final String POEM = 
			"Twas brilling, and the slithy toves\n" +
			"Did gyre and gimble in the wabe.\n" +
			"All mimsy were the borogoves,\n" +
			"And the more raths outgrabe.\n\n" +
			"Beware the Jabberwock, my son,\n" +
			"The jaws that bite. the claws that catch.\n" +
			"Beware the Jubjub bird, and shun\n" + 
			"The frumious Bandersnatch.";
	
	public static void main(String[] args) {
		Matcher m = Pattern.compile("(?m)(\\S+)\\s+((\\S+)\\s+(\\S+))$").matcher(POEM);
		while(m.find()) {
			for(int j=0;j<=m.groupCount();j++)
				System.out.print("[" + m.group(j) + "]");
			System.out.println();
		}
	}
}

/*
[the slithy toves][the][slithy toves][slithy][toves]
[in the wabe.][in][the wabe.][the][wabe.]
[were the borogoves,][were][the borogoves,][the][borogoves,]
[more raths outgrabe.][more][raths outgrabe.][raths][outgrabe.]
[Jabberwock, my son,][Jabberwock,][my son,][my][son,]
[claws that catch.][claws][that catch.][that][catch.]
[bird, and shun][bird,][and shun][and][shun]
[The frumious Bandersnatch.][The][frumious Bandersnatch.][frumious][Bandersnatch.]
*/ 
