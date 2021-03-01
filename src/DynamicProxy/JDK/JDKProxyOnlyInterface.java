package DynamicProxy.JDK;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxyOnlyInterface<T> implements InvocationHandler {
    private final Class<T> proxyInterface;
    public JDKProxyOnlyInterface(Class<T> proxyInterface){
        this.proxyInterface=proxyInterface;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("前置...");
        System.out.println("处理..."+args[0]);
        System.out.println("后置...");
        return null;
    }

    //只有接口
    public  T getProxyByInterface(){
        return (T)Proxy.newProxyInstance(
                proxyInterface.getClassLoader(),
                new Class[]{proxyInterface},
                this
        );
    }
}
