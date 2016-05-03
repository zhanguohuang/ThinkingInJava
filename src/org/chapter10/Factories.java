package org.chapter10;

interface Service{
	void method1();
	void method2();
}

interface ServiceFactory{
	Service getService();
}

//自带工厂
class Implementation1 implements Service{
	private Implementation1(){};
	public void method1(){
		System.out.println("Implementation1 method1");
	}
	public void method2(){
		System.out.println("Implementation2 method2");
	}
	public static ServiceFactory factory = 
			new ServiceFactory(){
		public Service getService(){
			return new Implementation1();
		}
	};
}

class Implementation2 implements Service{
	private Implementation2(){}
	public void method1(){
		System.out.println("Implementation2 method1");
	}
	public void method2(){
		System.out.println("Implementation2 method2");
	}
	public static ServiceFactory factory = 
			new ServiceFactory(){
		public Service getService(){
			return new Implementation2();
		}
	};
}

public class Factories {
	//这个方法是核心
	public static void serviceComsumer(ServiceFactory fact){
		Service s = fact.getService();
		s.method1();
		s.method2();
	}
	public static void main(String[] args) {
		serviceComsumer(Implementation1.factory);
		serviceComsumer(Implementation2.factory);
	}
}
