package org.chapter14;

import java.util.Random;

/**
 * ֤���������ڵ�һ��ʹ�þ�̬��Ա��ʱ��ű����ص�
 * ֤����*.class�ǲ����ʼ����ģ�֤��Class.forName���ʼ����
 * ֤����static final���ε��಻��Ҫ���г�ʼ���Ϳ��Զ�ȡ
 * @author Administrator
 *
 */
class Initable {
	static final int staticFinal  = 47;
	static final int staticFinal2 = ClassInitialization.rand.nextInt(1000);
	
	static {
		System.out.println("Initializing Initable");
	}
}

class Initable2 {
	static int staticNonFinal = 147;
	static {
		System.out.println("Initialization Initable2");
	}
}

class Initable3 {
	static int staticNonFinal = 74;
	static {
		System.out.println("Initializing Initable3");
	}
}

public class ClassInitialization {
	public static Random rand = new Random(47);
	
	public static void main(String[] args) throws Exception {
		Class initable = Initable.class;
		System.out.println("After creating Initable ref");
		System.out.println(Initable.staticFinal);
		System.out.println(Initable.staticFinal2);
		System.out.println("----Initable----");
		
		System.out.println(Initable2.staticNonFinal);
		System.out.println("----Initable2----");
		
		Class initable3 = Class.forName("org.chapter14.Initable3");
		System.out.println("After creating Initable3 ref");
		System.out.println(Initable3.staticNonFinal);
	}
}
/**
 After creating Initable ref
47
Initializing Initable
258
----Initable----
Initialization Initable2
147
----Initable2----
Initializing Initable3
After creating Initable3 ref
74
*/