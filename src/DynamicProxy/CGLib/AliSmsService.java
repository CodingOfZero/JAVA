package DynamicProxy.CGLib;

/**
 * 使用CGLib来进行代理，与JDK动态代理相比，可以代理没有实现接口的类，由于实际上生成一个被代理
 * 的子类，因此不能代理final修饰的类
 */
public class AliSmsService {
    public String send(String message) {
        System.out.println("真实类短信发送: "+message);
        return message;
    }
    public void sayHello(){
        System.out.println("hello");
    }
}
