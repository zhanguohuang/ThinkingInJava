package org.chapter7;

class Cleanser {

	private String s = "Cleanser";
	public void append(String a){s += a;}
	public void dilute(){append(" dilute()");}
	public void apply(){append(" apply()");}
	public void scrub(){append(" scrub()");}
	public String toString(){
		return s;
	}
	public static void main(String[] args){
		Cleanser x = new Cleanser();
		x.dilute();x.apply();x.scrub();
		System.out.println(x);
		//应该输出	Cleanser dilute() apply() scrub()
	}
}

class Detergent extends Cleanser{
	@Override
	public void scrub(){
		append(" Detergent.scrub");
		super.scrub();
	}
	//新的方法
	public void foam(){append(" foam");}
	//Test the new class:
	public static void main(String[] args){
		Detergent x = new Detergent();
		x.dilute();
		x.apply();
		x.scrub();
		x.foam();
		System.out.println(x);
		System.out.println("Test base class:");
		//直接调用Cleanser的静态main方法
		Cleanser.main(args);	
	}
}
