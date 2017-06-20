package contest37;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author boyang.lby
 * @date 6/18/17
 * @description
 */
public class MaximumDistanceinArrays {
    public int maxDistance(int[][] arrays) {
        int max = Integer.MIN_VALUE,min = Integer.MAX_VALUE;
        int maxIndex = -1,minIndex = -1;
        for(int i=0;i<arrays.length;i++){
            int[]arr = arrays[i];
            if(arr[arr.length-1]>max){
                max = arr[arr.length-1];
                maxIndex = i;
            }
            if(arr[0]<min){
                min= arr[0];
                minIndex= i;
            }
        }
        int tmp = minIndex;
        int tmp1 = maxIndex;
        int smax = maxIndex,smin = minIndex;
        if(maxIndex == minIndex){
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
            for(int i=0;i<arrays.length;i++){
                int[]arr = arrays[i];
                if(arr[arr.length-1]>max && i != tmp1){
                    max = arr[arr.length-1];
                    smax = i;
                }
                if(arr[0]<min && i != tmp){
                    min= arr[0];
                    smin = i;
                }
            }
        }
        return Math.max(arrays[maxIndex][arrays[maxIndex].length-1] - arrays[smin][0], arrays[smax][arrays[smax].length-1] - arrays[minIndex][0]);
    }
    public static void main(String[]args){
        new MaximumDistanceinArrays().maxDistance(new int[][]{{1,4},{0,5}});
    }
}
