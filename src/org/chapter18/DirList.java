package org.chapter18;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class DirList {

	public static void main(String[] args) {
		/*当前路径，为项目下的路径 /project/* */
		File path = new File(".");
		String[] list;
		if(args.length == 0) {
			list = path.list();
		} else {
			list = path.list(new DirFilter(args[0]));
		}
		/*String.CASE_INSENSITIVE_ORDER是一个Comparator*/
		Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
		for(String dirItem : list)
			System.out.println(dirItem);
	}
}

/**
 * 策略模式,list回调的accept方法，而accept方法可以灵活的运用各种策略
 * @author Administrator
 *
 */
class DirFilter implements FilenameFilter {
	
	private Pattern pattern;
	
	public DirFilter(String regex) {
		pattern = Pattern.compile(regex);
	}
	
	public boolean accept(File dir, String name) {
		return pattern.matcher(name).matches();
	}
}