package DynamicProxy.JDK;

public class SmsServiceImpl implements SmsService{
    @Override
    public String send(String message) {
        System.out.println("真实类短信发送: "+message);
        return message;
    }
}
