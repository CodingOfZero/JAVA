package DynamicProxy.JDK;

import java.lang.reflect.Proxy;

public class JDKProxyFactory {
    public static Object getProxyClass(Object target){
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new JDKInvocationHandler(target)
        );
    }
}
