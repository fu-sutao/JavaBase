package com.fanshe;

import java.lang.reflect.Constructor;

/**
 * ����Ļ���ʹ��
 * @2019-5-18
 * @author Administrator
 *һ�нԶ���
 *������Ƕ�һ����Ľ��٣����ǿ����õ�����Ҫ�Ķ���
 *class��java�����һ����  ������һ����ʱ��������Ϊclass���ֽ������ͣ�
 *��ʱ����Ϊ�����͡�
 */
public class Text1 {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		//��λ�ȡ�����ͣ����ַ�ʽ
		//1`����.class
		Class c1 = Cat.class;//��Ҫ�����������
		//2`����.getClass();
		Cat c = new Cat();
		Class c2 = c.getClass();//��������Ҳ�Ͳ���Ҫ������
		//3`Class.forName(���ȫ�޶���);
		Class c3;
		try {
			c3 = Class.forName("com.fanshe.Cat");//�Ƽ�ʹ��
			//�����ڴ沢���һ������
			System.out.println(c1==c2);//true
			System.out.println(c2==c3);	//true
			//����һ����㲻���ٴ�����
				//��ȡ���캯��
				//��ȡһ��
				//��ȡһ�ѹ��еĹ��캯��
				System.out.println("----------��ȡ����Ȩ�޵Ĺ��캯��-------------");
				Constructor[] cs = c3.getConstructors();
				for(Constructor b:cs) {
					System.out.println(b);
				}
				System.out.println("----------��ȡ���е�Ȩ�޹��캯��-------------");
				cs = c3.getDeclaredConstructors();
				for(Constructor b:cs) {
					System.out.println(b);
				}
				//��ȡ����
				//��ȡ�����Ĺ��еĹ��캯��
				System.out.println("----------��ȡ��������Ȩ�޹��캯��-------------");
				Constructor cs2 = c3.getConstructor(null);
				System.out.println(cs2);
				cs2 = c3.getDeclaredConstructor(int.class);
				System.out.println(cs2);
				//��ε���˽�еĹ��캯��
				//��ȥȨ��ȥ�����������ʣ�
				cs2.setAccessible(true);
				//ʵ����
				cs2.newInstance(3);//new Cat(3)
				
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
	}

}

class Cat{
	/**
	 * ���캯��
	 * ��Ա����
	 * ��Ա����
	 */
	public Cat() {
		System.out.println("���еĹ��캯��");
	}
	private Cat(int a) {
		System.out.println("˽�еĹ��캯��");
	}
	Cat(String b){
		System.out.println("Ĭ�ϵĹ��캯��");
	}
	protected Cat(int a,String b) {
		System.out.println("�����Ĺ��캯��");
	}
}























