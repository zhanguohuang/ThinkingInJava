package org.chapter14;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * ��̬����
 * @author Administrator
 *
 */
class DynamicProxyHandler implements InvocationHandler {

	private Object proxied;
	
	public DynamicProxyHandler(Object proxied) {
		this.proxied = proxied;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("**** proxy: " + proxy.getClass() + ", method: " + method + ", args: " + args);
		if(args != null) 
			for(Object arg : args) 
				System.out.println("  " + arg);
		/*��ȥ������proxied�����args����*/
		return method.invoke(proxied, args);
	}
	
}

public class SimpleDynamicProxy {
	
	public static void consumer(Interface iface) {
		iface.doSomething();
		iface.somethingElse("bonobo");
	}
	
	public static void main(String[] args) {
		RealObject real = new RealObject();
		consumer(real);
		//Insert a proxy and call again:
		Interface proxy = (Interface) Proxy.newProxyInstance(Interface.class.getClassLoader(), 
				new Class[] {Interface.class}, new DynamicProxyHandler(real));
		consumer(proxy);
	}
}
/**
doSomething
somethingElse bonobo
**** proxy: class org.chapter14.$Proxy0, method: public abstract void org.chapter14.Interface.doSomething(), args: null
doSomething
**** proxy: class org.chapter14.$Proxy0, method: public abstract void org.chapter14.Interface.somethingElse(java.lang.String), args: [Ljava.lang.Object;@782830e
  bonobo
somethingElse bonobo
*/