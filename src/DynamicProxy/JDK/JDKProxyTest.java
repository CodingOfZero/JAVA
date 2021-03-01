package DynamicProxy.JDK;

public class JDKProxyTest {
    public static void main(String[] args) {
        SmsService proxyClass = (SmsService)JDKProxyFactory.getProxyClass(new SmsServiceImpl());
        proxyClass.send("你好");
    }
}
