package org.chapter20;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UseCase {
	public int id();
	//description�и�Ĭ��ֵ,������õķ���û�и���description��
	//���ע��ͻ�ʹ�ô�Ԫ�ص�Ĭ��ֵ
	public String description() default "no descrption";
}
