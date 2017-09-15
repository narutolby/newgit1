import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements equal, where a move is incrementing n - 1 elements by 1.

 Example:

 Input:
 [1,2,3]

 Output:
 3

 Explanation:
 Only three moves are needed (remember each move increments two elements):

 [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 */
public class MinimumMovestoEqualArrayElements {
    public int minMoves(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            min = Math.min(nums[i],min);
        }
        int ret = 0;
        for(int i=0;i<nums.length;i++){
            ret += nums[i] = min;
        }
        return ret;
    }

    public void buildHeap(int[]nums){
        int n = nums.length - 1;
        int s = (n - 1) / 2;
        for(int i=s;i>=0;i--){
            heapify(nums,i);
        }
    }

    public void heapify(int[]nums,int i){
        int left = 2 * i + 1,right = 2 * i + 2;
        int min = i;
        if(right < nums.length){
            min = nums[min]>nums[right] ? right : min;
        }
        if(left < nums.length){
            min = nums[min] > nums[left] ? left : min;
        }
        if(min != i){
            swap(nums,i,min);
            heapify(nums,min);
        }
    }

    public void swap(int[]nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
