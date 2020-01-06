import java.util.List;
import java.util.Arrays;
public class Solution {

   public int[] sortArrayByParityII(int[] A) {
    int []tmp=new int[A.length];
    int i=0,j=1;
    for(int a:A){
        if(a%2==0){
            tmp[i]=a;
            i+=2;
        }else{
            tmp[j]=a;
            j+=2;
        }
    }
    for(int m=0;m<tmp.length;m++) {
        A[m]=tmp[m];
    }
       return A;
   }

}
