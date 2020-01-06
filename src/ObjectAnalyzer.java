import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public class ObjectAnalyzer {
    private ArrayList<Object> visited=new ArrayList<>();//记录已被访问过的对象，防止无限递归
    public String toString(Object obj){
        if(obj==null)return "null";
        if(visited.contains(obj)) return "...";
        visited.add(obj);

        Class cl=obj.getClass();
        if(cl==String.class)return (String)obj;
        if(cl.isArray()){
            String r=cl.getComponentType()+"[]{";
            for(int i=0;i< Array.getLength(obj);i++){
                if(i>0) r+=",";
                Object val=Array.get(obj,i);
                if(cl.getComponentType().isPrimitive()) r+=val;//判断是否为基本类型
                else r+= toString(val);//不是基本类型，递归调用
            }
            return r+"}";
        }

        String r=cl.getName();
        do{
            r+="[";
            Field[] fields=cl.getDeclaredFields();
            AccessibleObject.setAccessible(fields,true);

            for(Field f:fields){
                if(!Modifier.isStatic(f.getModifiers())){
                    if(!r.endsWith("[")) r+=",";
                    r+=f.getName()+"=";
                    try {
                        Class t=f.getType();
                        Object val=f.get(obj);//获得可访问域的值
                        if(t.isPrimitive()) r+=val;
                        else r+= toString(val);//递归调用
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                }
            }

            r+="]";
            cl=cl.getSuperclass();

        }while(cl!=null);
        return r;
    }
}
