package com.shine.annotation;

import java.lang.reflect.Method;

import com.shine.enums.EnumTest;

@AnnotationTest(color="red",value="abc",arrayAttr=1)
public class AnnotationTestDemo {

	@SuppressWarnings("deprecation")//消除警告
	@AnnotationTest("xyz")//将value的值设置为xyz
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		if(AnnotationTestDemo.class.isAnnotationPresent(AnnotationTest.class)){
			AnnotationTest annotation = (AnnotationTest)AnnotationTestDemo.class.getAnnotation(AnnotationTest.class);
			System.out.println(annotation.color());
			System.out.println(annotation.value());
			System.out.println(annotation.arrayAttr().length);
			System.out.println(annotation.lamp().nextLamp().name());
		}
		Method mainMethod = AnnotationTestDemo.class.getMethod("main", String[].class);//方法名与参数
		AnnotationTest annotation2 = (AnnotationTest)mainMethod.getAnnotation(AnnotationTest.class);
		System.out.println(annotation2.value());
	}
	@Deprecated//将方法设置为过时方法
	public static void sayHello(){
		System.out.println("hi");
	}
}
@interface AnnotationTest {
	String color() default "blue";//默认为blue，可以不再进行赋值
	String value();//value 属性不需要加 =
	int[] arrayAttr() default {3,4,4};
	EnumTest lamp() default EnumTest.RED;

}