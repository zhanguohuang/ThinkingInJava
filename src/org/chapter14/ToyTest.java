package org.chapter14;

interface HasBatteries {}
interface Waterproof {}
interface Shoots {}

/**
 * 类型信息的基本获取方法
 * 包括了获取superclass interface
 * @author Administrator
 *
 */
class Toy {
	Toy() {}
	Toy(int i) {}
}

class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots {
	FancyToy() {
		super(1);
	}
}

public class ToyTest {
	static void printInfo(Class cc) {
		System.out.println("Class name: " + cc.getName() + " is interface? [" + cc.isInterface() + "]");
		System.out.println("Simple name: " + cc.getSimpleName());
		System.out.println("Canonical name: " + cc.getCanonicalName());
	}
	
	public static void main(String[] args) {
		Class c = null;
		try {
			c = Class.forName("org.chapter14.FancyToy");
		} catch(ClassNotFoundException e) {
			System.out.println("Can't find FancyToy");
			System.exit(1);
		}
		printInfo(c);
		for(Class face : c.getInterfaces()) 
			printInfo(face);
		Class up = c.getSuperclass();
		Object obj = null;
		try {
			obj = up.newInstance();
		} catch(InstantiationException e) {
			System.out.println("Cannot instantiate");
			System.exit(1);
		} catch(IllegalAccessException e) {
			System.out.println("Cannot access");
			System.exit(1);
		}
		printInfo(obj.getClass());
	}
}
/**
Class name: org.chapter14.FancyToy is interface? [false]
Simple name: FancyToy
Canonical name: org.chapter14.FancyToy
Class name: org.chapter14.HasBatteries is interface? [true]
Simple name: HasBatteries
Canonical name: org.chapter14.HasBatteries
Class name: org.chapter14.Waterproof is interface? [true]
Simple name: Waterproof
Canonical name: org.chapter14.Waterproof
Class name: org.chapter14.Shoots is interface? [true]
Simple name: Shoots
Canonical name: org.chapter14.Shoots
Class name: org.chapter14.Toy is interface? [false]
Simple name: Toy
Canonical name: org.chapter14.Toy
*/