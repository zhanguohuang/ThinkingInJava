package org.chapter14;

/**
 * �����и�����ֵ���ʾ����Ҫ��? super FancyToy����ʾ����
 * ���¶������ʹ��Object������newInstance
 * @author Administrator
 *
 */
public class GenericToyTest {
	public static void main(String[] args) throws Exception {
		Class<FancyToy> ftClass = FancyToy.class;
		/*������һ��ȷ��������*/
		FancyToy fancyToy = ftClass.newInstance();
		Class<? super FancyToy> up = ftClass.getSuperclass();
		//Class<Toy> up2 = ftClass.getSuperclass();
		Object obj = up.newInstance();
	}
}
