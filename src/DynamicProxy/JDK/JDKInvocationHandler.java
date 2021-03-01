package DynamicProxy.JDK;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理的实现方式之一：JDK动态代理
 */
public class JDKInvocationHandler implements InvocationHandler {
    private final Object target;

    public JDKInvocationHandler(Object target){
        this.target=target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before invoke...");
        Object result = method.invoke(target, args);
        System.out.println("after invoke...");
        return result;
    }
}
