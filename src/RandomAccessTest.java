import java.io.*;
import java.time.LocalDate;

/**
 * 二进制格式
 * 将三条记录写到一个数据文件中，然后以逆序将它们从文件中读回
 */
public class RandomAccessTest {
    public static void main(String[] args) throws IOException {
        Employee[] staff=new Employee[3];

        staff[0]=new Employee("Carl Cracker",75000,1987,12,15);
        staff[1]=new Employee("Harry Hacker",50000,1989,10,1);
        staff[2]=new Employee("Tony Tester",40000,1990,3,15);

        try (DataOutputStream out=new DataOutputStream(new FileOutputStream("employeeR.dat"))){
            for(Employee e:staff)
                writeData(out,e);
        }

        try (RandomAccessFile in=new RandomAccessFile("employeeR.dat","r")){
            int n=(int)(in.length()/Employee.RECORD_SIZE);//length返回文件字节数
            Employee[] newstaff=new Employee[n];

            for(int i=n-1;i>=0;i--){
                newstaff[i]=new Employee();
                in.seek(i*Employee.RECORD_SIZE);
                newstaff[i]=readData(in);
            }

            for(Employee e: newstaff)
                System.out.println(e);
        }
    }

    private static Employee readData(RandomAccessFile in) throws IOException {
        String name=readFixedString(Employee.NAME_SIZE,in);
        double salary=in.readDouble();
        int y=in.readInt();
        int m=in.readInt();
        int d=in.readInt();
        return new Employee(name,salary,y,m,d);
    }

    private static void writeData(DataOutputStream out, Employee e) throws IOException {
        writeFixedString(e.getName(),Employee.NAME_SIZE,out);
        out.writeDouble(e.getSalary());

        LocalDate hireDay=e.getHireDay();
        out.writeInt(hireDay.getYear());
        out.writeInt(hireDay.getMonthValue());
        out.writeInt(hireDay.getDayOfMonth());

    }
    //写出从字符串开头开始的指定数量的码元，如果码元过少，该方法将用0值补齐字符串
    public static void writeFixedString(String s,int size,DataOutput out)throws IOException{
        for(int i=0;i<size;i++){
            char ch=0;
            if(i<s.length()) ch=s.charAt(i);
            out.writeChar(ch);
        }
    }
    //从输入流中读入字符，直至读入size个码元，或者直到遇到具有0值的字符值，然后跳过输入字段中剩余的0值
    public static String readFixedString(int size,DataInput in)throws IOException{
        StringBuilder b=new StringBuilder();
        int i=0;
        boolean more=true;
        while (more&&i<size){
            char ch=in.readChar();
            i++;
            if(ch==0) more=false;
            else b.append(ch);
        }
        in.skipBytes(2*(size-i));
        return b.toString();
    }
}
