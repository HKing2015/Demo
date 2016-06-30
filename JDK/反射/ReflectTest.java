package com.tests;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;



public class ReflectTest {

	public static void main(String[] args) throws Exception {
		Person target = new OnePerson();
		Person person = (Person)ProxyFactory.getProxy(target);
		person.walk();
		person.hello();
	}

}

interface Person {
	public void walk();
	public void hello();
}

class OnePerson implements Person {
	public void walk() {
		System.out.println("person walk");
	}
	
	public void hello() {
		System.out.println("person hello");
	}
}

class AopClass {
	public void method1() {
		System.out.println("aop方法1");
	}
	
	public void method2() {
		System.out.println("aop方法2");
	}
}

//实现InvocationHandler类
class MyInvocationHandler implements InvocationHandler {
	private Object target;
	
	public MyInvocationHandler() {}
	public MyInvocationHandler(Object target) {
		this.target = target;
	}
	
	public Object invoke(Object proxy, Method method, Object[] args) throws Exception {
		AopClass aop = new AopClass();
		aop.method1();
		Object result = method.invoke(target, args);
		aop.method2();
		return result;
	}

	public Object getTarget() {
		return target;
	}

	public void setTarget(Object target) {
		this.target = target;
	}
}

//生成动态代理实例
class ProxyFactory {
	public static Object getProxy(Object target) {
		MyInvocationHandler handler = new MyInvocationHandler();
		handler.setTarget(target);
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), handler);
	}
}

