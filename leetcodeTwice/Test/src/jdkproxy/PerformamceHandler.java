package jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PerformamceHandler implements InvocationHandler {
	private Object target;

	public PerformamceHandler(Object target) {
		this.target = target;
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		PerformanceMonitor.begin(target.getClass().getName() + "." + method.getName());
		Object object = method.invoke(target, args);
		PerformanceMonitor.end();
		return object;
	}

}
