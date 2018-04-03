package contest74;

import java.util.HashSet;
import java.util.Set;

/**
 * We are given an array A of positive integers, and two positive integers L and R (L <= R).
 *
 * Return the number of (contiguous, non-empty) subarrays such that the value of the maximum array element in that
 * subarray is at least L and at most R.
 *
 * Example :
 * Input:
 * A = [2, 1, 4, 3]
 * L = 2
 * R = 3
 * Output: 3
 * Explanation: There are three subarrays that meet the requirements: [2], [2, 1], [3].
 * Note:
 *
 * L, R  and A[i] will be an integer in the range [0, 10^9].
 * The length of A will be in the range of [1, 50000].
 * Discuss
 */
public class NumberofSubarrayswithBoundedMaximum {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        if(A == null || A.length == 0) {
            return 0;
        }
        return countSubarray(A,R) - countSubarray(A,L-1);
    }
    public int countSubarray(int[]A,int limit){
        int ret = 0;
        int count = 0;
        for(int i=0;i<A.length;i++){
            if(A[i]<=limit){
                count++;
            }else{
                count = 0;
            }
            ret +=count;
        }
        return ret;
    }

    public boolean isValid(int num,int L,int R){
        return num>=L && num<=R;
    }

    public static void main(String[]args){
       System.out.println(new NumberofSubarrayswithBoundedMaximum().numSubarrayBoundedMax(
           new int[] {2,1,4,3},2, 3));
    }
}
