package org.chapter14;

/**
 * 这里有个很奇怪的显示，需要用? super FancyToy来表示基类
 * 导致而后仅能使用Object来接受newInstance
 * @author Administrator
 *
 */
public class GenericToyTest {
	public static void main(String[] args) throws Exception {
		Class<FancyToy> ftClass = FancyToy.class;
		/*必须是一个确定的类型*/
		FancyToy fancyToy = ftClass.newInstance();
		Class<? super FancyToy> up = ftClass.getSuperclass();
		//Class<Toy> up2 = ftClass.getSuperclass();
		Object obj = up.newInstance();
	}
}
