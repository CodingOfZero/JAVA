package DynamicProxy.CGLib;

public class CGLibTest {
    public static void main(String[] args) {
        AliSmsService proxyClass = (AliSmsService)CGLibFactoryClass.getProxyClass(AliSmsService.class);
        proxyClass.send("alibaba");
        proxyClass.sayHello();
    }
}
