/**
 * 杨辉三角：第n行的m个数可表示为 C(n，m)，即为从n个不同元素中取m个元素的组合数。n定义为0
 *
 * */
public class IrregularArray {
    public static void main(String[] args){
        final int NMAX=10;
        //首先分配一个具有所含行数的数组
        int[][] odds=new int[NMAX+1][];
        //分配这些行
        for(int j=0;j<=NMAX;j++)
            odds[j]=new int[j+1];
        //组合数
        for(int n=0;n<odds.length;n++){
            for(int k=0;k<odds[n].length;k++){
                int lott=1;
                for(int i=1;i<=k;i++)
                    lott=lott*(n-i+1)/i;
                odds[n][k]=lott;
            }
        }
        //输出结果
        for(int[] row:odds){
            for(int odd:row){
                System.out.printf("%4d",odd);
            }
            System.out.println();
        }
    }
}
