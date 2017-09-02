package contest47;

public class NondecreasingArray {
    public boolean checkPossibility(int[] nums) {
        if(nums == null || nums.length== 0){
            return true;
        }
        int cnt = 0;
        for(int i=1;i<nums.length;i++){
            if(nums[i] < nums[i-1]){
                cnt++;
                if (i == 1) nums[i-1] = nums[i];
                else if( i == nums.length - 1) nums[i] = nums[i-1];
                else if(nums[i] >= nums[i-2]) nums[i-1] = nums[i];
                else nums[i] = nums[i-1];
                if(cnt > 1){
                    return false;
                }
            }
        }
        return true;
    }
}
