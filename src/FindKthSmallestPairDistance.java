import java.util.Arrays;

/**
 * @author boyang.lby
 * @date 11/13/17
 * @description
 */
public class FindKthSmallestPairDistance {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int h = nums[nums.length - 1] - nums[0];
        int l = Integer.MAX_VALUE;
        for(int i=1;i<nums.length;i++){
            l = Math.min(l,nums[i] - nums[i-1]);
        }
        while(l<h){
            int mid = l + (h - l)/2;
            if(check(nums,mid) <= k - 1){
                l = mid + 1;
            }else{
                h = mid;
            }
        }
        return h;
    }

    int check(int[]nums,int len){
        int count = 0;
        int slow = 0;
        for(int i=1;i<nums.length;i++){
           while(slow < i && nums[i] - nums[slow] > len) {
               slow++;
           }
            count += i - slow;
        }
        return count;
    }

    public static void main(String[]args){
        new FindKthSmallestPairDistance().smallestDistancePair(new int[]{9,10,7,10,6,1,5,4,9,8},18);
    }
}
