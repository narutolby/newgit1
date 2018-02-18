package contest72;

/**
 * @author boyang.lby
 * @date 2/18/18
 * @description
 */

import java.util.Arrays;

/**
 * hard , no solution
 */

public class KthSmallestPrimeFraction {
    public int[] kthSmallestPrimeFraction(int[] a, int K) {
        if(a == null || a.length == 0){
            return a;
        }
        Arrays.sort(a);
        int  rep = 50;
        double low = 0, high = 1;
        while(rep-- > 0){
            double mid = low + (high - low) / 2;
            int num = 0;
            for(int i=0;i<a.length;i++){
                int index = Arrays.binarySearch(a,(int)(mid * a[i]));
                if(index < 0){
                    index = -index - 2;
                }
                num += index+1;
            }
            if(num <= K){
                high = mid;
            }else{
                low = mid;
            }
        }
        for(double e=1e-14;;e = e*10){
            for(int i=0;i<a.length;i++){
                double ln = high * a[i];
                for(int j=0;j<i;j++){
                    if(Math.abs(ln-a[j])<e){
                       return new int[]{a[j] ,a[i]};
                    }
                }
            }
        }
    }
    public static void main(String[]args){
       //new KthSmallestPrimeFraction().kthSmallestPrimeFraction(new int[]{1, 2, 3, 5},3);
        int [] a = new int[]{1,2,2,2,2,2,4,5,6,7};
        System.out.println(Arrays.binarySearch(a,2));
    }
}
