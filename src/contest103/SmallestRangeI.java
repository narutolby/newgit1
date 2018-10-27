package contest103;

import java.util.Arrays;

/**
 * @author boyang.lby
 * @date 9/23/18
 * @description
 */
public class SmallestRangeI {
    public int smallestRangeI(int[] A, int K) {
        if(A == null || A.length == 0){
            return 0;
        }
        Arrays.sort(A);
        return (A[A.length-1] - A[0])<=2 * Math.abs(K) ? 0 : (A[A.length - 1] - A[0] - 2 * Math.abs(K));
    }
}
