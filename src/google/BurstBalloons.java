package google;

/**
 * 312
 * Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.

 Find the maximum coins you can collect by bursting the balloons wisely.

 Note:
 (1) You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
 (2) 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100

 Example:

 Given [3, 1, 5, 8]

 Return 167

 nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 */
public class BurstBalloons {
    public int maxCoins(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        int ret = 0;
        for(int i=0;i<nums.length;i++){
            int tmp = 0;
            if(i == 0){
                tmp = nums[i] * nums[i+1];
            }else if(i == nums.length - 1){
                tmp = nums[i] * nums[i-1];
            }else{
                tmp = nums[i] * nums[i-1] * nums[i+1];
            }
            int[]newNums = deleteOne(i,nums);
            ret = Math.max(ret,tmp+maxCoins(newNums));
        }
        return ret;
    }

    public int[] deleteOne(int j,int[]nums){
        int[]ret = new int[nums.length - 1];
        int index = 0;
        for(int i=0;i<nums.length;i++){
            if(i == j) continue;
            ret[index++] = nums[i];
        }
        return ret;
    }
}
