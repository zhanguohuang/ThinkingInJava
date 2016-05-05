package org.chapter20;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UseCase {
	public int id();
	//description有个默认值,如果调用的方法没有给出description，
	//则该注解就会使用此元素的默认值
	public String description() default "no descrption";
}
