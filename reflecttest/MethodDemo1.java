package com.reflecttest;

import java.lang.reflect.Method;

public class MethodDemo1 {

	public static void main(String[] args) {
		//要获取print(int,int)方法
		//1.要获取一个方法，就是获取类的信息；获取类的信息，首先要知道类的类类型
		A a1 = new A();
		Class c = a1.getClass();
		/*
		 * 2. 获取方法 名称和参数列表来决定 
		 * getMethod获取的是public的方法
		 * getDelcaredMethod获取的是自己声明的方法
		 */
		try {
			//也可以用 Method m = c.getMethod("print", new Class[]{int.class,int.class});
		    Method m = c.getMethod("print", int.class,int.class);
		    
		    //方法的反射操作
		    a1.print(10, 20); //常规调用
		    //方法的反射操作指的是用m对象来进行方法调用 和a1.print调用的效果完全相同
		    Object o = m.invoke(a1, new Object[]{10,20});//传数组的方式
		    //Object o = m.invoke(a1,10,20);
		    System.out.println("========");
		    //获取方法print(String,String)
		    Method m1 = c.getMethod("print", String.class,String.class);
		    //对方法进行反射操作
		    a1.print("a", "b");
		    Object o1=m1.invoke(a1, "a","b");
		    System.out.println("========");
		    Method m2 = c.getMethod("print");
		    m2.invoke(a1, new Object[]{});
		    m2.invoke(a1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
class A{
	public void print(int a,int b) {
		System.out.println(a+b);
	}
	public void print(String a,String b) {
		System.out.println(a.toUpperCase()+","+b.toLowerCase());
	}
}
