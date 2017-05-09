package thinkinjava.test13.proxy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MethodSelector implements InvocationHandler{
	private Object proxied;
	public MethodSelector(Object proxied){
		this.proxied=proxied;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		if(method.getName().equals("interesting")){
			System.out.println("Proxy deleted thd interesting method!");
			 method.invoke(proxied, args);
		}
		else if(!method.getName().equals("boring1")){
			System.out.println("hello");
			 method.invoke(proxied, args);
		}
		return null;
	}

}
