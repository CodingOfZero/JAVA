package BasicAlgorithm;

import java.util.Arrays;

/**
 * 计数排序，时间复杂度为O(n)
 * 算法局限性：
 *      1. 只适用于整数排序
 *      2. 优化版的计数排序，当间距过大时，不适用，会浪费很多空间
 * 基础版：
 *      1.找到数组中的最大值max，创建长度为max的数组count
 *      2.对待排序数组中的每个元素，统计其出现的次数
 *      3.从左到右遍历count数组，如果元素不为0，输出对应次数的下标值
 *      注：不稳定排序
 */
public class CountSort {
    /**
     * 基础版
     * @param array
     * @return
     */
    public int[] countSortFirstVersion(int[] array){
        //1.
        int max=Arrays.stream(array).max().getAsInt();
        int[] count=new int[max+1];
        //2.
        int len=array.length;
        int[] res=new int[len];
        for(int x:array){
            count[x]++;
        }
        //3.
        int index=0;
        for(int i=0;i<max+1;i++){
            while (count[i]!=0){
                res[index++]=i;
                count[i]--;
            }
        }
        return res;
    }

    /**
     * 优化空间,利用差值创建数组
     * 在统计完出现次数后，对数组进行变形，组成前缀和数组
     * 然后从右往左逆序遍历array数组，array[i]对应的count数组中的元素即为排序后的次序。同时将count数组元素递减
     * 从右到左保证了出现同样元素时，可以稳定排序
     */
    public int[] countSortSecondVersion(int[] array){
        //1.
        int max=array[0];
        int min=array[0];
        for(int x:array){
            if(x>max){
                max=x;
            }
            if(x<min){
                min=x;
            }
        }
        int dis=max-min;
        int[] count=new int[dis+1];

        //2.
        int len=array.length;
        int[] res=new int[len];
        for(int x:array){
            count[x-min]++;
        }
        //3.前缀和
        for(int i=1;i<count.length;i++){
            count[i]+=count[i-1];
        }
        //4.逆序遍历
        int index=0;
        for(int i=array.length-1;i>=0;i--){
            res[count[array[i]-min]-1]=array[i];
            count[array[i]-min]--;
        }
        return res;
    }

    public static void main(String[] args) {
        CountSort countSort = new CountSort();
        int[] ints = countSort.countSortFirstVersion(new int[]{95,94,91,98,99,90,99,93,91,92});
        Arrays.stream(ints).forEach(i-> System.out.printf("%d ",i));
        System.out.println("len:"+ints.length);
    }
}
