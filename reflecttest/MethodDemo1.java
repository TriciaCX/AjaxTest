package com.reflecttest;

import java.lang.reflect.Method;

public class MethodDemo1 {

	public static void main(String[] args) {
		//Ҫ��ȡprint(int,int)����
		//1.Ҫ��ȡһ�����������ǻ�ȡ�����Ϣ����ȡ�����Ϣ������Ҫ֪�����������
		A a1 = new A();
		Class c = a1.getClass();
		/*
		 * 2. ��ȡ���� ���ƺͲ����б������� 
		 * getMethod��ȡ����public�ķ���
		 * getDelcaredMethod��ȡ�����Լ������ķ���
		 */
		try {
			//Ҳ������ Method m = c.getMethod("print", new Class[]{int.class,int.class});
		    Method m = c.getMethod("print", int.class,int.class);
		    
		    //�����ķ������
		    a1.print(10, 20); //�������
		    //�����ķ������ָ������m���������з������� ��a1.print���õ�Ч����ȫ��ͬ
		    Object o = m.invoke(a1, new Object[]{10,20});//������ķ�ʽ
		    //Object o = m.invoke(a1,10,20);
		    System.out.println("========");
		    //��ȡ����print(String,String)
		    Method m1 = c.getMethod("print", String.class,String.class);
		    //�Է������з������
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
