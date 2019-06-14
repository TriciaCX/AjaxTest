package com.reflecttest;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;



public class ClassUtil {
	/**
	 * ��ӡ�����Ϣ��������ĳ�Ա��������Ա����
	 * @param obj �ö������������Ϣ
	 */
	public static void printClassMessage(Object object) {
		//��ȡ�����Ϣ������Ҫ��ȡ�������
		Class c = object.getClass(); //���ݵ����ĸ�����Ķ���c���Ǹ����������
		//��ȡ�������
		System.out.println("��������ǣ�"+c.getName());
		System.out.println("*****************");
		/*
		 * Method�࣬��������
		 * һ����Ա�������� һ��method����
		 * getMethods����������ȡ�������е�public�ĺ�������������̳ж�����
		 * getDeclaredMethods()��ȡ�������и����Լ������ķ��������ʷ���Ȩ��
		 */
		Method[] ms = c.getMethods(); //Ҳ���Ըĳ�c.getDeclaredMethods()
		for(int i=0;i<ms.length;i++) {
			//�õ������ķ���ֵ����
			Class returnType = ms[i].getReturnType();
			System.out.println(returnType.getName()+" ");
			//�õ�����������
			System.out.print(ms[i].getName()+"(");
			//��ȡ��������-->�õ����ǲ����б�����͵�������
			Class[] paramTypes = ms[i].getParameterTypes();
			for (Class class1 : paramTypes) {
				System.out.print(class1.getName()+",");
			}
			System.out.println(")");
			
		
			printFieldMessage(c);
		}
	}

	/**
	 * ��Ա����Ҳ�Ƕ���
	 * java.lang.reflect.Field
	 * Field���װ�˹��ڳ�Ա�����Ĳ���
	 * getFields()������ȡ�������е�public�ĳ�Ա��������Ϣ
	 */
	protected static void printFieldMessage(Class c) {
		Field[] fs=c.getDeclaredFields();
		for (Field field : fs) {
			//�õ���Ա���������͵�������
			Class fieldType = field.getType();
			String typeName = fieldType.getName();
			//�õ���Ա����������
			String fieldName = field.getName();
			System.out.println(typeName+" "+fieldName);
		}
	}
	
	public static void printConMessage(Object object) {
		Class c = object.getClass();
		/*
		 * ���캯��Ҳ�Ƕ���
		 * java.lang.Constructor�з�װ�˹��캯������Ϣ
		 * getConstructors��ȡ���е�public�Ĺ��캯��
		 * getDeclaredConstructors�õ����еĹ��캯��
		 */
		Constructor[] cs = c.getDeclaredConstructors();
		for (Constructor constructor : cs) {
			System.out.print(constructor.getName()+"(");
			//��ȡ���캯���Ĳ����б�-->�õ����ǲ����б��������
			Class[] paramTypes = constructor.getParameterTypes(); 
		for (Class class1 : paramTypes) {
			System.out.print(class1.getName()+",");
		}
		System.out.print(")");
		System.out.println();
		}
		
	}
}
