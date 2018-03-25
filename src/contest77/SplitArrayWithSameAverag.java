package contest77;

import java.util.Arrays;

/**
 * In a given integer array A, we must move every element of A to either list B or list C. (B and C initially start empty.)

 Return true if and only if after such a move, it is possible that the average value of B is equal to the average value of C, and B and C are both non-empty.

 Example :
 Input:
 [1,2,3,4,5,6,7,8]
 Output: true
 Explanation: We can split the array into [1,4,5,8] and [2,3,6,7], and both of them have the average of 4.5.
 Note:

 The length of A will be in the range [1, 30].
 A[i] will be in the range of [0, 10000].
 */
public class SplitArrayWithSameAverag {
    public boolean splitArraySameAverage(int[] A) {
//        int sum = 0;
//        for(int i=0;i<A.length;i++){
//            sum += A[i];
//        }
//        Arrays.sort(A);
//        int[][]dp = new int[A.length][sum];
//        float averge = sum/A.length;
//        for(int i=0;i<A.length;i++){
//            for(int j=1;j<=A.length;j++){
//                int capacity = averge * j;
//                if(averge * j < A[i]){
//                    dp[]
//                }
//            }
//        }
        return false;

    }
}
