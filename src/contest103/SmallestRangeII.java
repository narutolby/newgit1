package contest103;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringJoiner;

/**
 * @author boyang.lby
 * @date 9/23/18
 * @description
 */
public class SmallestRangeII {
    private static int[] A = new int[]{1,2,3,4,5};
    private static int[]output = new int[5];
    public static void smallestRangeII(int currernt,int len) {
        if(currernt > A.length-1){
            System.out.println(Arrays.toString(output));
            return;
        }
        for(int i=0;i<=1;i++){
            if(i == 0){
                smallestRangeII(currernt+1,len);
            }else{
                output[len] = A[currernt];
                smallestRangeII(currernt+1,len+1);
            }
        }
    }
    public static void main(String[]args){
        smallestRangeII(0,0);
    }

}
