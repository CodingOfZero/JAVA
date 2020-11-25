package ConcurrentTest;

import com.alibaba.fastjson.JSON;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 模拟直播间
 * 每一个直播间是一个topic，每个用户进入直播间会将自己的设备id绑定到这个topic上，即一个topic对应多个用户设备
 */
public class ConcurrentHashMapDemo {
    public static ConcurrentHashMap<String, List<String>> map=new ConcurrentHashMap<>();

    public static void main(String[] args) {
        //进入直播间1
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                List<String> list1=new CopyOnWriteArrayList<>();
                list1.add("device1");
                list1.add("device2");
                //map.put("topic1",list1);//不能使用put，它会覆盖先前的数据
                List<String> oldList = map.putIfAbsent("topic1", list1);
                if(null!=oldList){
                    oldList.addAll(list1);
                }
                System.out.println(JSON.toJSONString(map));
            }
        });
        //进入直播间1
        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                List<String> list1=new CopyOnWriteArrayList<>();
                list1.add("device11");
                list1.add("device22");
//                map.put("topic1",list1);
                List<String> oldList = map.putIfAbsent("topic1", list1);
                if(null!=oldList){
                    oldList.addAll(list1);
                }
                System.out.println(JSON.toJSONString(map));
            }
        });
        //进入直播间2
        Thread thread3=new Thread(new Runnable() {
            @Override
            public void run() {
                List<String> list1=new CopyOnWriteArrayList<>();
                list1.add("device111");
                list1.add("device222");
//                map.put("topic2",list1);
                List<String> oldList = map.putIfAbsent("topic2", list1);
                if(null!=oldList){
                    oldList.addAll(list1);
                }
                System.out.println(JSON.toJSONString(map));
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();
    }

}
