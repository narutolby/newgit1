package contest87;

/**
 * Let's call any (contiguous) subarray B (of A) a mountain if the following properties hold:

 B.length >= 3
 There exists some 0 < i < B.length - 1 such that B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
 (Note that B could be any subarray of A, including the entire array A.)

 Given an array A of integers, return the length of the longest mountain.

 Return 0 if there is no mountain.

 Example 1:

 Input: [2,1,4,7,3,2,5]
 Output: 5
 Explanation: The largest mountain is [1,4,7,3,2] which has length 5.
 Example 2:

 Input: [2,2,2]
 Output: 0
 Explanation: There is no mountain.
 Note:

 0 <= A.length <= 10000
 0 <= A[i] <= 10000
 Follow up:

 Can you solve it using only one pass?
 Can you solve it in O(1) space?
 */
public class LongestMountaininArray {
    public int longestMountain(int[] A) {
        if(A.length <3){
            return 0;
        }
        int result = 0;
        for(int i=0;i<A.length;i++){
            boolean up = false;
            int start = i;
            while(i+1<A.length && A[i]<A[i+1] ){
                i++;
                up = true;
            }
            if(i+1 == A.length){
                break;
            }
            if(!up || A[i] == A[i+1]){
                continue;
            }
            boolean down = false;
            while(i+1<A.length && A[i]>A[i+1]){
                i++;
                down = true;
            }
            if(up && down){
                result = Math.max(result,i-start + 1);
            }
            i--;
        }
        return result>=3?result:0;
    }

    public static void main(String[]arg){
        System.out.println(new LongestMountaininArray().longestMountain(new int[]{875,884,239,731,723,685}));
    }
}
